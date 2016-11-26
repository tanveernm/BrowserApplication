package com.section_d.browserapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button searchButton;
    EditText url;
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        url = (EditText) (findViewById(R.id.url1));
        searchButton = (Button) findViewById(R.id.search_button);
         myWebView = (WebView) findViewById(R.id.webView1);

        String summary = "<html><body bgcolor='lavender'><br><br><br><h1>Welcome to D-fire Web browser.. <br> Start your browsing... </h1></body></html>";
        myWebView.loadData(summary, "text/html", null);

        addListenerOnSearchButton();
    }

    private void addListenerOnSearchButton() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    String summary = "<html><body bgcolor='lavender'><br><br><br><h1>Welcome to D-fire Web browser.. <br> Start your browsing... </h1></body></html>";
                    myWebView.loadData(summary, "text/html", null);

                }
                String urlText = url.getText().toString();
                myWebView.setWebViewClient(new WebViewClient());
                if (!urlText.startsWith("http://") && !urlText.startsWith("https://")) {
                    urlText = "http://" + urlText;
                    myWebView.loadUrl(urlText);
                }
                else{
                    urlText = "http://google.com";
                    myWebView.loadUrl(urlText);
                    url.clearFocus();

                }


            }

        });


    }
}