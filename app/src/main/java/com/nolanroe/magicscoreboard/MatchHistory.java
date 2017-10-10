package com.nolanroe.magicscoreboard;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Danolanater on 10/9/2017.
 */

public class MatchHistory extends AppCompatActivity {
    private DatabaseHelper myDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_history);
        myDb = new DatabaseHelper(this);
    }

    public void viewAll(View view) {
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0)
            return;

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("Opponent :" + res.getString(1) + "\n");
            buffer.append("Match Type :" + res.getString(2) + "\n");
            buffer.append("Result :" + res.getString(3) + "\n\n");
        }
    }
}
