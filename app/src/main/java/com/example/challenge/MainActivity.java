package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Open Bundle Activity:

        Button btn = findViewById(R.id.button_Bundle);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBundle();
            }
        });
        //Open parse Label activity:
        Button btn2 = findViewById(R.id.button_parcelabel);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openParceLabel();
            }
        });
    }
    public void openBundle(){
        Intent intent = new Intent(this, ActivityBundle.class);
        startActivity(intent);
    }
    public void openParceLabel(){
        Intent intent = new Intent(this, ParceLabel.class);
        startActivity(intent);
    }
}