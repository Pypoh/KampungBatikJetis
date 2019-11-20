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

import com.example.kampungbatikjetis.Model.InfoModel;
import com.example.kampungbatikjetis.R;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder>{

    private Context mContext;
    private List<InfoModel> dataset;
    private OnItemClickListener onItemClickListener;

    public InfoAdapter(Context mContext, List<InfoModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InfoModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
        holder.imageItem.setImageResource(data.getImageID());
        holder.textItem.setText(data.getInfoTitle());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(InfoModel infoModel, View view);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageItem;
        private TextView textItem;
        private CardView cardItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.image_info_item);
            textItem = itemView.findViewById(R.id.text_title_info_item);
            cardItem = itemView.findViewById(R.id.card_info_item);
        }
        public void bind(final InfoModel infoModel, final OnItemClickListener listener) {
            cardItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(infoModel, imageItem);
                }
            });
        }
    }
}
