package com.example.kampungbatikjetis;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kampungbatikjetis.Model.ArticleModel;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ArticleFragment extends Fragment {

    private ImageView articleImage;
    private TextView articleTitle;
    private TextView articleDate;
    private TextView articleDescription;

    private ImageView buttonBack;

    private ArticleModel articleModel = new ArticleModel();

    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article, container, false);

        articleImage = view.findViewById(R.id.image_article);
        articleTitle = view.findViewById(R.id.text_title_article);
        articleDate = view.findViewById(R.id.text_date_article);
        articleDescription = view.findViewById(R.id.text_description_article);

        buttonBack = view.findViewById(R.id.button_back);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (articleModel == null) {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Picasso.get().load(articleModel.getImageId()).into(articleImage);
            } catch (Exception e) {

            }
            articleTitle.setText(articleModel.getTitle());
            articleDate.setText(articleModel.getDate());
            if(articleModel.getDescription().contains("_n")){
                String newDescription = articleModel.getDescription().replace("_n","\n");
                articleDescription.setText(newDescription);
            } else {
                articleDescription.setText(articleModel.getDescription());
            }
            buttonBack.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View v) {
                    Objects.requireNonNull(getActivity()).onBackPressed();
                }
            });
        }


    }

    public void setArticle(ArticleModel article) {
        this.articleModel = article;
    }
}
