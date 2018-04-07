package com.sproggo.sproggo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Category hackathon = new Category(new String[] {"Laptop", "Phone", "Water", "Chair", "Table", "Fruit"});


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
