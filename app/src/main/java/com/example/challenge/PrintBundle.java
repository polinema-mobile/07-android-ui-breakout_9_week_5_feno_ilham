package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.challenge.model.Student;
import android.widget.TextView;

public class PrintBundle extends AppCompatActivity {
    TextView outputName, outputNIM, outputDOB, outputGender, outputMajor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        init();
        Student std = getIntent().getParcelableExtra("std");
        outputName.setText(std.getName());
        outputNIM.setText(std.getNim());
        outputGender.setText(std.getGender());
        outputDOB.setText(std.getDob());
        outputMajor.setText(std.getMajor());

    }
    public void init(){
        outputName = findViewById(R.id.outputName);
        outputNIM = findViewById(R.id.outputNIM);
        outputDOB = findViewById(R.id.outputDOB);
        outputGender = findViewById(R.id.outputGender);
        outputMajor = findViewById(R.id.outputMajor);
    }
}