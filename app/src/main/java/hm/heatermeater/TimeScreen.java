package hm.heatermeater;

import android.app.Activity;
import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Second Tab");
        setContentView(textView);
       // setContentView(R.layout.activity_time_screen);
    }
}
