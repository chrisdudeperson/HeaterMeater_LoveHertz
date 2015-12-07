package hm.heatermeater;
//Test2
import android.app.Activity;
import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GraphScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            /* First Tab Content */
            TextView textView = new TextView(this);
            textView.setText("First Tab");
            setContentView(textView);
        //setContentView(R.layout.activity_graph_screen);
    }
}
