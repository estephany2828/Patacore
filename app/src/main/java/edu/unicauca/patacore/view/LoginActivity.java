package edu.unicauca.patacore.view;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.MainMenuActivity;


//implements View.OnClickListener
public class LoginActivity extends AppCompatActivity{


    //Declara varables
    Button loginButton;
    ToggleButton toggleButton;
    EditText usernameEditText;
    EditText passwordEditText;
    ProgressBar loadingProgressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //loginButton.setOnClickListener(this)

    }
    public void goMenuPrincipal(View view){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }




  /*  @Override
   public void onClick(View view) {
        //loadingProgressBar.setVisibility(View.VISIBLE);
        loginViewModel.login(usernameEditText.getText().toString(),
                passwordEditText.getText().toString());
        goMenuPrincipal(view);

    }  */
}
