package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ResultView;
    private Spinner [][] Spinners = new Spinner[4][4];
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResultView = (TextView) findViewById(R.id.Result);

        TableLayout table = (TableLayout) findViewById(R.id.Table);
        int rowsCount = table.getChildCount();
        for(int i = 0; i < rowsCount; i++){
            TableRow row = (TableRow) table.getChildAt(i);
            int spinnersCount = row.getChildCount();
            for(int j  = 0; j < spinnersCount; j++){
                Spinner spinner = (Spinner) row.getChildAt(j);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.options, R.layout.spinner_item);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        counter++;
                        if(CheckIfGameFinished()) {
                            ResultView.setText("You have won!!!");
                        }
                        else {
                            ResultView.setText(Integer.toString(counter));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) { }
                });

                Spinners[i][j] = spinner;
            }
        }
    }

    private boolean CheckIfGameFinished(){
        boolean diagonals = CheckDiagonals();
        boolean rows_cols = CheckRowsAndCols();

        if(diagonals || rows_cols){
            return true;
        }
        return false;
    }

    private boolean CheckDiagonals(){
        boolean finishedDiagonal = true;
        boolean finishedDiagonalReverse = true;
        String diagonalFirst = Spinners[0][0].getSelectedItem().toString();
        String diagonalReverseFirst = Spinners[0][3].getSelectedItem().toString();
        if(diagonalFirst.equals("")){
            finishedDiagonal = false;
        }
        if(diagonalReverseFirst.equals("")){
            finishedDiagonalReverse = false;
        }

        for (int i = 1; i < 4; i++) {
            if (!diagonalFirst.equals(Spinners[i][i].getSelectedItem().toString())) {
                finishedDiagonal = false;
            }
            if (!diagonalReverseFirst.equals(Spinners[i][3 - i].getSelectedItem().toString())) {
                finishedDiagonalReverse = false;
            }
            if (!finishedDiagonal && !finishedDiagonalReverse) {
                break;
            }
        }
        if (finishedDiagonal || finishedDiagonalReverse) {
            return true;
        }
        return false;
    }

    private boolean CheckRowsAndCols(){
        for (int i = 0; i < 4; i++) {
            boolean finishedRow = true;
            boolean finishedCol = true;
            String rowFirst = Spinners[0][i].getSelectedItem().toString();
            String colFirst = Spinners[i][0].getSelectedItem().toString();
            if(rowFirst.equals("")){
                finishedRow = false;
            }
            if(colFirst.equals("")){
                finishedCol = false;
            }
            for (int j = 1; j < 4; j++) {
                if(!rowFirst.equals(Spinners[j][i].getSelectedItem().toString())) {
                    finishedRow = false;
                }
                if (!colFirst.equals(Spinners[i][j].getSelectedItem().toString())) {
                    finishedCol = false;
                }
                if(!finishedRow && !finishedCol) {
                    break;
                }
            }
            if(finishedRow || finishedCol) {
                return true;
            }
        }
        return false;
    }
}