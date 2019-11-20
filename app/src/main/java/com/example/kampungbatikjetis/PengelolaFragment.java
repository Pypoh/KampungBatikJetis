package com.example.kampungbatikjetis;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kampungbatikjetis.Model.PengelolaModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class PengelolaFragment extends Fragment {

    private PengelolaModel pengelolaModel;

    private CircleImageView imagePengelola;
    private TextView textNamaPengelola;
    private TextView textJabatanPengelola;
    private TextView textNomorPengelola;
    private TextView textAlamatPengelola;

    private RelativeLayout nomorLayout;
    private RelativeLayout alamatLayout;

    private ImageView backButton;

    public PengelolaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengelola, container, false);

        imagePengelola = view.findViewById(R.id.image_pengelola);
        textNamaPengelola = view.findViewById(R.id.nama_pengelola);
        textJabatanPengelola = view.findViewById(R.id.jabatan_pengelola);
        textNomorPengelola = view.findViewById(R.id.text_nomor_telp_pengelola);
        textAlamatPengelola = view.findViewById(R.id.text_alamat_pengelola);

        nomorLayout = view.findViewById(R.id.layout_phone);
        alamatLayout = view.findViewById(R.id.layout_alamat);

        backButton = view.findViewById(R.id.button_back);

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

        if (pengelolaModel == null) {
            Toast.makeText(getContext(), "Terjadi error", Toast.LENGTH_SHORT).show();
        } else {
//            imagePengelola.setImageResource(0);
            textNamaPengelola.setText(pengelolaModel.getNama());
            textJabatanPengelola.setText(pengelolaModel.getJabatan());
            textNomorPengelola.setText(pengelolaModel.getNomor_telp());
            textAlamatPengelola.setText(pengelolaModel.getAlamat());
            nomorLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + pengelolaModel.getNomor_telp()));
                    startActivity(intent);
                }
            });

        }

    }

    public void setDataPengelola(PengelolaModel pengelola) {
        this.pengelolaModel = pengelola;
    }
}
