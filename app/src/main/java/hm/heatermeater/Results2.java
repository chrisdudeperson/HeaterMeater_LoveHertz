package hm.heatermeater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.app.FragmentActivity;

public class Results2 extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}
