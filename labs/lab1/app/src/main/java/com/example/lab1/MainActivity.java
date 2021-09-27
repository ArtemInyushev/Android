package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ExpressionField;
    private TextView ResultView;
    private String CurrentNumber = "";
    private Character CurrentOperation = ' ';
    private Double CurrentResult = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpressionField = (TextView) findViewById(R.id.ExpressionField);
        ResultView = (TextView) findViewById(R.id.ResultField);
    }

    private double ParseDouble(String value) {
        try {
            return  Double.parseDouble(value);
        }
        catch (NumberFormatException e) {
            ResultView.setText("Error");
            // do something in case of error
        }
        return -100;
    }

    private double Calculate() throws Exception {
        double result = CurrentResult;
        double number = ParseDouble(CurrentNumber);
        double res;
        switch (CurrentOperation) {
            case '+':
                res = result + number;
                ResultView.setText(Double.toString(res));
                break;
            case '-':
                res = result - number;
                ResultView.setText(Double.toString(res));
            case '*':
                res = result * number;
                ResultView.setText(Double.toString(res));
                break;
            case '/':
                res = result / number;
                ResultView.setText(Double.toString(res));
                break;
            default:
                // throw some exception
                throw new Exception("Missing operation");
        }
        return res;
    }

    public void OnNumberClick(View view){
        Button button = (Button) view;
        CharSequence numberStr = button.getText().toString();

        ExpressionField.append(numberStr);
        if(CurrentOperation == ' '){
            ResultView.append(numberStr);
        }
        else {
            CurrentNumber += numberStr;
            try {
                Calculate();
            } catch (Exception e) {
                e.getMessage();
            }
        }

        /*if(CurrentOperation == '='){
            ExpressionField.setText("");
            ResultView.setText("");
            CurrentOperation = ' ';
        }*/
    }

    public void OnOperationClick(View view){
        Button button = (Button) view;
        CharSequence operation = button.getText();
        ExpressionField.append(operation);

        CurrentResult = Double.parseDouble(ResultView.getText().toString());

        CurrentNumber = "";
        CurrentOperation = operation.charAt(0);
    }

    public void OnOneClick(View view){
        OnNumberClick(view);
    }

    public void onTwoClick(View view){
        OnNumberClick(view);
    }

    public void onThreeClick(View view){
        OnNumberClick(view);
    }

    public void onFourClick(View view){
        OnNumberClick(view);
    }

    public void onFiveClick(View view){
        OnNumberClick(view);
    }

    public void onSixClick(View view){
        OnNumberClick(view);
    }

    public void onSevenClick(View view){
        OnNumberClick(view);
    }

    public void onEightClick(View view){
        OnNumberClick(view);
    }

    public void onNineClick(View view){
        OnNumberClick(view);
    }

    public void onZeroClick(View view){
        OnNumberClick(view);
    }
}