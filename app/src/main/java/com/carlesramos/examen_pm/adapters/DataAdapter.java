package com.carlesramos.examen_pm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carlesramos.examen_pm.R;
import com.carlesramos.examen_pm.interficies.IMiListener;
import com.carlesramos.examen_pm.model.ModelClass;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ModelViewHolder>{

    private IMiListener listener;
    private ModelClass[] modelClasses;

    public DataAdapter(IMiListener listener, ModelClass[] modelClasses) {
        this.listener = listener;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ModelViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        ModelClass modelClass = modelClasses[position];
        holder.bindModel(modelClass);
    }

    @Override
    public int getItemCount() {
        return modelClasses.length;
    }


    public static class ModelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //elements de la llista a rellenar!!

        private IMiListener listener;
        public ModelViewHolder(@NonNull View itemView, IMiListener listener) {
            super(itemView);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindModel(ModelClass modelClass){
            // pose valors als textsviews i altres elements

        }


        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onItemSelected(getAdapterPosition());
            }
        }
    }
}
