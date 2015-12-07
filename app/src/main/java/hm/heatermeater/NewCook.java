package hm.heatermeater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class NewCook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cook);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewCook.this, Results2.class));
            }
        });

        ArrayAdapter<CharSequence> stringArrayAdapter=
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
                                (TextView)findViewById(R.id.tttext);
                        TextView finishTime =
                                (TextView)findViewById(R.id.finishtimetext);
                        TextView ovenTemp =
                                (TextView)findViewById(R.id.oventemptext);
                        if(position==0) {//beef
                            targetTemp.setText("60 °C");
                            finishTime.setText("55 mins");
                            ovenTemp.setText("180 °C");
                        }
                        else if(position==1) {//chicken
                            targetTemp.setText("70 °C");
                            finishTime.setText("60 mins");
                            ovenTemp.setText("190 °C");
                        }
                        else if(position==2) {//pork
                            targetTemp.setText("70 °C");
                            finishTime.setText("77 mins");
                            ovenTemp.setText("180 °C");
                        }
                        else if(position==3) {//lamb
                            targetTemp.setText("60 °C");
                            finishTime.setText("55 mins");
                            ovenTemp.setText("180 °C");
                        }
                        else
                            targetTemp.setText("err");
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        TextView myTextView =
                                (TextView)findViewById(R.id.tttext);
                        myTextView.setText(Integer.toString(70));//default

                    }
                };
/*
        ArrayAdapter<CharSequence> stringArrayAdapter1=
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
                        TextView myTextView =
                                (TextView)findViewById(R.id.tttext);
                        if(position==0)//beef
                            myTextView.setText(Integer.toString(180));
                        else if(position==1)//chicken
                            myTextView.setText(Integer.toString(190));
                        else if(position==2)//pork
                            myTextView.setText(Integer.toString(180));
                        else if(position==3)//lamb
                            myTextView.setText(Integer.toString(180));
                        else
                            myTextView.setText(Integer.toString(1));
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        TextView myTextView =
                                (TextView)findViewById(R.id.tttext);
                        myTextView.setText(Integer.toString(180));

                    }
                };

        ArrayAdapter<CharSequence> stringArrayAdapter2=
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
    }
}
