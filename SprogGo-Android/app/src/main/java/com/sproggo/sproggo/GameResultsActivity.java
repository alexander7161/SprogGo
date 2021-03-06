package com.sproggo.sproggo;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeMap;

public class GameResultsActivity extends AppCompatActivity {

    private MyAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_results);

        ListView listView = findViewById(R.id.result_list_view);
        //set up adapter
        listAdapter = new MyAdapter(this,new ArrayList<String>(Game.getWordsTested().keySet()));
        listView.setAdapter(listAdapter);

        TextView score = (TextView) findViewById(R.id.score_single);
        score.setText(Integer.toString(Game.getScore()));

        TextView correctWords = (TextView) findViewById(R.id.correct_images);
        correctWords.setText(Integer.toString(Game.getCorrectPhotosTaken()));

        TextView totalWords = (TextView) findViewById(R.id.total_images);
        totalWords.setText(Integer.toString(Game.getPhotosTaken()));


        Button button = findViewById(R.id.done_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameResultsActivity.this, MainActivity.class));
            }
        });
    }
}
