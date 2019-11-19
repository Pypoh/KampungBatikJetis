package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.FasilitasModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

public class FasilitasAdapter extends RecyclerView.Adapter<FasilitasAdapter.ViewHolder> {

    private Context mContext;
    private List<FasilitasModel> dataset;

    public FasilitasAdapter(Context mContext, List<FasilitasModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fasilitas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FasilitasModel data = dataset.get(position);

        holder.imageItem.setImageResource(data.getImageID());
        holder.textTitle.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageItem;
        private TextView textTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.image_fasilitas);
            textTitle = itemView.findViewById(R.id.text_fasilitas);
        }
    }
}
