package com.amjadaboabdou.questions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

public class choose extends AppCompatActivity {

    TextView qu, An_1, An_2, An_3, result,num_qus;
    ArrayList<String> listQu = new ArrayList<>();
    ArrayList<String> listAn = new ArrayList<>();
    ArrayList<String> listShowq = new ArrayList<>();
    int  ReNUM,i=1;
    String AnNUM,type,level,qus,ans,arab_level,next_level;
    Question_Data_Base db;
    MediaPlayer media;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

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

        Intent data = getIntent();
        type = data.getExtras().getString("type");
        level=data.getExtras().getString("level");

        db = new Question_Data_Base(this);

        Toast.makeText(this, "الحد الادنى للانتقال للمرحلة القادمة 15/20", Toast.LENGTH_LONG).show();

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        setTitle(arab_level);
        toolbar.setTitleTextColor(Color.WHITE);


        qu = (TextView) findViewById(R.id.question);
        An_1 = (TextView) findViewById(R.id.ans1);
        An_2 = (TextView) findViewById(R.id.ans2);
        An_3 = (TextView) findViewById(R.id.ans3);
        result = (TextView) findViewById(R.id.result1);
        num_qus = (TextView) findViewById(R.id.number_qus1);

        switch (type){
            case "islamic":
                if (level.equals("one")){
                    qus="islamic_qus";
                    ans="islamic_ans";
                    read_question(qus,ans);
                }else if(level.equals("two")){
                    qus="islamic_qus2";
                    ans="islamic_ans2";
                    read_question(qus,ans);
                }else if(level.equals("three")){
                    qus="islamic_qus3";
                    ans="islamic_ans3";
                    read_question(qus,ans);
                }else if(level.equals("four")){
                    qus="islamic_qus4";
                    ans="islamic_ans4";
                    read_question(qus,ans);
                }else if(level.equals("five")){
                    qus="islamic_qus5";
                    ans="islamic_ans5";
                    read_question(qus,ans);
                }
                break;
            case "culture":
                if (level.equals("one")){
                    qus="culture_qus";
                    ans="culture_ans";
                    read_question(qus,ans);
                }else if(level.equals("two")){
                    qus="culture_qus2";
                    ans="culture_ans2";
                    read_question(qus,ans);
                }else if(level.equals("three")){
                    qus="culture_qus3";
                    ans="culture_ans3";
                    read_question(qus,ans);
                }else if(level.equals("four")){
                    qus="culture_qus4";
                    ans="culture_ans4";
                    read_question(qus,ans);
                }else if(level.equals("five")){
                    qus="culture_qus5";
                    ans="culture_ans5";
                    read_question(qus,ans);
                }
                break;
            case "sport":
                if (level.equals("one")){
                    qus="sport_qus";
                    ans="sport_ans";
                    read_question(qus,ans);
                }else if(level.equals("two")){
                    qus="sport_qus2";
                    ans="sport_ans2";
                    read_question(qus,ans);
                }else if(level.equals("three")){
                    qus="sport_qus3";
                    ans="sport_ans3";
                    read_question(qus,ans);
                }else if(level.equals("four")){
                    qus="sport_qus4";
                    ans="sport_ans4";
                    read_question(qus,ans);
                }else if(level.equals("five")){
                    qus="sport_qus5";
                    ans="sport_ans5";
                    read_question(qus,ans);
                }
                break;
            case "science":
                if (level.equals("one")){
                    qus="science_qus";
                    ans="science_ans";
                    read_question(qus,ans);
                }else if(level.equals("two")){
                    qus="science_qus2";
                    ans="science_ans2";
                    read_question(qus,ans);
                }else if(level.equals("three")){
                    qus="science_qus3";
                    ans="science_ans3";
                    read_question(qus,ans);
                }else if(level.equals("four")){
                    qus="science_qus4";
                    ans="science_ans4";
                    read_question(qus,ans);
                }else if(level.equals("five")){
                    qus="science_qus5";
                    ans="science_ans5";
                    read_question(qus,ans);
                }
                break;
            case "geographic":
                if (level.equals("one")){
                    qus="geographic_qus";
                    ans="geographic_ans";
                    read_question(qus,ans);
                }else if(level.equals("two")){
                    qus="geographic_qus2";
                    ans="geographic_ans2";
                    read_question(qus,ans);
                }else if(level.equals("three")){
                    qus="geographic_qus3";
                    ans="geographic_ans3";
                    read_question(qus,ans);
                }else if(level.equals("four")){
                    qus="geographic_qus4";
                    ans="geographic_ans4";
                    read_question(qus,ans);
                }else if(level.equals("five")){
                    qus="geographic_qus5";
                    ans="geographic_ans5";
                    read_question(qus,ans);
                }
                break;
            case "history":
                if (level.equals("one")){
                    qus="history_qus";
                    ans="history_ans";
                    read_question(qus,ans);
                }else if(level.equals("two")){
                    qus="history_qus2";
                    ans="history_ans2";
                    read_question(qus,ans);
                }else if(level.equals("three")){
                    qus="history_qus3";
                    ans="history_ans3";
                    read_question(qus,ans);
                }else if(level.equals("four")){
                    qus="history_qus4";
                    ans="history_ans4";
                    read_question(qus,ans);
                }else if(level.equals("five")){
                    qus="history_qus5";
                    ans="history_ans5";
                    read_question(qus,ans);
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
            Intent intent = new Intent(choose.this,levels.class);
            intent.putExtra("question_type","Choose");
            intent.putExtra("type",type);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void read_question(String qus,String ans){

        try {
            InputStream inputStream = getAssets().open(qus+".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listQu.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream = getAssets().open(ans+".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listAn.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ShowTXT();
    }

    public void ShowTXT() {

        if (listShowq.size() < listQu.size()) {

            Random R1 = new Random();
            int Rnd_Qu = R1.nextInt(listQu.size());

            String Qus = listQu.get(Rnd_Qu);
            Boolean a = true;

            for (int i = 0; i < listShowq.size(); i++) {
                if (Qus.equals(listShowq.get(i))) {
                    ShowTXT();
                    a = false;
                    break;
                }
            }
            if (a) {
                num_qus.setText( i+"/20");
                result.setText(String.valueOf(ReNUM));
                qu.setText(Qus);
                String[] Aan = listAn.get(Rnd_Qu).split(",");
                An_1.setText(Aan[0]);
                An_2.setText(Aan[1]);
                An_3.setText(Aan[2]);

                AnNUM = Aan[3];
                listShowq.add(listQu.get(Rnd_Qu));
            }
        }else{

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            result.setText(String.valueOf(ReNUM));
            qu.setText("");
            An_1.setText("");
            An_2.setText("");
            An_3.setText("");

            if (ReNUM >= 15){

                db.Insert_info(type,"Choose",level,ReNUM);

                AlertDialog.Builder alert=new AlertDialog.Builder(choose.this);
                View view = getLayoutInflater().inflate(R.layout.toast_photo,null);
                Button play=(Button)view.findViewById(R.id.play);
                Button list=(Button)view.findViewById(R.id.list);

                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (level.equals("one")) {
                            next_level = "two";
                            Intent intent = new Intent(choose.this, choose.class);
                            intent.putExtra("level", next_level);
                            intent.putExtra("type", type);
                            startActivity(intent);
                        } else if (level.equals("two")){
                            next_level = "three";
                            Intent intent = new Intent(choose.this, choose.class);
                            intent.putExtra("level", next_level);
                            intent.putExtra("type", type);
                            startActivity(intent);
                        }else if(level.equals("three")){
                            next_level="four";
                            Intent intent = new Intent(choose.this, choose.class);
                            intent.putExtra("level",next_level);
                            intent.putExtra("type",type);
                            startActivity(intent);
                        }else if (level.equals("four")){
                            next_level="five";
                        Intent intent = new Intent(choose.this,choose.class);
                        intent.putExtra("level",next_level);
                        intent.putExtra("type",type);
                        startActivity(intent);
                        }else if (level.equals("five")){
                            Intent intent = new Intent(choose.this,levels.class);
                            intent.putExtra("question_type","Choose");
                            intent.putExtra("type",type);
                            startActivity(intent);
                        }
                    }
                });
                list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(choose.this,levels.class);
                        intent.putExtra("question_type","Choose");
                        intent.putExtra("type",type);
                        startActivity(intent);
                    }
                });

                alert.setView(view);
                AlertDialog alertDialog=alert.create();
                alertDialog.show();

            }else {
                AlertDialog.Builder alert=new AlertDialog.Builder(choose.this);
                View view = getLayoutInflater().inflate(R.layout.toast_photo1,null);
                Button replay=(Button)view.findViewById(R.id.replay);
                Button list=(Button)view.findViewById(R.id.list1);

                replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(choose.this,choose.class);
                        intent.putExtra("level",level);
                        intent.putExtra("type",type);
                        startActivity(intent);
                    }
                });
                list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(choose.this,levels.class);
                        intent.putExtra("question_type","Choose");
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

    public void ans1(View view) {

        if (listShowq.size() <= listQu.size()) {
            if(i <= 20){
                num_qus.setText(i + "/20");
                i++;
            }
            if (AnNUM.equals("1")) {
                 media = MediaPlayer.create(choose.this,R.raw.right);
                 media.start();
                if(ReNUM < 20){
                    ReNUM++;
                    result.setText(String.valueOf(ReNUM));
                }
                ShowTXT();
            } else {
                    media = MediaPlayer.create(choose.this,R.raw.wrong);
                    media.start();
                Vibrator v = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
                 ShowTXT();
            }
        }
    }

    public void ans2(View view) {

        if (listShowq.size() <= listQu.size()) {
            if(i <= 20) {
                num_qus.setText(i + "/20");
                i++;
            }
            if (AnNUM.equals("2")) {
                    media = MediaPlayer.create(choose.this,R.raw.right);
                    media.start();
                if(ReNUM < 20) {
                    ReNUM++;
                    result.setText(String.valueOf(ReNUM));
                }
                ShowTXT();
            } else {
                    media = MediaPlayer.create(choose.this,R.raw.wrong);
                    media.start();
                Vibrator v = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
                ShowTXT();
            }
        }
    }
    public void ans3(View view) {

        if (listShowq.size() <= listQu.size()) {
            if(i <= 20) {
                num_qus.setText(i + "/20");
                i++;
            }
            if (AnNUM.equals("3")) {
                    media = MediaPlayer.create(choose.this,R.raw.right);
                    media.start();
                if(ReNUM < 20) {
                    ReNUM++;
                    result.setText(String.valueOf(ReNUM));
                }
                ShowTXT();
            } else {
                    media = MediaPlayer.create(choose.this,R.raw.wrong);
                    media.start();
                Vibrator v = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
                ShowTXT();
            }
        }
    }
}
