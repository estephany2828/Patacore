package edu.unicauca.patacore.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.data.db.SQLiteFood;
import edu.unicauca.patacore.model.Menu;

public class EditarPlatoActivity extends AppCompatActivity {
    private EditText foodPriceUpdate, descriptionUpdate, foodNameUpdate, imgUpdate;
    private Button updateFoodButton;
    private SQLiteFood sqLiteFood;
    private long receivedPersonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_plato);

        //init
        init();

        sqLiteFood = new SQLiteFood(this);

        try {
            //get intent to get person id
            receivedPersonId = getIntent().getLongExtra("MENU_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /***populate user data before update***/
        Menu menu = sqLiteFood.getMenuFood(receivedPersonId);
        //set field to this user data
        foodNameUpdate.setText(menu.getTxtNombre());
        foodPriceUpdate.setText(menu.getTxtPrecio());
        descriptionUpdate.setText(menu.getTxtDescription());
        imgUpdate.setText(menu.getImg());



        //listen to add button click to update
        updateFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                updatePerson();
            }
        });
       
    }

    private void updatePerson() {
        //create updated person
        String name = foodNameUpdate.getText().toString().trim();
        String price = foodPriceUpdate.getText().toString().trim();
        String img = imgUpdate.getText().toString().trim();
        String description = imgUpdate.getText().toString().trim();
        Menu updatedPerson = new Menu(name, price, img, description);

        //call dbhelper update
         sqLiteFood.updateMenuFoodRecord(receivedPersonId, this, updatedPerson);
    }

    private void init() {
        foodNameUpdate = (EditText)findViewById(R.id.foodNameUpdate);
        foodPriceUpdate = (EditText)findViewById(R.id.foodPriceUpdate);
        imgUpdate = (EditText)findViewById(R.id.imgUpdate);
        descriptionUpdate = (EditText)findViewById(R.id.descriptionUpdate);
        updateFoodButton = (Button)findViewById(R.id.updateFoodButton);
    }

}
