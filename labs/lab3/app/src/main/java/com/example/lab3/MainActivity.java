package com.example.lab3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Url;
    private Button SearchBtn;
    private Button PrevBtn;
    private Button NextBtn;
    private WebView Browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = (EditText) findViewById(R.id.Url);
        SearchBtn = (Button) findViewById(R.id.SearchBtn);
        PrevBtn = (Button) findViewById(R.id.PrevBtn);
        NextBtn = (Button) findViewById(R.id.NextBtn);

        Browser = (WebView) findViewById(R.id.webBrowser);
        WebSettings webSettings = Browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Browser.loadUrl(getString(R.string.start_url));

        Browser.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Update();
            }
        });

        SetButtonHandlers();
    }

    private void SetButtonHandlers(){
        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Browser.loadUrl(Url.getText().toString());
            }
        });
        PrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Browser.canGoBack()){
                    Browser.goBack();
                }
            }
        });
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Browser.canGoForward()){
                    Browser.goForward();
                }
            }
        });
    }

    private void Update(){
        Url.setText(Browser.getUrl());
        if(Browser.canGoForward()){
            NextBtn.setEnabled(true);
        }
        else {
            NextBtn.setEnabled(false);
        }
        if(Browser.canGoBack()){
            PrevBtn.setEnabled(true);
        }
        else {
            PrevBtn.setEnabled(false);
        }
    }
}