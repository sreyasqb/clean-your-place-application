package com.example.oopsappv6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    public CardView card1,card2,card3,card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        card1=(CardView) findViewById(R.id.c1);
        card2=(CardView) findViewById(R.id.c2);
        card3=(CardView) findViewById(R.id.c3);
        card4=(CardView) findViewById(R.id.c4);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent i;

        if (v.getId()==R.id.c1){

            startActivity(new Intent(this,oopsMap.class));
        }
        if (v.getId()==R.id.c2){
            startActivity(new Intent(this,DetailsLoc.class));
        }
        if (v.getId()==R.id.c3){
            startActivity(new Intent(this,camActivity.class));
        }
        if (v.getId()==R.id.c4){
            startActivity(new Intent(this,contactAct.class));
        }
    }
}