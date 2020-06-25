package com.abilat.sherlock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final private int CHOOSE_THIEF = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        Intent questionIntent = new Intent(MainActivity.this, MainActivity2.class);
        startActivityForResult(questionIntent, CHOOSE_THIEF);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        if (requestCode == CHOOSE_THIEF){
            if (requestCode == RESULT_OK){
                String thiefname = data.getStringExtra(MainActivity2.THIEF);
                textViewInfo.setText(thiefname);
            }else {
                textViewInfo.setText("");
            }
        }
    }
}