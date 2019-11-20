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

import com.example.kampungbatikjetis.Adapter.EventAdapter;
import com.example.kampungbatikjetis.Model.ArticleModel;
import com.example.kampungbatikjetis.Model.EventModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventFragment extends Fragment {

    private RecyclerView recyclerViewEvent;
    private EventAdapter eventAdapter;
    private List<EventModel> eventData = new ArrayList<>();

    private ImageView backButton;

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerViewEvent = view.findViewById(R.id.recycler_event);

        backButton = view.findViewById(R.id.button_back);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (eventData.isEmpty()) {
            addEventData();
        }

        recyclerViewEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        eventAdapter = new EventAdapter(getContext(), eventData);
        recyclerViewEvent.setAdapter(eventAdapter);

        eventAdapter.setOnItemClickListener(new EventAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(EventModel infoModel) {
                ArticleFragment articleFragment = new ArticleFragment();
                articleFragment.setArticle(new ArticleModel(infoModel.getImageID(), infoModel.getEventTitle(), infoModel.getEventDate(), infoModel.getEventDescription()));
                changeFragment(articleFragment);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }

    private void addEventData() {
        eventData.add(new EventModel(R.drawable.event1_full, "Lomba Desain Motif Batik Sidoarjo", "22 Oktober - 30 November 2019", "Ayo ikut berpartisipasi dalan kreasi batik khas Sidoarjo di acara Lomba Desain Motif Batik Sidoarjo Rebut total hadiah 7.250.000 rupiah!\n\n"));
        eventData.add(new EventModel(R.drawable.event2_full, "Pameran Ekonomi Kreatif", "24 Agustus 2019", "Pameran Ekonomi Kreatif Berbasis Seni Budaya @upt pemberdayaan lembaga seni dan ekonomi kreatif wilwatikta prov. Jatim\n\n"));
        eventData.add(new EventModel(R.drawable.event3_full, "Gebyar Festival Kampung Batik Jetis Sidoarjo", "7 Oktober 2019 ", "Rasakan meriahnya Karnaval Batik diiringi dengan musisi keliling dan riuhnya bazaar UKM. \n\n"));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setFragment((fragment));
    }
}
