package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Header = (TextView) findViewById(R.id.Header);

        TableLayout table = (TableLayout) findViewById(R.id.Table);
        int rowsCount = table.getChildCount();
        for(int i = 0; i < rowsCount; i++){
            TableRow row = (TableRow) table.getChildAt(i);
            int spinnersCount = row.getChildCount();
            for(int j  = 0; j < spinnersCount; j++){
                Spinner spinner = (Spinner) row.getChildAt(j);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.operations, R.layout.spinner_item);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner.setAdapter(adapter);
                Header.setText(Integer.toString(spinner.getWidth()));
            }
        }
    }
}