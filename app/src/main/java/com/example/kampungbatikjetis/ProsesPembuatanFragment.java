package com.example.kampungbatikjetis;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.kampungbatikjetis.Adapter.ProsesPembuatanAdapter;
import com.example.kampungbatikjetis.Model.ProsesPembuatanModel;

import java.util.ArrayList;
import java.util.List;

import static com.makeramen.roundedimageview.RoundedImageView.TAG;


public class ProsesPembuatanFragment extends Fragment {

    private RecyclerView recyclerViewProses;
    private ProsesPembuatanAdapter prosesPembuatanAdapter;
    private List<ProsesPembuatanModel> prosesPembuatanData = new ArrayList<>();

    private Animator currentAnimator;
    private int shortAnimationDuration;

    private RelativeLayout transparentBlack;

    private View view;

    private ImageView backButton;

    // These matrices will be used to move and zoom image
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // We can be in one of these 3 states
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // Remember some things for zooming
    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;
    String savedItemClicked;

    public ProsesPembuatanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_proses_pembuatan, container, false);

        recyclerViewProses = view.findViewById(R.id.recycler_proses_pembuatan);

        transparentBlack = view.findViewById(R.id.transparent_layout);

        backButton = view.findViewById(R.id.button_back);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (prosesPembuatanData.isEmpty()) {
            addProsesPembuatanData();
        }

        recyclerViewProses.setLayoutManager(new LinearLayoutManager(getContext()));
        prosesPembuatanAdapter = new ProsesPembuatanAdapter(getContext(), prosesPembuatanData);
        recyclerViewProses.setAdapter(prosesPembuatanAdapter);

        prosesPembuatanAdapter.setOnItemClickListener(new ProsesPembuatanAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ProsesPembuatanModel prosesPembuatanModel, View view) {
                zoomImageFromThumb(view, prosesPembuatanModel.getImageID());
            }
        });

        // Retrieve and cache the system's default "short" animation time.
        shortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    private void addProsesPembuatanData() {
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo1, "Pekerja membatik pada sebuah kain di sebuah industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo2, "Mangkuk tembikar berisi cairan malam panas dibakar di atas tungku di sebuah industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo3, "Pekerja melarutkan malam pada kain batik pada sebuah tungku di sebuah industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo4, "Pekerja melakukan pencucian pada batik usai di sebuah industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo5, "Pekerja menjemur batik di sebuah industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo6, "Mangkuk dan timbangan untuk mengukur ketebalan pewarnaan sebuah kain batik di industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo7, "Motif-motif batik yang didominasi bentuk flora dan fauna khas Sidoarjo di industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo8, "Motif-motif batik yang didominasi bentuk flora dan fauna khas Sidoarjo di industri rumahan\n\n"));
        prosesPembuatanData.add(new ProsesPembuatanModel(R.drawable.proses_photo9, "Pekerja menunjukkan kain batik yang siap dipasarkan di sebuah industri rumahan\n\n"));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (currentAnimator != null) {
            currentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) view.findViewById(
                R.id.expanded_image);
        expandedImageView.setImageResource(imageResId);

        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        view.findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f))
                .with(ObjectAnimator.ofFloat(expandedImageView,
                        View.SCALE_Y, startScale, 1f));
        set.setDuration(shortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                currentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                currentAnimator = null;
            }
        });
        transparentBlack.setVisibility(View.VISIBLE);
        set.start();
        currentAnimator = set;
//        expandedImageView.setOnTouchListener(this);

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAnimator != null) {
                    currentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(shortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        currentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        currentAnimator = null;
                    }
                });
                transparentBlack.setVisibility(View.INVISIBLE);
                set.start();
                currentAnimator = set;
            }
        });
    }
}
