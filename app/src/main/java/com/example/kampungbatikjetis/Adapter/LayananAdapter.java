package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.LayananModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

public class LayananAdapter extends RecyclerView.Adapter<LayananAdapter.ViewHolder> {

    private Context mContext;
    private List<LayananModel> dataset;
    private OnItemClickListener onItemClickListener;

    public LayananAdapter(Context mContext, List<LayananModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LayananModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
        holder.imageLayanan.setImageResource(data.getImageID());
        holder.textTitleLayanan.setText(data.getTextTitle());
        holder.textDescLayanan.setText(data.getTextDesc());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(LayananModel layananModel, View view);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageLayanan;
        private TextView textTitleLayanan;
        private TextView textDescLayanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLayanan = itemView.findViewById(R.id.image_layanan);
            textTitleLayanan = itemView.findViewById(R.id.text_layanan_title);
            textDescLayanan = itemView.findViewById(R.id.text_layanan_desc);
        }

        public void bind(final LayananModel layananModel, final OnItemClickListener listener) {
            imageLayanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(layananModel, imageLayanan);
                }
            });
        }
    }
}
