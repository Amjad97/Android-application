package com.amjadaboabdou.questions;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class types extends AppCompatActivity {

    String type,arabtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        if (type.equals("Choose")){
            arabtype="اختر الاجابة";
        }else if (type.equals("True_False")){
            arabtype="صح أو خطأ";
        }



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setTitle(arabtype);
        toolbar.setTitleTextColor(Color.WHITE);
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
            Intent intent = new Intent(types.this,Home.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void islamic(View view) {

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        Intent intent = new Intent(types.this,levels.class);
        intent.putExtra("type","islamic");
        intent.putExtra("question_type",type);
        startActivity(intent);
    }

    public void culture(View view) {

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        Intent intent = new Intent(types.this,levels.class);
        intent.putExtra("type","culture");
        intent.putExtra("question_type",type);
        startActivity(intent);
    }

    public void sport(View view) {

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        Intent intent = new Intent(types.this,levels.class);
        intent.putExtra("type","sport");
        intent.putExtra("question_type",type);
        startActivity(intent);
    }

    public void science(View view) {

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        Intent intent = new Intent(types.this,levels.class);
        intent.putExtra("type","science");
        intent.putExtra("question_type",type);
        startActivity(intent);
    }

    public void Geographic(View view) {

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        Intent intent = new Intent(types.this,levels.class);
        intent.putExtra("type","geographic");
        intent.putExtra("question_type",type);
        startActivity(intent);
    }

    public void history(View view) {

        Intent data =getIntent();
        type= data.getExtras().getString("question_type");

        Intent intent = new Intent(types.this,levels.class);
        intent.putExtra("type","history");
        intent.putExtra("question_type",type);
        startActivity(intent);
    }

}
