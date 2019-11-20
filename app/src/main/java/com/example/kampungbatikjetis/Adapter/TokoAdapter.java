package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.TokoModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

public class TokoAdapter extends RecyclerView.Adapter<TokoAdapter.ViewHolder> {

    private Context mContext;
    private List<TokoModel> dataset;
    private OnItemClickListener onItemClickListener;

    public TokoAdapter(Context mContext, List<TokoModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toko, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TokoModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
        holder.imageToko.setImageResource(data.getImageId());
        holder.namaToko.setText(data.getNamaToko());
        holder.nomorTelpToko.setText(data.getNomorTelpToko());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(TokoModel tokoModel);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageToko;
        private TextView namaToko;
        private TextView nomorTelpToko;
        private ConstraintLayout cardToko;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageToko = itemView.findViewById(R.id.image_toko);
            namaToko = itemView.findViewById(R.id.text_nama_toko);
            nomorTelpToko = itemView.findViewById(R.id.text_nomor_toko);
            cardToko = itemView.findViewById(R.id.card_toko);
        }

        public void bind(final TokoModel tokoModel, final OnItemClickListener listener) {
            cardToko.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(tokoModel);
                }
            });
        }
    }
}
