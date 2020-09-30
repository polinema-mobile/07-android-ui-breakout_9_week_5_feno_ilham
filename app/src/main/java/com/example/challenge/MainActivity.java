package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import com.example.challenge.model.Student;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText inputName, inputNIM, inputDOB;
    private Spinner dropdown;
    private RadioGroup rgGender;
    private RadioButton gMale, gFemale;
    private String selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.gMale:
                        if(gMale.isChecked()){
                            gFemale.setChecked(false);
                            selectedGender = gMale.getText().toString();}
                        break;
                    case R.id.gFemale:
                        if(gFemale.isChecked()){
                            gMale.setChecked(false);
                            selectedGender = gFemale.getText().toString();}
                        break;
                }
            }
        });
    }
    public void saveClick(View v){
        String name = inputName.getText().toString();
        String nim = inputNIM.getText().toString();
        String dob = inputDOB.getText().toString();
        String major = dropdown.getSelectedItem().toString();
        String gender = selectedGender;
        Student std = new Student(name, nim,dob,gender,major);
        Intent i = new Intent(this, PrintBundle.class);
        i.putExtra("std",std);
        startActivity(i);
    }

    public void dateClick(View v) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
                        inputDOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void init(){
        inputName = (EditText) findViewById(R.id.inputName);
        inputNIM = (EditText)findViewById(R.id.inputNIM);
        inputDOB = (EditText)findViewById(R.id.inputDOB);
        dropdown = (Spinner)findViewById(R.id.inputMajor);
        rgGender = (RadioGroup)findViewById(R.id.rgGender);
        gMale = (RadioButton) findViewById(R.id.gMale);
        gFemale = (RadioButton)findViewById(R.id.gFemale);
    }
}