package com.carlesramos.examen_pm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.carlesramos.examen_pm.fragments.FragmentDetalle;
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
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frgDetalle) != null);
        Star star = frgListado.getStars()[position];
        Toast.makeText(this, "Ascension recta: " + star.getRa()
                + "\nDeclinación: " + star.getDec(), Toast.LENGTH_SHORT).show();
        /*if (hayDetalle) {
            FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
            frgDetalle.mostrarDetalle(star);
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, star);
            startActivity(i);
        }*/
    }
}
