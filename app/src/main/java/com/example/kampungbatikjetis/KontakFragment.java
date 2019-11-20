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

import com.example.kampungbatikjetis.Adapter.PengelolaAdapter;
import com.example.kampungbatikjetis.Adapter.TokoAdapter;
import com.example.kampungbatikjetis.Model.PengelolaModel;
import com.example.kampungbatikjetis.Model.TokoModel;
import com.example.kampungbatikjetis.Model.UlasanModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class KontakFragment extends Fragment {

    private RecyclerView recyclerViewPengelola;
    private RecyclerView recyclerViewToko;

    private PengelolaAdapter pengelolaAdapter;
    private TokoAdapter tokoAdapter;

    private List<PengelolaModel> pengelolaData = new ArrayList<>();
    private List<TokoModel> tokoData = new ArrayList<>();

    public KontakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        recyclerViewPengelola = view.findViewById(R.id.recycler_pengelola);
        recyclerViewToko = view.findViewById(R.id.recycler_toko);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (pengelolaData.isEmpty()) {
            addPengelolaData();
        }

        if (tokoData.isEmpty()) {
            addTokoData();
        }

        recyclerViewPengelola.setLayoutManager(new LinearLayoutManager(getContext()));
        pengelolaAdapter = new PengelolaAdapter(getContext(), pengelolaData);
        recyclerViewPengelola.setAdapter(pengelolaAdapter);
        pengelolaAdapter.setOnItemClickListener(new PengelolaAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(PengelolaModel pengelolaModel) {
                PengelolaFragment pengelolaFragment = new PengelolaFragment();
                pengelolaFragment.setDataPengelola(pengelolaModel);
                changeFragment(pengelolaFragment);
            }
        });

        recyclerViewToko.setLayoutManager(new LinearLayoutManager(getContext()));
        tokoAdapter = new TokoAdapter(getContext(), tokoData);
        recyclerViewToko.setAdapter(tokoAdapter);
        tokoAdapter.setOnItemClickListener(new TokoAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(TokoModel tokoModel) {
                TokoFragment pengelolaFragment = new TokoFragment();
                pengelolaFragment.setTokoModel(tokoModel);
                changeFragment(pengelolaFragment);
            }
        });


    }

    private void addTokoData() {
        tokoData.add(new TokoModel(R.drawable.toko1, "Amri Batik Tulis", "(031) 8967231", "Jalan Diponegoro Pasar Jetis No. 105, Lemah Putro, Lemahputro, Kec. Sidoarjo, Kabupaten Sidoarjo, Jawa Timur 61213", new ArrayList<UlasanModel>(), new ArrayList<Integer>()));
        tokoData.add(new TokoModel(R.drawable.toko2, "NAVA COLLECTION", "0812-5975-6331", "Jl. Pasar Jetis No.106, Kwadengan Timur, Lemahputro, Kec. Sidoarjo, Kabupaten Sidoarjo, Jawa Timur 61213", new ArrayList<UlasanModel>(), new ArrayList<Integer>()));
        tokoData.add(new TokoModel(R.drawable.toko3, "Lathifah", "(031) 8949595", "Jl. Pasar Jetis No.2, Kwadengan Timur, Lemahputro, Kec. Sidoarjo, Kabupaten Sidoarjo, Jawa Timur 61213", new ArrayList<UlasanModel>(), new ArrayList<Integer>()));
    }

    private void addPengelolaData() {
        pengelolaData.add(new PengelolaModel("Audi Azzura Falaq", "Ketua RT", "+62 813 1234 1234", "Jl. Pasar Jetis", 0));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setFragment((fragment));
    }

}
