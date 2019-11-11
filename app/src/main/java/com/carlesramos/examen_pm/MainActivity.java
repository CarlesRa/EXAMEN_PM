package com.carlesramos.examen_pm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.carlesramos.examen_pm.fragments.FragmentListado;
import com.carlesramos.examen_pm.interficies.IMiListener;
import com.carlesramos.examen_pm.model.Star;

public class MainActivity extends AppCompatActivity implements IMiListener {
    private FragmentListado frgListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        frgListado.setListener(this);
    }

    @Override
    public void onItemSelected(int position) {
        StringBuilder sb = new StringBuilder();
        Star star = frgListado.getStars().get(position);
        Toast.makeText(this, "Ascension recta: " + star.getRa()
                + "\nDeclinación: " + star.getDec(), Toast.LENGTH_SHORT).show();
        sb.append("Id:").append(star.getId()).append(" Hip:").append(star.getHip()).append(" Bf:")
                .append(star.getBf()).append(" Proper:").append(star.getProper()).append(" Ra:")
                .append(star.getRa()).append(" Dec:").append(star.getDec()).append(" Dist:")
                .append(star.getDist()).append(" Mag:").append(star.getMag()).append(" Spect:")
                .append(star.getSpect());
        Log.i( "Complet Info:",sb.toString());
    }
}
