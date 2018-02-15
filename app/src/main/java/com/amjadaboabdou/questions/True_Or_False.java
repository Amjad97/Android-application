package com.amjadaboabdou.questions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class True_Or_False extends AppCompatActivity {

    TextView question, Degree, num_qus;
    Button btn_True, btn_false;
    ArrayList<String> listQu = new ArrayList<>();
    ArrayList<String> listShowq = new ArrayList<>();
    String Qu ,An;
    int Final_Degree, i=1;
    Animation animS;
    String type,level,qus,arab_level,next_level;
    Question_Data_Base db;
    MediaPlayer media;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true__or__false);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.Interstitial_Ad));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        Toast.makeText(this, "الحد الادنى للانتقال للمرحلة القادمة 15/20", Toast.LENGTH_LONG).show();

        Intent data = getIntent();
        type = data.getExtras().getString("type");
        level=data.getExtras().getString("level");

        switch (level){
            case "one":
                arab_level="المرحلة الأولى";
                break;
            case "two":
                arab_level="المرحلة الثانية";
                break;
            case "three":
                arab_level="المرحلة الثالثة";
                break;
            case "four":
                arab_level="المرحلة الرابعة";
                break;
            case "five":
                arab_level="المرحلة الخامسة";
                break;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        setTitle(arab_level);
        toolbar.setTitleTextColor(Color.WHITE);

        db = new Question_Data_Base(this);

        question = (TextView) findViewById(R.id.question);
        Degree = (TextView) findViewById(R.id.result);
        num_qus = (TextView) findViewById(R.id.number_qus);
        btn_True = (Button) findViewById(R.id.btn_True);
        btn_false = (Button) findViewById(R.id.btn_False);
        animS = AnimationUtils.loadAnimation(this, R.anim.scale_in_out_anim);


        switch (type){
            case "islamic":
                if (level.equals("one")){
                    qus="islamic_true_false";
                    read_question(qus);
                }else if(level.equals("two")){
                    qus="islamic_true_false2";
                    read_question(qus);
                }else if(level.equals("three")){
                    qus="islamic_true_false3";
                    read_question(qus);
                }else if(level.equals("four")){
                    qus="islamic_true_false4";
                    read_question(qus);
                }else if(level.equals("five")){
                    qus="islamic_true_false5";
                    read_question(qus);
                }
                break;
            case "culture":
                if (level.equals("one")){
                    qus="culture_true_false";
                    read_question(qus);
                }else if(level.equals("two")){
                    qus="culture_true_false2";
                    read_question(qus);
                }else if(level.equals("three")){
                    qus="culture_true_false3";
                    read_question(qus);
                }else if(level.equals("four")){
                    qus="culture_true_false4";
                    read_question(qus);
                }else if(level.equals("five")){
                    qus="culture_true_false5";
                    read_question(qus);
                }
                break;
            case "sport":
                if (level.equals("one")){
                    qus="sport_true_false";
                    read_question(qus);
                }else if(level.equals("two")){
                    qus="sport_true_false2";
                    read_question(qus);
                }else if(level.equals("three")){
                    qus="sport_true_false3";
                    read_question(qus);
                }else if(level.equals("four")){
                    qus="sport_true_false4";
                    read_question(qus);
                }else if(level.equals("five")){
                    qus="sport_true_false5";
                    read_question(qus);
                }
                break;
            case "science":
                if (level.equals("one")){
                    qus="science_true_false";
                    read_question(qus);
                }else if(level.equals("two")){
                    qus="science_true_false2";
                    read_question(qus);
                }else if(level.equals("three")){
                    qus="science_true_false3";
                    read_question(qus);
                }else if(level.equals("four")){
                    qus="science_true_false4";
                    read_question(qus);
                }else if(level.equals("five")){
                    qus="science_true_false5";
                    read_question(qus);
                }
                break;
            case "geographic":
                if (level.equals("one")){
                    qus="geographic_true_false";
                    read_question(qus);
                }else if(level.equals("two")){
                    qus="geographic_true_false2";
                    read_question(qus);
                }else if(level.equals("three")){
                    qus="geographic_true_false3";
                    read_question(qus);
                }else if(level.equals("four")){
                    qus="geographic_true_false4";
                    read_question(qus);
                }else if(level.equals("five")){
                    qus="geographic_true_false5";
                    read_question(qus);
                }
                break;
            case "history":
                if (level.equals("one")){
                    qus="history_true_false";
                    read_question(qus);
                }else if(level.equals("two")){
                    qus="history_true_false2";
                    read_question(qus);
                }else if(level.equals("three")){
                    qus="history_true_false3";
                    read_question(qus);
                }else if(level.equals("four")){
                    qus="history_true_false4";
                    read_question(qus);
                }else if(level.equals("five")){
                    qus="history_true_false5";
                    read_question(qus);
                }
                break;
            default:
                break;
        }
    }

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
            Intent intent = new Intent(True_Or_False.this,levels.class);
            intent.putExtra("question_type","True_False");
            intent.putExtra("type",type);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void read_question(String qus){
        try {
            InputStream input = getAssets().open(qus+".txt");
            InputStreamReader rd = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(rd);
            String line;
            while ((line = br.readLine()) != null) {
                listQu.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ShowTXT();
    }

    public void ShowTXT() {
        if (listShowq.size() < listQu.size()) {
            try {
                Random R1 = new Random();
                int Rnd_Qu = R1.nextInt(listQu.size());
                String[] Qus = listQu.get(Rnd_Qu).split(",");
                Qu = Qus[1];
                An = Qus[0].trim();
                Boolean a = true;
                for (int i = 0; i < listShowq.size(); i++) {
                    if (Qu.equals(listShowq.get(i))) {
                        ShowTXT();
                        a = false;
                        break;
                    }
                }
                if (a) {
                    num_qus.setText( i+"/20");

                    Degree.setText(String.valueOf(Final_Degree));
                    question.setText(Qu);
                    listShowq.add(Qu);
                }
            }catch (Exception e){
                ShowTXT();
            }
        } else {

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            question.setText("");
                Degree.setText(String.valueOf(Final_Degree));
            if (Final_Degree >= 15 ){

                db.Insert_info(type,"True_False",level,Final_Degree);

                AlertDialog.Builder alert=new AlertDialog.Builder(True_Or_False.this);
                View view = getLayoutInflater().inflate(R.layout.toast_photo,null);
                Button play=(Button)view.findViewById(R.id.play);
                Button list=(Button)view.findViewById(R.id.list);

                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (level.equals("one")) {
                            next_level = "two";
                            Intent intent = new Intent(True_Or_False.this, True_Or_False.class);
                            intent.putExtra("level",next_level);
                            intent.putExtra("type",type);
                            startActivity(intent);
                        } else if (level.equals("two")){
                            next_level = "three";
                            Intent intent = new Intent(True_Or_False.this, True_Or_False.class);
                            intent.putExtra("level",next_level);
                            intent.putExtra("type",type);
                            startActivity(intent);
                        }else if(level.equals("three")){
                            next_level="four";
                            Intent intent = new Intent(True_Or_False.this, True_Or_False.class);
                            intent.putExtra("level",next_level);
                            intent.putExtra("type",type);
                            startActivity(intent);
                        }else if (level.equals("four")){
                            next_level="five";
                            Intent intent = new Intent(True_Or_False.this, True_Or_False.class);
                            intent.putExtra("level",next_level);
                            intent.putExtra("type",type);
                            startActivity(intent);
                        }else if (level.equals("five")){
                            Intent intent = new Intent(True_Or_False.this,levels.class);
                            intent.putExtra("question_type","True_False");
                            intent.putExtra("type",type);
                            startActivity(intent);
                        }
                    }
                });
                list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(True_Or_False.this,levels.class);
                        intent.putExtra("question_type","True_False");
                        intent.putExtra("type",type);
                        startActivity(intent);
                    }
                });

                alert.setView(view);
                AlertDialog alertDialog=alert.create();
                alertDialog.show();

            }else {
                AlertDialog.Builder alert=new AlertDialog.Builder(True_Or_False.this);
                View view = getLayoutInflater().inflate(R.layout.toast_photo1,null);
                Button replay=(Button)view.findViewById(R.id.replay);
                Button list=(Button)view.findViewById(R.id.list1);

                replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(True_Or_False.this,True_Or_False.class);
                        intent.putExtra("level",level);
                        intent.putExtra("type",type);
                        startActivity(intent);
                    }
                });
                list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(True_Or_False.this,levels.class);
                        intent.putExtra("question_type","True_False");
                        intent.putExtra("type",type);
                        startActivity(intent);
                    }
                });

                alert.setView(view);
                AlertDialog alertDialog=alert.create();
                alertDialog.show();
            }
        }
    }

    public void true_answer(View view) {

        if(listShowq.size() <= listQu.size()){
            if(i<=20){
                num_qus.setText( i+"/20");
                i++;
            }
        btn_True.startAnimation(animS);
        if (An.equals("1")) {
                media = MediaPlayer.create(True_Or_False.this,R.raw.right);
                media.start();
            if(Final_Degree < 20){
                Final_Degree++;
                Degree.setText(String.valueOf(Final_Degree));
            }
            ShowTXT();
        } else {
                media = MediaPlayer.create(True_Or_False.this,R.raw.wrong);
                media.start();
            Vibrator v = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(500);
            ShowTXT();
               }
        }
    }


    public void false_answer(View view) {

        if(listShowq.size() <= listQu.size()){
            if(i<=20){
                num_qus.setText( i+"/20");
                i++;
            }
            btn_false.startAnimation(animS);
            if (An.equals("0")) {
                media = MediaPlayer.create(True_Or_False.this,R.raw.right);
                media.start();
                if(Final_Degree < 20){
                    Final_Degree++;
                    Degree.setText(String.valueOf(Final_Degree));
                }
                ShowTXT();
                } else {
                media = MediaPlayer.create(True_Or_False.this,R.raw.wrong);
                media.start();
            Vibrator v = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(500);
            ShowTXT();

             }
        }
    }
}