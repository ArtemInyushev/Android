package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Spinner OperationSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OperationSpin = (Spinner) view
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.operations, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        OperationSpin.setAdapter(adapter);
    }
}