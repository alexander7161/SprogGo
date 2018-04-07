package com.sproggo.sproggo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // add more categories with more words as desired
    // ideally over fifteen words in each category
    Category hackathon = new Category(new String[] {"laptop", "phone", "water", "chair", "table", "fruit"});
    Category animal = new Category(new String[] {"dog", "cat", "pig", "sheep", "cow", "horse", "spider", "hippopotamus", "elephant"});
    Category garden = new Category(new String[] {"flower", "tree", "grass"});

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        DescribeActivity.class);
                startActivity(myIntent);
            }
        });
    }

    }
