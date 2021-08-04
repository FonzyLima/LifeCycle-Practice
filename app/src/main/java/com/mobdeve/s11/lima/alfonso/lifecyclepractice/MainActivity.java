package com.mobdeve.s11.lima.alfonso.lifecyclepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int createVal;
    private int startVal;
    private int resumeVal;
    private int stopVal;
    private int pauseVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.createVal = 0;
        this.startVal = 0;
        this.resumeVal = 0;
        this.stopVal = 0;
        this.pauseVal = 0;

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        EditText etCreate = findViewById(R.id.et_create);
        this.createVal++;
        etCreate.setText(String.valueOf(this.createVal));
    }

    @Override
    protected void onStart() {
        super.onStart();

        EditText etStart = findViewById(R.id.et_start);
        this.startVal++;
        etStart.setText(String.valueOf(this.startVal));
    }

    @Override
    protected void onStop() {
        super.onStop();

        EditText etStop = findViewById(R.id.et_stop);

        this.stopVal++;
        etStop.setText(String.valueOf(this.stopVal));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();

        EditText etPause = findViewById(R.id.et_pause);

        this.pauseVal++;
        etPause.setText(String.valueOf(this.pauseVal));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("ONCREATE", this.createVal);
        outState.putInt("ONSTART", this.startVal);
        outState.putInt("ONRESUME", this.resumeVal);
        outState.putInt("ONPAUSE",this.pauseVal);
        outState.putInt("ONSTOP", this.stopVal);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        this.createVal = savedInstanceState.getInt("ONCREATE");
        this.startVal = savedInstanceState.getInt("ONSTART");
        this.pauseVal = savedInstanceState.getInt("ONPAUSE");
        this.stopVal = savedInstanceState.getInt("ONSTOP");
        this.resumeVal = savedInstanceState.getInt("ONRESUME");

        ((EditText)findViewById(R.id.et_create)).setText(String.valueOf(this.createVal));
        ((EditText)findViewById(R.id.et_start)).setText(String.valueOf(this.startVal));
        ((EditText)findViewById(R.id.et_pause)).setText(String.valueOf(this.pauseVal));
        ((EditText)findViewById(R.id.et_stop)).setText(String.valueOf(this.stopVal));
        ((EditText)findViewById(R.id.et_resume)).setText(String.valueOf(this.resumeVal));
    }
}