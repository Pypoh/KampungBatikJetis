package com.example.kampungbatikjetis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SejarahFragment extends Fragment {

    private TextView _textDescriptionSejarah;

    public SejarahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sejarah, container, false);

        _textDescriptionSejarah = view.findViewById(R.id.text_description_sejarah);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Static Data
        String sejarahDescription = "Sejarah Batik Tulis Tradisional di Kabupaten Sidoarjo berpusat di Jetis yang sudah ada sejak tahun 1675. Batik ini mula-mula diajarkan oleh Mbah Mulyadi yang konon merupakan keturunan Raja Kediri yang lari ke Sidoarjo. Bersama para pengawalnya, Mbah Mulyadi mengawali berdagang di Pasar Kaget yang kini dikenal dengan nama Pasar Jetis.\n" +
                "\n" +
                "Seiring berjalannya waktu perkembangan penduduk, serta kian ramainya perdagangan di Pasar Jetis, kawasan ini banyak didatangi para pedagang dari luar daerah, terutama pedagang asal Madura. Para pedagang Madura ini sangat menyukai batik tulis buatan warga Jetis. Namun sayang, perkembangan Batik Jetis pada waktu itu tidak ada generasi yang mau melanjutkan perkembangan usaha ini.\n" +
                "\n" +
                "Mulai masuk tahun 1950-an usaha Batik Jetis didirikan lagi oleh seorang wanita yang bernama Widiarsih (Bu Wida) dan banyak masyarakat Kampung Jetis waktu itu masih menjadi pekerjanya. Usaha Batik Tulis Widiarsih pada waktu itu telah menjadi perusahaan terbesar di kampung Jetis, sekaligus banyak yang mengakui kalau bisnisnya menjadi bisnis batik tertua di kampung Jetis.  Tahun 1970-an, para mantan pekerja Widiarsih akhirnya memberanikan diri untuk membuat serta membuka bisnis batik tulis sendiri dirumahnya, yang akhirnya menjadi usaha masyarakat rumahan batik Jetis tulis ini.\n" +
                "\n" +
                "Dari sinilah usaha batik mulai menjadi usaha rumahan masyarakat Jetis. Usaha tersebut kemudian juga menjadi mata pencaharian utama mereka selama bertahun-tahun hingga sekarang. Sejak tahun 1975, Batik Jetis terkenal sebagai batik yang memiliki ciri khas warna berani seperti merah, kuning, hijau dan biru. Berbeda dengan Batik Solo dan Yogyakarta berwarna coklat atau sogan.";

        _textDescriptionSejarah.setText(sejarahDescription);

    }
}
