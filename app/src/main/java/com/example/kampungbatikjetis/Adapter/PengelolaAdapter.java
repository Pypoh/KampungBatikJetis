package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.PengelolaModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PengelolaAdapter extends RecyclerView.Adapter<PengelolaAdapter.ViewHolder> {

    private Context mContext;
    private List<PengelolaModel> dataset;
    private OnItemClickListener onItemClickListener;

    public PengelolaAdapter(Context mContext, List<PengelolaModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengelola, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PengelolaModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
//        holder.profileImage.setImageResource(data.getImageId());
        holder.namaPengelola.setText(data.getNama());
        holder.nomorTelpPengelola.setText(data.getNomor_telp());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(PengelolaModel pengelolaModel);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView profileImage;
        private TextView namaPengelola;
        private TextView nomorTelpPengelola;
        private CardView cardPengelola;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.image_profile_pengelola);
            namaPengelola = itemView.findViewById(R.id.text_nama_pengelola);
            nomorTelpPengelola = itemView.findViewById(R.id.text_nomor_pengelola);
            cardPengelola = itemView.findViewById(R.id.card_pengelola);
        }

        public void bind(final PengelolaModel infoModel, final OnItemClickListener listener) {
            cardPengelola.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(infoModel);
                }
            });
        }
    }
}
