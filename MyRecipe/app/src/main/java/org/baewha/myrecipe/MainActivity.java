package org.baewha.myrecipe;

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

        TabHost.TabSpec ggigae = tabHost.newTabSpec("ggigae").setIndicator("찌개");
        ggigae.setContent(R.id.찌개);
        tabHost.addTab(ggigae);

       // TabHost.TabSpec bab = tabHost.newTabSpec("bab").setIndicator("밥");
       // ggigae.setContent(R.id.밥);
       // tabHost.addTab(bab);

       // TabHost.TabSpec ban = tabHost.newTabSpec("ban").setIndicator("반찬");
       // ggigae.setContent(R.id.반찬);
       // tabHost.addTab(ban);

       // TabHost.TabSpec gan = tabHost.newTabSpec("gan").setIndicator("간식");
       // ggigae.setContent(R.id.간식);
       // tabHost.addTab(gan);




        tabHost.setCurrentTab(0);
    }
}