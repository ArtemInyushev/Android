package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button USABtn;
    private Button EnglandBtn;
    private Button ItalyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USABtn = (Button) findViewById(R.id.USABtn);
        EnglandBtn = (Button) findViewById(R.id.EnglandBtn);
        ItalyBtn = (Button) findViewById(R.id.ItalyBtn);
        SetButtonHandlers();
    }

    private void SetButtonHandlers() {
        USABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Country, new UsaFragment())
                        .commit();
            }
        });
        EnglandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Country, new EnglandFragment())
                        .commit();
            }
        });
        ItalyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Country, new ItalyFragment())
                        .commit();
            }
        });
    }
}