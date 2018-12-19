package com.example.root.rehberodev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Veritabani extends SQLiteOpenHelper {


    public Veritabani(Context context) {
        super(context, "veritabani",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table rehber(id integer not null primary key autoincrement,veri text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists rehber");
        onCreate(db);
    }

    public void ekle(String veri)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        try
        {
            ContentValues contentValues=new ContentValues();
            contentValues.put("veri",veri);
            db.insert("rehber",null,contentValues);
        }
        catch (Exception e)
        {

        }
        db.close();
    }

    public Cursor getir()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try
        {
            Cursor cursor=db.rawQuery("select * from rehber",null);
            return cursor;
        }
        catch (Exception e)
        {

        }
        return null;
    }

    public void sil(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try
        {
            db.delete("rehber","id=?",new String[]{id});
        }
        catch (Exception e)
        {

        }
    }
}
