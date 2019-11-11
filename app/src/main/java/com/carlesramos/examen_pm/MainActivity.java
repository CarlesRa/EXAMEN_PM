package com.carlesramos.examen_pm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.carlesramos.examen_pm.fragments.FragmentDetalle;
import com.carlesramos.examen_pm.fragments.FragmentListado;
import com.carlesramos.examen_pm.interficies.IMiListener;
import com.carlesramos.examen_pm.model.ModelClass;

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
        ModelClass modelClass = frgListado.getModelos()[position];

        if (hayDetalle) {
            FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
            frgDetalle.mostrarDetalle(modelClass);
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, modelClass);
            startActivity(i);
        }
    }
}
