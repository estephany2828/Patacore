package edu.unicauca.patacore.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.view.fragment.AddOrdenFragment;
import edu.unicauca.patacore.view.fragment.DelOrdenFragment;
import edu.unicauca.patacore.view.fragment.ListarOrdenFragment;
import edu.unicauca.patacore.view.fragment.NewOrdenFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        BottomNavigationView bottombar = findViewById(R.id.bottombar);
//        bottombar.setSelectedItemId(R.id.newTab); //default


        bottombar.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {


                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int item =menuItem.getItemId();
                        switch (item) {
                            case R.id.newTab:
                                addFragment(new NewOrdenFragment());
                                break;
                            case R.id.listarTab:
                                addFragment(new ListarOrdenFragment());
                                break;
                            case R.id.adiccionarTab:
                                addFragment(new AddOrdenFragment());
                                break;
                            case R.id.delTab:
                                addFragment(new DelOrdenFragment());
                                break;
                        }

                        return true;
                    }
                });

    }

                    private void addFragment(Fragment fragment) {
                        if (null != fragment) {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.container, fragment)
                                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                    .addToBackStack(null)
                                    .commit();
                        }
                    }



}
