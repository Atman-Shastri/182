package com.example.sql_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Employee.db";

    public static final String TABLE_NAME = "student_table";

    public static final String COL_1 = "ID";

    public static final String COL_2 = "NAME";

    public static final String COL_3 = "SALARY";

    SQLiteDatabase database = this.getWritableDatabase();

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String Name, Integer Salary) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, Salary);

        long result = database.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        Cursor result = database.rawQuery("select * from " + TABLE_NAME, null);
        return result;
    }

    public Cursor search(String Name) {
        Cursor cursor = database.rawQuery("select * from " + TABLE_NAME + "where " + COL_2 + "like '%" + Name + "%'", null);
        return cursor;
    }

    public boolean updateData(String Id, String Name, String salary) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Id);
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, salary);
        database.update(TABLE_NAME, contentValues, "ID = ?", new String[]{Id});
        return true;
    }

    public Integer deleteData(String Id) {
        return database.delete(TABLE_NAME, "ID = ?", new String[]{Id});
    }
}
