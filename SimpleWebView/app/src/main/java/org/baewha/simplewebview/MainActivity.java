package org.baewha.simplewebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn, btn2;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        wv = findViewById(R.id.wv);
        MyWebView mywebview = new MyWebView(); //인스턴스 생성
        wv.setWebViewClient(mywebview); //이너클래스를 만들고 셋팅해야함
        WebSettings webset = wv.getSettings();//셋팅 정보를 가져옴
        webset.setBuiltInZoomControls(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wv.loadUrl(et.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wv.goBack();
            }
        });

    }

    public class MyWebView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}