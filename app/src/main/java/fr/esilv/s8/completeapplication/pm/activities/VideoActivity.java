package fr.esilv.s8.completeapplication.pm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import fr.esilv.s8.completeapplication.R;

/**
 * Created by Paul on 21/03/2017.
 */
public class VideoActivity extends AppCompatActivity {

    private static final String URL = "URL";
    private String urlStr;
    private WebView webView;

    public static void start(Context context, String url){
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        urlStr = getIntent().getStringExtra(URL);
        webView = (WebView) findViewById(R.id.webView);
        setWebView(urlStr);
    }

    public void setWebView(String url){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

}
