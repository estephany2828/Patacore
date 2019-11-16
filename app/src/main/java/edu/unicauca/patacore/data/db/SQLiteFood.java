package edu.unicauca.patacore.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteFood extends SQLiteOpenHelper {


    public SQLiteFood(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //PARA CREAR LA TABLA FOOD ES LA QUE CREA LOS PLATOS
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }
    public void insertData(String name, String price, byte[] imagePlato){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, imagePlato);
        statement.executeInsert();

    }
    public Cursor getData(String sql){
        SQLiteDatabase database= getReadableDatabase();
        return database.rawQuery(sql, null);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //CREAR PEDIDO

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
