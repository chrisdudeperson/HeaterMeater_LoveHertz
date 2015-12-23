package hm.heatermeater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);

        Button roastButton = (Button) findViewById(R.id.roastButton);
        roastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipePage.this, RoastRecipe.class));
            }
        });

        Button chickenButton = (Button) findViewById(R.id.chickenButton);
        chickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipePage.this, ChickenRecipe.class));
            }
        });

        Button beefButton = (Button) findViewById(R.id.beefButton);
        beefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipePage.this, BeefRecipe.class));
            }
        });
    }
}
