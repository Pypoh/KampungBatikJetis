package com.example.kampungbatikjetis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kampungbatikjetis.Model.TokoModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class TokoFragment extends Fragment {

    private List<Integer> daftarGambar = new ArrayList<>();
    private CarouselView carouselToko;
    private TextView namaToko;
    private TextView nomorTelpToko;
    private TextView alamatToko;

    private TokoModel tokoModel;

    private ImageView backButton;

    private RecyclerView recyclerViewUlasan;

    private RelativeLayout nomorLayout;

    public TokoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toko, container, false);

        carouselToko = view.findViewById(R.id.carouselToko);
        namaToko = view.findViewById(R.id.nama_toko);
        nomorTelpToko = view.findViewById(R.id.text_nomor_telp_toko);
        alamatToko = view.findViewById(R.id.text_alamat_toko);
        backButton = view.findViewById(R.id.button_back);

        nomorLayout = view.findViewById(R.id.layout_phone);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        if (daftarGambar.isEmpty()) {
            addDaftarGambar();
        }

        if (tokoModel == null) {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        } else {
            // Carousel
            carouselToko.setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(tokoModel.getImageId());
                }
            });

            carouselToko.setPageCount(1);


            namaToko.setText(tokoModel.getNamaToko());
            nomorTelpToko.setText(tokoModel.getNomorTelpToko());
            alamatToko.setText(tokoModel.getAlamatToko());

            nomorLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tokoModel.getNomorTelpToko()));
                    startActivity(intent);
                }
            });
        }
    }

    private void addDaftarGambar() {
        daftarGambar.add(R.drawable.proses_photo1);
    }

    public void setTokoModel(TokoModel tokoModel) {
        this.tokoModel = tokoModel;
    }
}
