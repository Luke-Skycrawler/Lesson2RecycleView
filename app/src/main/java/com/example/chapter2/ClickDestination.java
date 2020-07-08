package com.example.chapter2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ClickDestination extends Activity {

    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        +itt.getStringExtra("K1")
//        tx.setText(itt.getStringExtra("K1"));
        setContentView(R.layout.activity_click_destination);
        tx=findViewById(R.id.ItemIndex);
        Log.i("RecycleView", "RecycleView Clicked");
    }
    @Override
    protected void onResume(){
        Intent itt=getIntent();
        Log.i("Clicked",itt.getStringExtra("K1"));
        tx.setText(itt.getStringExtra("K1"));
        super.onResume();
    }

    @Override
    protected  void onStart(){

        super.onStart();
        Log.i("Clicked","onStart");
    }
}
