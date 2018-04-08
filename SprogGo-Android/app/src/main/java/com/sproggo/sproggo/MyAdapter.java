package com.sproggo.sproggo;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter
{
    //Data
    private Activity activity;
    private ArrayList<String> words = null;

    public MyAdapter(Activity activity, ArrayList<String> words)
    {
        this.activity = activity;
        this.words = words;
    }

    public void setTasks(ArrayList<String> words)
    {
        this.words = words;
    }



    //Adapter components
    @Override
    public int getCount() {
        return words == null ? 0 : words.size();
    }

    @Override
    public Object getItem(int i) {
        return words.get(i);
    }

    @Override
    public long getItemId(int i) {
        String r = (String) getItem(i);
        return r == null ? -1 : i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v == null)
        {
            v = activity.getLayoutInflater().inflate(R.layout.results_list_view,viewGroup,false);
        }

        TextView title = v.findViewById(R.id.title_view);
        TextView dueDate = v.findViewById(R.id.correct_word);
        String word = (String) getItem(i);

        title.setText(word);
if(Game.getWordsTested().get(word)) {
    dueDate.setText("Correct");
} else {
    dueDate.setText("Wrong");

}
        return v;
    }
}
