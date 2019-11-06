package edu.unicauca.patacore.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.unicauca.patacore.R;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setTitle(getIntent().getExtras().get("mesa").toString());
    }
}
