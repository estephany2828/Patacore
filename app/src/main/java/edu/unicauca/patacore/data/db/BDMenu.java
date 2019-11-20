package edu.unicauca.patacore.data.db;

public class BDMenu {

    public static final String TABLE_MENU = "FOOD";
    public static final String CREAT_TABLE = "Food";
    public static final String COLUMN_ID = "id_food";
    public static final String COLUMN_FOOD_NAME = "name";
    public static final String COLUMN_FOOD_PRICE = "price";
    public static final String COLUMN_FOOD_IMAGE = "image";

    public static final String CREATE_TABLA_MENU="CREATE TABLE IF NOT EXISTS"+ TABLE_MENU +
            "("+COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_FOOD_NAME +" VARCHAR,"+
            COLUMN_FOOD_NAME +" VARCHAR,"+
            COLUMN_FOOD_IMAGE +"BLOB)";

    public static final String CREATE_TABLE_FOOD= ("CREATE TABLE IF NOT EXISTS "+TABLE_MENU+
            "(id_food INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOG)");




    public static final String DELETE_TABLA_MENU="DROP TABLE IF EXISTS"+ TABLE_MENU;
    public static final String DELETE_TABLA_MEN="DROP TABLE IF EXISTS"+ CREAT_TABLE;
    public static final String DROG="DROP TABLE IF EXISTS"+ CREAT_TABLE;


};





/*

    public static final String TABLA_MENU="FOOD";
    public static final String CAMPO_NOMBRE="name";
    public static final String CAMPO_PRECIO="price";
    public static final String CAMPO_IMG="image";

    public static final String CREATE_TABLA_MENU="CREATE TABLE IF NOT EXISTS " +
            ""+TABLA_MENU+" (id_food INTEGER PRIMARY KEY AUTOINCREMENT "+CAMPO_NOMBRE+" VARCHAR,"+CAMPO_PRECIO+" VARCHAR, "+CAMPO_IMG+" BLOG)";
}
//sqLiteFood.queryData("CREATE TABLE IF NOT EXISTS FOOD(id_food INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOG)");

" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PERSON_NAME + " TEXT NOT NULL, " +
                COLUMN_PERSON_AGE + " NUMBER NOT NULL, " +
                COLUMN_PERSON_OCCUPATION + " TEXT NOT NULL, " +
                COLUMN_PERSON_IMAGE + " BLOB NOT NULL);"
        );

*/



