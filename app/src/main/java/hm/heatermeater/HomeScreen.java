package hm.heatermeater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Buttons linking home screen to all other activities---------------
        Button newCookBtn = (Button) findViewById(R.id.newCookButton);
        newCookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, NewCook.class));
            }
        });
        Button recipeBookBtn = (Button) findViewById(R.id.recipeBookButton);
        recipeBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, RecipePage.class));
            }
        });
        Button previousCooksBtn = (Button) findViewById(R.id.previousCooksButton);
        previousCooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, PreviousCooks.class));
            }
        });
        //----------------------------------------------------------------------
    }
}
