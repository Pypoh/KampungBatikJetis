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

import com.example.kampungbatikjetis.Adapter.InfoAdapter;
import com.example.kampungbatikjetis.Model.InfoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfoFragment extends Fragment {

    private RecyclerView recyclerViewInfo;
    private InfoAdapter infoAdapter;
    private List<InfoModel> infoData = new ArrayList<>();


    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        recyclerViewInfo = view.findViewById(R.id.recycler_info);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       if (infoData.isEmpty()) {
           addInfoData();
       }

        recyclerViewInfo.setLayoutManager(new LinearLayoutManager(getContext()));
        infoAdapter = new InfoAdapter(getContext(), infoData);
        recyclerViewInfo.setAdapter(infoAdapter);
        infoAdapter.setOnItemClickListener(new InfoAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(InfoModel infoModel, View view) {
                switch (infoModel.getInfoTitle()) {
                    case "Proses Pembuatan":
                        changeFragment(((MainActivity) Objects.requireNonNull(getActivity())).prosesPembuatanFragment);
                        break;
                    case "Event":
                        changeFragment(((MainActivity) Objects.requireNonNull(getActivity())).eventFragment);
                        break;
                    case "Penghargaan":
                        changeFragment(((MainActivity) Objects.requireNonNull(getActivity())).penghargaanFragment);
                        break;
                }
            }
        });
    }

    private void addInfoData() {
        infoData.add(new InfoModel(R.drawable.info_pembuatan, "Proses Pembuatan"));
        infoData.add(new InfoModel(R.drawable.info_event, "Event"));
        infoData.add(new InfoModel(R.drawable.info_penghargaan, "Penghargaan"));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setFragment((fragment));
    }



}
