package hm.heatermeater;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT =2;

    private String tabtitles[]= new String[] {"Time", "Graph"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){

            case 0:
                Time_Frag fragmenttab1 = new Time_Frag();
                return fragmenttab1;

            case 1:
                Graph_Frag fragmenttab2 = new Graph_Frag();
                return fragmenttab2;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabtitles[position];
    }
}
