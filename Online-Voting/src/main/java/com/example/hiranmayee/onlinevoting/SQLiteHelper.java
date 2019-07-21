package com.example.hiranmayee.onlinevoting;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="UserDataBase";

    public static final String TABLE_NAME="UserTable";

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_Name="name";

    public static final String Table_Column_2_Email="email";

    public static final String Table_Column_3_Password="password";

    // private ContentValues cValues;
    //private SQLiteDatabase dataBase = null;

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, AUTOINCREMEMT , "+Table_Column_1_Name+" VARCHAR, "+Table_Column_2_Email+" VARCHAR, "+Table_Column_3_Password+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    /*public int updateRecord(String email, String password) {

        SQLiteDatabase dataBase = getWritableDatabase();
        ContentValues cValues = new ContentValues();

        //cValues.put(Table_Column_1_Name, name);
        cValues.put(Table_Column_2_Email, email);
        cValues.put(Table_Column_3_Password,password);
//    Update data from database table
        long insertchek=dataBase.update(SQLiteHelper.TABLE_NAME, cValues,
                Table_Column_2_Email+"='"+email+"' AND "+Table_Column_3_Password+"='"+password+"'", null);
        dataBase.close();
        return (int)insertchek;
    }*/

    public long insert(String table,ContentValues cv,String whereclm)
    {
        SQLiteDatabase dataBase = getWritableDatabase();
        long a=dataBase.insert(table,whereclm,cv);
        return a;
    }

}