package hm.heatermeater;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

public class Time_Frag extends Fragment {

    private Server server;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_time_, container, false);

        JSONObject obj;
        server = new Server();
        //server.connectWebSocket();
        int targetTime=0, targetTemp=0;

        //while(true)
        //{
            try{
                obj = server.serverRequest(view);
                targetTime = obj.getInt("ETA");
                targetTemp = obj.getInt("RequiredTemp");

                Log.i("Target Time:", Integer.toString(targetTemp));

                TextView temperature = (TextView) view.findViewById(R.id.temperature);
                temperature.setText(Integer.toString(targetTemp));

                TextView time = (TextView) view.findViewById(R.id.time);
                time.setText(Integer.toString(targetTime));

                //Thread.sleep(1000);
            }
            catch (Exception e){}
        //}
        return view;
    }
/*
    @Override
    public void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph

        TextView temperature = (TextView) findViewById(R.id.temperature);
        temperature.setText(Integer.toString(targetTemp));

    }*/

}
