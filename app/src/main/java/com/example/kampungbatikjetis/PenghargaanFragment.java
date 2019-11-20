package com.example.kampungbatikjetis;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kampungbatikjetis.Adapter.PenghargaanAdapter;
import com.example.kampungbatikjetis.Model.ArticleModel;
import com.example.kampungbatikjetis.Model.PenghargaanModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PenghargaanFragment extends Fragment {

    private RecyclerView recyclerViewPenghargaan;
    private PenghargaanAdapter penghargaanAdapter;
    private List<PenghargaanModel> penghargaanData = new ArrayList<>();

    private ImageView backButton;

    public PenghargaanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_penghargaan, container, false);

        recyclerViewPenghargaan = view.findViewById(R.id.recycler_penghargaan);

        backButton = view.findViewById(R.id.button_back);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (penghargaanData.isEmpty()) {
            addPenghargaanData();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        recyclerViewPenghargaan.setLayoutManager(new LinearLayoutManager(getContext()));
        penghargaanAdapter = new PenghargaanAdapter(getContext(), penghargaanData);
        recyclerViewPenghargaan.setAdapter(penghargaanAdapter);
        penghargaanAdapter.setOnItemClickListener(new PenghargaanAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(PenghargaanModel penghargaanModel) {
                ArticleFragment articleFragment = new ArticleFragment();
                articleFragment.setArticle(new ArticleModel(penghargaanModel.getImageId(), penghargaanModel.getTextTitle(), penghargaanModel.getTextDate(), penghargaanModel.getTextDescription()));
                changeFragment(articleFragment);
            }
        });
    }

    private void addPenghargaanData() {
        penghargaanData.add(new PenghargaanModel(R.drawable.penghargaan1_full, "Munali Patah Award 2019", "2019", "Munali Patah merupakan nama seorang seniman lengendaris yang berasal dari Kabupaten Sidoarjo. Munali tinggal di Desa Banjar Kemantren, Buduran. Tahun 80-an sepak terjang Munali Patah di dunia kesenian dan kebudayaan sudah diakui hingga kancah internasional, salah satu karya Munali Patah yang hingga kini tetap dilestarikan adalah Tarian Remo.\n" +
                "\n" +
                "Untuk mengingat dan menyampaikan bentuk apresiasi kepada generasi muda sebagai tokoh seni dan budaya maka diselenggarakanlah kegiatan Munali Patah Award yang diadakan setiap dua tahun sekali sebagai ajang penghargaan kepada seniman dan budayawan Sidoarjo.\n" +
                "\n" +
                "Terdapat tujuh kategori yang salah satunya yaitu kategori pelopor diberikan kebada Khomasatim Kampoeng Batik-Jetis. Penghargaan Munali Patah Award 2019 diserahkan oleh Bupati Sidoarjo, Saiful Ilah didampingi Ketua Dekesda Sidoarjo, Ketua DPRD Sidoarjo Usman, Dandim 0816/Sidoarjo Letkol. Inf. Muhammad Iswan Nuri dan Sekda Ahmad Zaini, pada Rabu (18/9), di Hall Mal Pelayanan Publik Kabupaten Sidoarjo, Raya Lingkar Timur.\n" +
                "\n" +
                "Dalam ajang penghargaan ini merupakan bentuk kepedulian pemkab Sidoarjo dalam mendukung perkembangan seni dan budaya dimana pemerintah sebagai jembatan atau fasilitator dalam mengekspos karya-karya.\n"));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setFragment((fragment));
    }
}
