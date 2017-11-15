package com.nolanroe.magicscoreboard;

import android.database.Cursor;
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

    private DatabaseHelper myDb = new DatabaseHelper(this);



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_history);

        Cursor res = myDb.getAllData();

        final ArrayList<MatchHistory> matches = new ArrayList<>();
        matches.add(new MatchHistory("OpponentName", "GameType", "#-#", "Date", "Win"));
        if(res.getCount() == 0) {

        }
        while(res.moveToNext()) {
            matches.add(new MatchHistory(res.getString(1), res.getString(2),res.getString(3),
                    res.getString(4),res.getString(5)));
        }

        ListAdapter adapter = new MatchHistoryAdapter(this, matches);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);





    }
}
