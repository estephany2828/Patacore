package edu.unicauca.patacore.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.data.db.SQLiteFood;
import edu.unicauca.patacore.model.Menu;
import edu.unicauca.patacore.view.fragment.MenuFragment;

public class AgregarPlatoActivity extends AppCompatActivity {
    EditText editTxtNombre, editTxtPrecio;
    Button btnAdd, btnDirMenu, btnBuscar;
    ImageView imageView;
    //public static SQLiteFood sqLiteFood;
    final int REQUEST_CODE_GALLERY=999;
    private SQLiteFood sqLiteFood; // class that extends SQLiteOpenHelper
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_plato);
        //variables
        init();
        //listen to add button
        sqLiteFood = new SQLiteFood(this);
        db= sqLiteFood.getWritableDatabase();

        //sqLiteFood.queryData("CREATE TABLE IF NOT EXISTS FOOD(id_food INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOG)");
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        AgregarPlatoActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();
            }
        });

    }


    public void agregar(){
        //sqLiteFood.insertData( "pollo", "5000", "https://image.freepik.com/foto-gratis/plato-pechuga-pollo_1205-4244.jpg");
        try {
            sqLiteFood.insertData(
                    editTxtNombre.getText().toString().trim(),
                    editTxtPrecio.getText().toString().trim(),
                    imageViewToByte(imageView)
            );
            Toast.makeText(getApplicationContext(), "Agregar plato", Toast.LENGTH_SHORT).show();
            editTxtNombre.setText("");
            editTxtPrecio.setText("");
            imageView.setImageResource(R.mipmap.ic_launcher);
            //goBackMenu();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();

        }
    }
    private void goBackMenu() {
        Intent intent= new Intent(AgregarPlatoActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode ==REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(getApplicationContext(), "No tienes permisos para acceder a la localizacion", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode== REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data !=null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);




    }

    private byte [] imageViewToByte(ImageView imageView) {
        Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray= stream.toByteArray();
        return  byteArray;

    }

    // agregamos a las variables lo que hay en los layaout
    public void  init(){
        editTxtNombre = findViewById(R.id.editTxtNombre);
        editTxtPrecio = findViewById(R.id.editTxtPrecio);
        btnAdd= findViewById(R.id.btnAdd);
        btnDirMenu=findViewById(R.id.btnDirMenu);
        btnBuscar=findViewById(R.id.btnBuscar);
        imageView=findViewById(R.id.imgPlato);
    }
}

/*

    private void saveMenuFood() {
        String name = editTxtNombre.getText().toString().trim();
        String price = editTxtPrecio.getText().toString().trim();
        byte[] image= imageViewToByte(imageView);



        //create new person
        Menu menu = new Menu(name, price, image);
        sqLiteFood.saveNewMenuFood(menu);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackMenu();

    }
//sqLiteFood = new SQLiteFood(this, "FoodDB.sqlite", null, 1);
        //crea la tabla food
        sqLiteFood.queryData("CREATE TABLE IF NOT EXISTS FOOD(id_food INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOG)");

lo que estaba en el botton agregar
try {
                    sqLiteFood.insertData(
                            editTxtNombre.getText().toString().trim(),
                            editTxtPrecio.getText().toString().trim(),

                            imageViewToByte(imageView)
                    );
                    Toast.makeText(getApplicationContext(), "Agregar plato", Toast.LENGTH_SHORT).show();
                    editTxtNombre.setText("");
                    editTxtPrecio.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);

                } catch (Exception e) {
                    e.printStackTrace();

                }

*/
