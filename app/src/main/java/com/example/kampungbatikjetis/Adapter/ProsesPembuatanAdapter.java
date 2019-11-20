package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.ProsesPembuatanModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

public class ProsesPembuatanAdapter extends RecyclerView.Adapter<ProsesPembuatanAdapter.ViewHolder> {

    private Context mContext;
    private List<ProsesPembuatanModel> dataset;
    private OnItemClickListener onItemClickListener;

    public ProsesPembuatanAdapter(Context mContext, List<ProsesPembuatanModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proses_pembuatan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProsesPembuatanModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
        holder.imageProses.setImageResource(data.getImageID());
        holder.textView.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        Log.d("datasetSizeProses", dataset.size() + "");
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ProsesPembuatanModel prosesPembuatanModel, View view);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageProses;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProses = itemView.findViewById(R.id.image_proses_pembuatan);
            textView = itemView.findViewById(R.id.text_proses_pembuatan);
        }

        public void bind(final ProsesPembuatanModel prosesPembuatanModel, final OnItemClickListener listener) {
            imageProses.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(prosesPembuatanModel, imageProses);
                }
            });
        }
    }
}
