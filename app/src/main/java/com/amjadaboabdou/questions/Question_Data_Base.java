package com.amjadaboabdou.questions;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Amjad on 03/09/17.
 */

public class Question_Data_Base extends SQLiteOpenHelper {

    public static final String name = "question.db";

    public Question_Data_Base(Context context){super(context, name, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table question ( Type TEXT,Type_Question TEXT,Level TEXT,score INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS question");
        onCreate(db);
    }

    public void Insert_info(String type,String question_type,String level,Integer score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Type",type);
        values.put("Type_Question",question_type);
        values.put("Level",level);
        values.put("score",score);
        db.insert("question",null,values);
    }

    public ArrayList getAllRecord(){
        ArrayList<info> arraylist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from question", null);
        rs.moveToFirst();
        while (!rs.isAfterLast()) {
            String Type = rs.getString(rs.getColumnIndex("Type"));
            String Type_question = rs.getString(rs.getColumnIndex("Type_Question"));
            String level = rs.getString(rs.getColumnIndex("Level"));
            int score = rs.getInt(rs.getColumnIndex("score"));
            arraylist.add(new info(Type,Type_question,level,score));
            rs.moveToNext();
        }
        return arraylist;
    }

    public void ubdate(String type,String type_Ques,String level,Integer score){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update question set score ='" +Integer.toString(score)+ "' where Level="+ level +"' where Type="+ type+"' where Type_Question="+ type_Ques);
    }
}
