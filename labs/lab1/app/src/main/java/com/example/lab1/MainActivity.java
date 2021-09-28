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
    private EditText FirstNumber;
    private EditText SecondNumber;
    private TextView ResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstNumber = (EditText) findViewById(R.id.FirstNumber);
        SecondNumber = (EditText) findViewById(R.id.SecondNumber);
        ResultView = (TextView) findViewById(R.id.Result);

        OperationSpin = (Spinner) findViewById(R.id.Spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.operations, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        OperationSpin.setAdapter(adapter);
    }

    public void Calculate(View view){
        String firstNumStr = FirstNumber.getText().toString();
        if(firstNumStr.isEmpty()){
            ResultView.setText("Error - first number is empty");
            return;
        }
        String secondNumStr = SecondNumber.getText().toString();
        if(secondNumStr.isEmpty()){
            ResultView.setText("Error - second number is empty");
            return;
        }
        String operation = OperationSpin.getSelectedItem().toString();

        int firstNum = Integer.parseInt(firstNumStr);
        int secondNum = Integer.parseInt(secondNumStr);
        String result = "Result: ";

        switch (operation){
            case "+":
                result += Integer.toString(firstNum + secondNum);
                break;
            case "-":
                result += Integer.toString(firstNum - secondNum);
                break;
            case "*":
                result += Integer.toString(firstNum * secondNum);
                break;
            case "/":
                if(secondNum == 0) {
                    ResultView.setText("Error - division by Zero");
                    return;
                }
                result += Double.toString(new Double(firstNum) / secondNum);
                break;
            default:
                result += "Error!!!";
                break;
        }
        ResultView.setText(result);
    }
}