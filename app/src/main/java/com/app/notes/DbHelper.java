package com.app.notes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context c) {
        super(c, "notes.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"Notes\" (\n" +
                "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"Name\"\tTEXT,\n" +
                "\t\"Datee\"\tTEXT,\n" +
                "\t\"f\"\tINTEGER,\n" +
                "\t\"s\"\tINTEGER,\n" +
                "\t\"t\"\tINTEGER\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void Add(Notes n) {

        SQLiteDatabase db = getWritableDatabase();

        String id = "";
        if (n.id == 0) {
            id = "null";
        } else {
            id = String.valueOf(n.id);
        }

        String q = String.format("Replace INTO \"main\".\"Notes\"\n" +
                "(id,\"Name\", \"Datee\", \"f\", \"s\", \"t\")\n" +
                "VALUES (%s,'%s', '%s',%s ,%s,%s)", id, n.name, n.date, n.ff, n.ss, n.tt);
        db.execSQL(q);
    }


    public ArrayList<Notes> notes() {

        ArrayList<Notes> notes = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * from Notes", null);


        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String Date = cursor.getString(2);
            int ff = cursor.getInt(3);
            int ss = cursor.getInt(4);
            int tt = cursor.getInt(5);

            Notes n = new Notes(id, name, Date, ff, ss, tt);
            notes.add(n);
            cursor.moveToNext();
        }

        return notes;

    }


}
