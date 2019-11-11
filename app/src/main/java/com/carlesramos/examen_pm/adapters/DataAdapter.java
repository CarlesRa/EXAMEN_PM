package com.carlesramos.examen_pm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.examen_pm.R;
import com.carlesramos.examen_pm.interficies.IMiListener;
import com.carlesramos.examen_pm.model.Star;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ModelViewHolder>{

    private IMiListener listener;
    private Star[] stars;

    public DataAdapter(IMiListener listener, Star[] stars) {
        this.listener = listener;
        this.stars = stars;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ModelViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        Star star = stars[position];
        holder.bindModel(star);
    }

    @Override
    public int getItemCount() {
        return stars.length;
    }


    public static class ModelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //atributs per referenciar elements del layout!!
        private TextView tvId;
        private TextView tvProper;
        private TextView tvDist;
        private TextView tvMag;
        private TextView tvSpect;
        private IMiListener listener;
        public ModelViewHolder(@NonNull View itemView, IMiListener listener) {
            super(itemView);

            //referencie els atributs del layout
            tvId = itemView.findViewById(R.id.tvId);
            tvProper = itemView.findViewById(R.id.tvPoper);
            tvDist = itemView.findViewById(R.id.tvDist);
            tvMag = itemView.findViewById(R.id.tvMag);
            tvSpect = itemView.findViewById(R.id.tvSpect);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindModel(Star star){
            // pose valors als textsviews i altres elements
            tvId.setText(String.valueOf(star.getId()));
            tvProper.setText(star.getProper());
            tvDist.setText(String.valueOf(star.getDist()));
            tvMag.setText(String.valueOf(star.getMag()));
            tvSpect.setText(star.getSpect());
        }


        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onItemSelected(getAdapterPosition());
            }
        }
    }
}
