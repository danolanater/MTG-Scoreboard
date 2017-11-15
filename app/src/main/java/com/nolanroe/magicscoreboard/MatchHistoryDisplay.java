package com.nolanroe.magicscoreboard;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Danolanater on 11/14/2017.
 */

public class MatchHistoryDisplay extends AppCompatActivity {

    private DatabaseHelper myDb = new DatabaseHelper(this);
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_history);

        Cursor res = myDb.getAllData();

        final ArrayList<MatchHistory> matches = new ArrayList<>();
        matches.add(new MatchHistory("OpponentName", "GameType", "#-#", "Date", "Win"));

        while(res.moveToNext()) {
            matches.add(new MatchHistory(res.getString(1), res.getString(2),res.getString(3),
                    res.getString(4),res.getString(5)));
            String result = res.getString(5);
            if(result.equals("Win"))
                wins++;
            else if (result.equals("Loss"))
                losses++;
            else
                draws++;
        }

        TextView record = (TextView) findViewById(R.id.record_textview);
        record.setText("Overall Record: " + wins + "/" + losses + "/" + draws);

        ListAdapter adapter = new MatchHistoryAdapter(this, matches);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}