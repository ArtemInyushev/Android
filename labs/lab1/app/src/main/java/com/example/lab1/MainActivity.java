package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ExpressionField;
    private TextView ResultField;
    private String CurrentNumber = "";
    private Character CurrentOperation = ' ';
    private Double CurrentResult = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpressionField = (TextView) findViewById(R.id.ExpressionField);
        ResultField = (TextView) findViewById(R.id.ResultField);
    }

    private double ParseDouble(String value) {
        try {
            return  Double.parseDouble(value);
        }
        catch (NumberFormatException e) {
            ResultField.setText("Error");
            // do something in case of error
        }
        return -100;
    }

    private void Calculate() throws Exception {
        double result = CurrentResult;
        double number = ParseDouble(CurrentNumber);
        double res;
        switch (CurrentOperation) {
            case '+':
                res = result + number;
                ResultField.setText(Double.toString(res));
                break;
            case '-':
                res = result - number;
                ResultField.setText(Double.toString(res));
                break;
            case '*':
                res = result * number;
                ResultField.setText(Double.toString(res));
                break;
            case '/':
                res = result / number;
                ResultField.setText(Double.toString(res));
                break;
            default:
                throw new Exception("Missing operation");
        }
    }

    public void OnNumberClick(View view){
        Button button = (Button) view;
        CharSequence numberStr = button.getText().toString();

        if(CurrentOperation == '=') {
            ExpressionField.setText(numberStr);
            CurrentOperation = ' ';
        }
        else {
            ExpressionField.append(numberStr);
        }

        if(CurrentOperation == ' '){
            ResultField.append(numberStr);
        }
        else {
            CurrentNumber += numberStr;
            try {
                Calculate();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public void OnOperationClick(View view){
        Button button = (Button) view;
        CharSequence operation = button.getText();

        if(operation.toString().equals(".")){
            String resultField = ExpressionField.getText().toString();
            if(resultField.charAt(resultField.length() - 1) != '.'){
                OnNumberClick(view);
            }
            return;
        }

        // check if user has added something after operation
        if(CurrentNumber == "" && CurrentOperation != ' '){
            String resultField = ExpressionField.getText().toString();
            resultField = resultField.substring(0, resultField.length() - 1);
            ExpressionField.setText(resultField);
        }
        CurrentOperation = operation.charAt(0);
        ExpressionField.append(operation);
        CurrentNumber = "";

        if(CurrentOperation == '='){
            ExpressionField.append(ResultField.getText());
            ResultField.setText("");
            CurrentResult = 0.0;
        }
        else {
            CurrentResult = Double.parseDouble(ResultField.getText().toString());
        }
    }
}