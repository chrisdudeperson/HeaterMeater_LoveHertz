package hm.heatermeater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

public class NewCook extends AppCompatActivity {

    int temp;
    int meat;
    int FT; //finish time
    int RT; //required temperature

    private Server server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cook);

        server = new Server();
        server.connectWebSocket();


        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewCook.this, Results2.class));
            }
        });

        ArrayAdapter<CharSequence> stringArrayAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.meat_names,
                        android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner =
                (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);

        //final Calendar c = Calendar.getInstance();

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        TextView targetTemp =
                                (TextView) findViewById(R.id.tttext);
                        TextView finishTime =
                                (TextView) findViewById(R.id.finishtimetext);
                        TextView ovenTemp =
                                (TextView) findViewById(R.id.oventemptext);
                        if (position == 0) {//beef
                            meat = 0;
                            targetTemp.setText("70 °C");
                            RT = 70;
                            finishTime.setText("65 min");
                            FT = 65;
                            ovenTemp.setText("180 °C");
                        } else if (position == 1) {//chicken
                            meat = 1;
                            targetTemp.setText("70 °C");
                            RT = 70;
                            finishTime.setText("60 min");
                            FT = 60;
                            ovenTemp.setText("190 °C");
                        } else if (position == 2) {//pork
                            meat = 2;
                            targetTemp.setText("70 °C");
                            RT = 70;
                            finishTime.setText("77 min");
                            FT = 77;
                            ovenTemp.setText("180 °C");
                        } else if (position == 3) {//lamb
                            meat = 3;
                            targetTemp.setText("70 °C");
                            RT = 70;
                            finishTime.setText("55 min");
                            FT = 55;
                            ovenTemp.setText("180 °C");
                        } else
                            targetTemp.setText("err");
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        TextView myTextView =
                                (TextView) findViewById(R.id.tttext);
                        myTextView.setText(Integer.toString(70));//default

                    }
                };

        ArrayAdapter<CharSequence> stringArrayAdapter1 =
                ArrayAdapter.createFromResource(this,
                        R.array.weight,
                        android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner1 =
                (Spinner) findViewById(R.id.spinner2);
        spinner1.setAdapter(stringArrayAdapter1);

        AdapterView.OnItemSelectedListener onSpinner1 =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        TextView targetTemp =
                                (TextView) findViewById(R.id.tttext);
                        TextView finishTime =
                                (TextView) findViewById(R.id.finishtimetext);
                        TextView ovenTemp =
                                (TextView) findViewById(R.id.oventemptext);
                        //1kg
                        if (position == 0 && meat == 0) {
                            finishTime.setText("65 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 0 && meat == 1) {
                            finishTime.setText("60 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("190 °C");
                        } else if (position == 0 && meat == 2) {
                            finishTime.setText("77 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 0 && meat == 3) {
                            finishTime.setText("65 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        }
                        //1.5kg
                        else if (position == 1 && meat == 0) {
                            finishTime.setText("100 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 1 && meat == 1) {
                            finishTime.setText("80 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("190 °C");
                        } else if (position == 1 && meat == 2) {
                            finishTime.setText("116 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 1 && meat == 3) {
                            finishTime.setText("100 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        }
                        //2kg
                        else if (position == 2 && meat == 0) {
                            finishTime.setText("133 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 2 && meat == 1) {
                            finishTime.setText("100 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("190 °C");
                        } else if (position == 2 && meat == 2) {
                            finishTime.setText("155 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 2 && meat == 3) {
                            finishTime.setText("133 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        }
                        //3kg
                        else if (position == 3 && meat == 0) {
                            finishTime.setText("200 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 3 && meat == 1) {
                            finishTime.setText("140 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("190 °C");
                        } else if (position == 3 && meat == 2) {
                            finishTime.setText("233 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else if (position == 3 && meat == 3) {
                            finishTime.setText("200 mins");
                            targetTemp.setText("70 °C");
                            ovenTemp.setText("180 °C");
                        } else
                            targetTemp.setText("err");
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        TextView myTextView =
                                (TextView) findViewById(R.id.tttext);
                        myTextView.setText(Integer.toString(180));

                    }
                };

        /*ArrayAdapter<CharSequence> stringArrayAdapter2=
                ArrayAdapter.createFromResource(this,
                        R.array.how_cooked,
                        android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner2 =
                (Spinner) findViewById(R.id.spinner3);
        spinner1.setAdapter(stringArrayAdapter2);

        AdapterView.OnItemSelectedListener onSpinner2 =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        TextView myTextView =
                                (TextView)findViewById(R.id.oventemptext);
                        if(position==0)//beef
                            myTextView.setText(Integer.toString(180));
                        else if(position==1)//chicken
                            myTextView.setText(Integer.toString(190));
                        else if(position==2)//pork
                            myTextView.setText(Integer.toString(180));
                        else if(position==3)//lamb
                            myTextView.setText(Integer.toString(180));
                        else
                            myTextView.setText("err");
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        TextView myTextView =
                                (TextView)findViewById(R.id.oventemptext);
                        myTextView.setText(Integer.toString(180));

                    }
                };*/

        spinner.setOnItemSelectedListener(onSpinner);
        //spinner.setOnItemSelectedListener(onSpinner1);
        //spinner.setOnItemSelectedListener(onSpinner2);

        server.serverSend(FT, RT);
    }
}
