package com.bgkim.iotfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        SharedPreferences sp = getSharedPreferences("IoTFeedIP", MODE_PRIVATE);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl(String.format("http://%d.%d.%d.%d:%d/feed", sp.getInt("IoTFeedIP1", 142), sp.getInt("IoTFeedIP2", 250), sp.getInt("IoTFeedIP3", 207), sp.getInt("IoTFeedIP4", 110), sp.getInt("IoTFeedPORT", 80)));
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}