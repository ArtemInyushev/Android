package com.example.lab3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView browser = (WebView) findViewById(R.id.webBrowser);
        browser.loadUrl("https://drive.google.com/file/d/1l5l0F0wCJaYs1XiqebrprJWsdMiVuznW/view");
    }
}