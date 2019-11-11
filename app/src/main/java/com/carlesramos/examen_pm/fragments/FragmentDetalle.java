package com.carlesramos.examen_pm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.carlesramos.examen_pm.R;
import com.carlesramos.examen_pm.model.ModelClass;

public class FragmentDetalle extends Fragment {
    //creem atributs per a tots el elements textView etc del layout


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detalle,container, false);

        //referenciem tots el atributs
        //exemple tvNombre = layout.findViewById(R.id.[nom]);
        return layout;
    }

    public void mostrarDetalle(ModelClass m){
        //donem valors a tots el atributs
    }
}
