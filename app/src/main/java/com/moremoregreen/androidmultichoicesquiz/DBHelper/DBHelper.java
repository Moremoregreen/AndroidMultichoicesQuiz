package com.moremoregreen.androidmultichoicesquiz.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.moremoregreen.androidmultichoicesquiz.Model.Category;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {
    public static final String DB_NAME = "Quiz2019.db";
    public static final int DB_VER = 1;

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    /*
    Get All Category From DB
     */
    public List<Category> getAllCategories(){
        SQLiteDatabase db = instance.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Category;",null);
        List<Category> categories = new ArrayList<>();
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Category category = new Category(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("Name")),
                        cursor.getString(cursor.getColumnIndex("Image")));
                categories.add(category);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return categories;
    }
}
