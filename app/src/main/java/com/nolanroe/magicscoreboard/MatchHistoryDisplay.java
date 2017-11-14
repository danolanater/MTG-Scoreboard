package com.nolanroe.magicscoreboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Danolanater on 11/14/2017.
 */

public class MatchHistoryDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_history);

        final ArrayList<MatchHistory> matches = new ArrayList<>();
        matches.add(new MatchHistory("This", "Is", "A", "Test"));

        ListAdapter adapter = new MatchHistoryAdapter(this, matches);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);





    }
}
