package com.carlesramos.examen_pm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.examen_pm.R;
import com.carlesramos.examen_pm.adapters.DataAdapter;
import com.carlesramos.examen_pm.interficies.IMiListener;
import com.carlesramos.examen_pm.model.Star;
import com.carlesramos.examen_pm.parsers.DataParser;
import java.util.ArrayList;

public class FragmentListado extends Fragment {

    private IMiListener listener;
    private RecyclerView rvListado;
    private ArrayList<Star> stars;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DataParser parser = new DataParser(getActivity());
        if (parser.parse()){
            stars = parser.getStars();
        }
        return inflater.inflate(R.layout.fragment_listado,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvListado = getView().findViewById(R.id.rvListado);
        rvListado.setAdapter(new DataAdapter(listener, stars));
        //prepare per a linearlayout vertical(aixo dependrá del tipus solicitat)
        rvListado.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
    }

    public void setListener(IMiListener listener) {
        this.listener = listener;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }
}
