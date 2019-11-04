package edu.unicauca.patacore;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.icu.text.CaseMap;
import android.os.Build;
import android.os.Bundle;


import edu.unicauca.patacore.R;

public class MainMenuActivity extends AppCompatActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        showToolbar(getResources().getString(R.string.app_name), false);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showToolbar(String title, boolean upBotton){
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);

    }


}
