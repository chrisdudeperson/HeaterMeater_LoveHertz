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

public class NewCook1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cook);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewCook1.this, Results2.class));
            }
        });


        ArrayAdapter<CharSequence> stringArrayAdapter=
                ArrayAdapter.createFromResource(this,
                        R.array.meat_names,
                        android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner =
                (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        TextView myTextView =
                                (TextView)findViewById(R.id.temptext);
                        if(position==0)
                            myTextView.setText(Integer.toString(180));
                        if(position==1)
                            myTextView.setText(Integer.toString(200));
                        if(position==2)
                            myTextView.setText(Integer.toString(190));
                        if(position==3)
                            myTextView.setText(Integer.toString(150));
                    }


                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        TextView myTextView =
                                (TextView)findViewById(R.id.temptext);
                        myTextView.setText(Integer.toString(180));

                    }
                };

    }
}
