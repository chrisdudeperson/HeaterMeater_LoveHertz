package hm.heatermeater;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Results extends TabActivity {

    TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost); ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Tab setup---------------------------------------
        TabHost.TabSpec ts1 = tabHost.newTabSpec("Time");
        ts1.setIndicator("Tab1");
        ts1.setContent(new Intent(this, TimeScreen.class));
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("Graph");
        ts2.setIndicator("Tab2");
        ts2.setContent(new Intent(this, GraphScreen.class));
        tabHost.addTab(ts2);
        //-----------------------------------------------------
    }
}
