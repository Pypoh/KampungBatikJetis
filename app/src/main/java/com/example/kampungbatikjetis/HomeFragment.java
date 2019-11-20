package com.example.kampungbatikjetis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kampungbatikjetis.Adapter.FasilitasAdapter;
import com.example.kampungbatikjetis.Model.FasilitasModel;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator2;

public class HomeFragment extends Fragment {

    private ImageView imageHomeTitle;
    private TextView _textDayaTarik;
    private RecyclerView recyclerViewFasilitas;
    private FasilitasAdapter fasilitasAdapter;

    private TextView _textTitleMap;
    private TextView _textDescMap;

    private List<FasilitasModel> fasilitasData = new ArrayList<>();

    private MapsFragment mapsFragment = new MapsFragment();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // View Bind
        imageHomeTitle = view.findViewById(R.id.image_title);
        _textDayaTarik = view.findViewById(R.id.text_description_daya_tarik);
        recyclerViewFasilitas = view.findViewById(R.id.recycler_fasilitas);
        _textTitleMap = view.findViewById(R.id.text_title_map);
        _textDescMap = view.findViewById(R.id.text_description_map);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Add Data
        String dayaTarikDescription = "Wisata Kampung Batik Jetis di Sidoarjo merupakan tempat wisata yang harus anda kunjungi karena pesona keindahannya tidak ada duanya. Penduduk lokal daerah lemah putro juga sangat ramah tamah terhadap wisatawan lokal maupun wisatawan asing.\n" +
                "\n" +
                "Kampung batik jetis mempunyai motif khas, yaitu motif burung merak yang merupakan salah satu batik khas Sidoarjo. Karena terletak di pusat kota atau tepatnya di Jalan Diponegoro Sidoarjo, sentra batik ini bisa dengan mudah ditemukan. Selain itu, di gapura masuknya terdapat tulisan ‘Kampung Batik Jetis’ super besar, sehingga bisa mempermudah wisatawan untuk berwisata belanja.";

        if (fasilitasData.isEmpty()) {
            addFasilitasData();
        }

        imageHomeTitle.setImageResource(R.drawable.home_artwork);

        String mapTitle = "Kampoeng Batik Jetis";
        String mapDesc = "Jl. P. Diponegoro, Lemah Putro, Lemahputro, Kec. Sidsoarjo, Kabupaten Sidoarjo, Jawa Timur 61213";

        _textDayaTarik.setText(dayaTarikDescription);

        recyclerViewFasilitas.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        fasilitasAdapter = new FasilitasAdapter(getContext(), fasilitasData);
        recyclerViewFasilitas.setAdapter(fasilitasAdapter);

        _textTitleMap.setText(mapTitle);
        _textDescMap.setText(mapDesc);

        setFragment(new MapsFragment());


    }

    @Override
    public void onResume() {
        super.onResume();
        setFragment(new MapsFragment());
    }

    private void addFasilitasData() {
        fasilitasData.add(new FasilitasModel(R.drawable.home_areaparkir, "Area Parkir"));
        fasilitasData.add(new FasilitasModel(R.drawable.home_musholla, "Musholla"));
        fasilitasData.add(new FasilitasModel(R.drawable.home_toilet, "Toilet"));
        fasilitasData.add(new FasilitasModel(R.drawable.home_restoran, "Restoran"));
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.maps_frame, fragment, "MAIN_FRAGMENT");
        ft.addToBackStack(null);
        ft.commit();
    }
}
