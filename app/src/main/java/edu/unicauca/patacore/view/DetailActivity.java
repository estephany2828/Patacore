package edu.unicauca.patacore.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import edu.unicauca.patacore.R;

public class DetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        showToolbar(getResources().getString(R.string.app_name), true);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showToolbar(String title, boolean upBotton){
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);


    }
}
