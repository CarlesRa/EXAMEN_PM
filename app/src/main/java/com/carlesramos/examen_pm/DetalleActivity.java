package com.carlesramos.examen_pm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.carlesramos.examen_pm.fragments.FragmentDetalle;
import com.carlesramos.examen_pm.model.ModelClass;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.carlesramos.fragments.EXTRA_TEXTO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentDetalle detalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        detalle.mostrarDetalle((ModelClass)getIntent().getSerializableExtra(EXTRA_TEXTO));
    }
}
