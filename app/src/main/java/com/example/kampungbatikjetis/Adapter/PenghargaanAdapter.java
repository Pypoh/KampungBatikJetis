package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.PenghargaanModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

public class PenghargaanAdapter extends RecyclerView.Adapter<PenghargaanAdapter.ViewHolder>{

    private Context mContext;
    private List<PenghargaanModel> dataset;
    private OnItemClickListener onItemClickListener;

    public PenghargaanAdapter(Context mContext, List<PenghargaanModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_penghargaan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PenghargaanModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
        holder.imagePenghargaan.setImageResource(data.getImageId());
        holder.textTitlePenghargaan.setText(data.getTextTitle());
        holder.textDatePenghargaan.setText(data.getTextDate());
        holder.textDescriptionPenghargaan.setText(data.getTextDescription());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(PenghargaanModel penghargaanModel);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePenghargaan;
        private TextView textTitlePenghargaan;
        private TextView textDatePenghargaan;
        private TextView textDescriptionPenghargaan;

        private CardView cardEvent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePenghargaan = itemView.findViewById(R.id.image_penghargaan);
            textTitlePenghargaan = itemView.findViewById(R.id.penghargaan_title);
            textDatePenghargaan = itemView.findViewById(R.id.penghargaan_date);
            textDescriptionPenghargaan = itemView.findViewById(R.id.penghargaan_description);

            cardEvent = itemView.findViewById(R.id.card_penghargaan);
        }

        public void bind(final PenghargaanModel penghargaanModel, final OnItemClickListener listener) {
            cardEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(penghargaanModel);
                }
            });
        }
    }
}
