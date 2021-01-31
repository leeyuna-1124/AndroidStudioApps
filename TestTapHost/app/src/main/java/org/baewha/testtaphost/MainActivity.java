package org.baewha.testtaphost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec aaa= tabHost.newTabSpec("강아지").setIndicator("강아지");
        aaa.setContent(R.id.강아지);
        tabHost.addTab(aaa);

        TabHost.TabSpec bbb= tabHost.newTabSpec("고양이").setIndicator("고양이");
        bbb.setContent(R.id.고양이);
        tabHost.addTab(bbb);

        TabHost.TabSpec ccc= tabHost.newTabSpec("토끼").setIndicator("토끼");
        ccc.setContent(R.id.토끼);
        tabHost.addTab(ccc);

        TabHost.TabSpec ddd= tabHost.newTabSpec("말").setIndicator("말");
        ddd.setContent(R.id.말);
        tabHost.addTab(ddd);

        tabHost.setCurrentTab(0);
    }
}