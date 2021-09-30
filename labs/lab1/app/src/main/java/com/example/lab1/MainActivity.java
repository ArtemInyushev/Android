package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean changed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeColor(View view){
        Button button  = (Button) view;
        if(changed){
            button.setBackgroundResource(R.drawable.my_button);
            changed = false;
        }
        else{
            button.setBackgroundResource(R.drawable.my_button_clicked);
            changed = true;
        }
    }
}