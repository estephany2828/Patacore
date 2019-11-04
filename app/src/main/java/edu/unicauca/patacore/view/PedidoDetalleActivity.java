package edu.unicauca.patacore.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import edu.unicauca.patacore.R;

public class PedidoDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_detalle);

    }
    public void showToolbar(String title, boolean upBotton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingList);
    }
}
