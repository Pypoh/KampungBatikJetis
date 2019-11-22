package com.example.kampungbatikjetis.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampungbatikjetis.Model.EventModel;
import com.example.kampungbatikjetis.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{

    private Context mContext;
    private List<EventModel>  dataset;
    private OnItemClickListener onItemClickListener;

    public EventAdapter(Context mContext, List<EventModel> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    public List<EventModel> getDataset() {
        return dataset;
    }

    public void setDataset(List<EventModel> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventModel data = dataset.get(position);
        holder.bind(data, onItemClickListener);
        try {
            Picasso.get().load(data.getImageID()).into(holder.imageEvent);
        } catch (Exception e) {
            Log.d("ImageLoadError", "Unable to load image");
        }
        holder.textTitleEvent.setText(data.getEventTitle());
        holder.textDateEvent.setText(data.getEventDate());
        holder.textDescriptionEvent.setText(data.getEventDescription());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(EventModel infoModel);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageEvent;
        private TextView textTitleEvent;
        private TextView textDateEvent;
        private TextView textDescriptionEvent;

        private CardView cardEvent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageEvent = itemView.findViewById(R.id.image_event);
            textTitleEvent = itemView.findViewById(R.id.event_title);
            textDateEvent = itemView.findViewById(R.id.event_date);
            textDescriptionEvent = itemView.findViewById(R.id.event_description);

            cardEvent = itemView.findViewById(R.id.card_event);
        }

        public void bind(final EventModel eventModel, final OnItemClickListener listener) {
            cardEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(eventModel);
                }
            });
        }
    }


}
