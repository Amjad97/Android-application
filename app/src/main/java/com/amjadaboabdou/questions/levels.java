package com.amjadaboabdou.questions;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class levels extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5;
    ImageView imag2,imag3,imag4,imag5;
    String type_question,type,arab_type;

    Question_Data_Base db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        db=new Question_Data_Base(this);

        Intent data = getIntent();
        type_question = data.getExtras().getString("question_type");
        type=data.getExtras().getString("type");

        switch (type){
            case "islamic":
                arab_type="إسلامية";
                break;
            case "culture":
                arab_type="ثقافية";
                break;
            case "sport":
                arab_type="رياضية";
                break;
            case "science":
                arab_type="علمية";
                break;
            case "geographic":
                arab_type="جغرافية";
                break;
            case "history":
                arab_type="تاريخية";
                break;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(arab_type);
        toolbar.setTitleTextColor(Color.WHITE);

        text1=(TextView)findViewById(R.id.text_level1);
        text2=(TextView)findViewById(R.id.text_level2);
        text3=(TextView)findViewById(R.id.text_level3);
        text4=(TextView)findViewById(R.id.text_level4);
        text5=(TextView)findViewById(R.id.text_level5);

        imag2=(ImageView)findViewById(R.id.img2);
        imag3=(ImageView)findViewById(R.id.img3);
        imag4=(ImageView)findViewById(R.id.img4);
        imag5=(ImageView)findViewById(R.id.img5);

        ArrayList<info> arrayList= db.getAllRecord();

        for (int i =0;i<arrayList.size();i++){
            if (arrayList.get(i).getType_question().equals(type_question)){
                if (arrayList.get(i).getType().equals(type)){
                    if (arrayList.get(i).getLevel().equals("one")){
                        text1.setText(arrayList.get(i).getScore()+"/20");
                        if (arrayList.get(i).getScore()>= 15) {
                            imag2.setImageResource(R.drawable.level2);
                        }
                    }
                    if (arrayList.get(i).getLevel().equals("two")){
                        text2.setText(arrayList.get(i).getScore()+"/20");
                        if (arrayList.get(i).getScore()>= 15) {
                            imag3.setImageResource(R.drawable.level3);
                        }
                    }
                    if (arrayList.get(i).getLevel().equals("three")){
                        text3.setText(arrayList.get(i).getScore()+"/20");
                        if (arrayList.get(i).getScore()>= 15) {
                            imag4.setImageResource(R.drawable.level4);
                        }
                    }
                    if (arrayList.get(i).getLevel().equals("four")){
                        text4.setText(arrayList.get(i).getScore()+"/20");
                        if (arrayList.get(i).getScore()>= 15) {
                            imag5.setImageResource(R.drawable.level5);
                        }
                    }
                    if (arrayList.get(i).getLevel().equals("five")){
                        text5.setText(arrayList.get(i).getScore()+"/20");
                    }
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.level_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {
            Intent intent = new Intent(levels.this,types.class);
            intent.putExtra("question_type",type_question);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void level_one(View view) {

        Intent data = getIntent();
        type_question = data.getExtras().getString("question_type");
        type=data.getExtras().getString("type");

        if (type_question.equals("Choose")){
            Intent intent = new Intent(levels.this,choose.class);
            intent.putExtra("level","one");
            intent.putExtra("type",type);
            startActivity(intent);
        }else if(type_question.equals("True_False")){
            Intent intent = new Intent(levels.this,True_Or_False.class);
            intent.putExtra("level","one");
            intent.putExtra("type",type);
            startActivity(intent);
        }

    }

    public void level_two(View view) {
        Intent data = getIntent();
        type_question = data.getExtras().getString("question_type");
        type=data.getExtras().getString("type");

        ArrayList<info> arrayList= db.getAllRecord();
        for (int i =0;i<arrayList.size();i++) {
            if (arrayList.get(i).getType_question().equals(type_question) && arrayList.get(i).getType().equals(type)
                    && arrayList.get(i).getLevel().equals("one") && arrayList.get(i).getScore() >= 15) {
                if (type_question.equals("Choose"))
                {
                    Intent intent = new Intent(levels.this,choose.class);
                    intent.putExtra("level","two");
                    intent.putExtra("type",type);
                    startActivity(intent);
                }else if(type_question.equals("True_False"))
                {
                    Intent intent = new Intent(levels.this,True_Or_False.class);
                    intent.putExtra("level","two");
                    intent.putExtra("type",type);
                    startActivity(intent);
                }
            }
        }

        if (imag2.getDrawable() == getResources().getDrawable(R.drawable.level2_locked)) {
            Toast.makeText(levels.this, "المرحلة مقفلة", Toast.LENGTH_SHORT).show();
        }
    }


    public void level_three(View view) {
        Intent data = getIntent();
        type_question = data.getExtras().getString("question_type");
        type=data.getExtras().getString("type");

        ArrayList<info> arrayList= db.getAllRecord();
        for (int i =0;i<arrayList.size();i++) {
            if (arrayList.get(i).getType_question().equals(type_question) && arrayList.get(i).getType().equals(type)
                    && arrayList.get(i).getLevel().equals("two") && arrayList.get(i).getScore() >= 15) {
        if (type_question.equals("Choose"))
        {
            Intent intent = new Intent(levels.this,choose.class);
            intent.putExtra("level","three");
            intent.putExtra("type",type);
            startActivity(intent);
        }else if(type_question.equals("True_False"))
        {
            Intent intent = new Intent(levels.this,True_Or_False.class);
            intent.putExtra("level","three");
            intent.putExtra("type",type);
            startActivity(intent);
        }

            }
        }

        if (imag3.getDrawable() == getResources().getDrawable(R.drawable.level3_locked)) {
            Toast.makeText(levels.this, "المرحلة مقفلة", Toast.LENGTH_SHORT).show();
        }

    }

    public void level_four(View view) {
        Intent data = getIntent();
        type_question = data.getExtras().getString("question_type");
        type = data.getExtras().getString("type");

        ArrayList<info> arrayList= db.getAllRecord();
        for (int i =0;i<arrayList.size();i++) {
            if (arrayList.get(i).getType_question().equals(type_question) && arrayList.get(i).getType().equals(type)
                    && arrayList.get(i).getLevel().equals("three") && arrayList.get(i).getScore() >= 15) {

                if (type_question.equals("Choose")) {
                Intent intent = new Intent(levels.this, choose.class);
                intent.putExtra("level", "four");
                intent.putExtra("type", type);
                startActivity(intent);
            } else if (type_question.equals("True_False")) {
                Intent intent = new Intent(levels.this, True_Or_False.class);
                intent.putExtra("level", "four");
                intent.putExtra("type", type);
                startActivity(intent);
            }
        }
        }

        if (imag4.getDrawable() == getResources().getDrawable(R.drawable.level4_locked)) {
            Toast.makeText(levels.this, "المرحلة مقفلة", Toast.LENGTH_SHORT).show();
        }
    }
    public void level_five(View view) {
        Intent data = getIntent();
        type_question = data.getExtras().getString("question_type");
        type=data.getExtras().getString("type");

        ArrayList<info> arrayList= db.getAllRecord();
        for (int i =0;i<arrayList.size();i++) {
            if (arrayList.get(i).getType_question().equals(type_question) && arrayList.get(i).getType().equals(type)
                    && arrayList.get(i).getLevel().equals("four") && arrayList.get(i).getScore() >= 15) {
                if (type_question.equals("Choose")){
            Intent intent = new Intent(levels.this,choose.class);
            intent.putExtra("level","five");
            intent.putExtra("type",type);
            startActivity(intent);
        }else if(type_question.equals("True_False")){
            Intent intent = new Intent(levels.this,True_Or_False.class);
            intent.putExtra("level","five");
            intent.putExtra("type",type);
            startActivity(intent);
        }
           }
        }

        if (imag5.getDrawable() == getResources().getDrawable(R.drawable.level5_locked)) {
            Toast.makeText(levels.this, "المرحلة مقفلة", Toast.LENGTH_SHORT).show();
        }
    }
}