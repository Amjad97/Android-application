package com.amjadaboabdou.questions;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Home extends AppCompatActivity {

    Button btn1,btn3,btn4,btn5;
    Animation turn_in,turn_out,rotate;
    Boolean open = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void choose(View view) {
        Intent intent = new Intent(Home.this,types.class);
        intent.putExtra("question_type","Choose");
        startActivity(intent);
    }

    public void true_false(View view) {
        Intent intent = new Intent(Home.this,types.class);
        intent.putExtra("question_type","True_False");
        startActivity(intent);
    }

}
