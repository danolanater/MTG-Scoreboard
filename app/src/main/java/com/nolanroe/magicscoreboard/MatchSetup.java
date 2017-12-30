package com.nolanroe.magicscoreboard;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Danolanater on 12/21/2017.
 */

public class MatchSetup extends ListActivity {

    private ArrayList<Player> playerArrayList = new ArrayList<Player>();
    private ArrayAdapter<Player> adapter;
    private int playerCounter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_setup);

        adapter = new PlayerAdapter(this,playerArrayList);
        playerArrayList.add(new Player("Player " + ++playerCounter, 20));
        playerArrayList.add(new Player("Player " + ++playerCounter, 20));
        setListAdapter(adapter);

        Spinner spinner = (Spinner) findViewById(R.id.format_options_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.format_array,
                R.layout.spinner_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button minusButton = (Button) findViewById(R.id.best_of_minus_button);
        final TextView bestOfGamesView = (TextView) findViewById(R.id.life_view);
        Button plusButton = (Button) findViewById(R.id.best_of_plus_button);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int games = Integer.parseInt(bestOfGamesView.getText().toString());

                if(games == 1) {
                    Toast.makeText(getApplicationContext(), "Can't have less than 1 game!", Toast.LENGTH_SHORT).show();
                } else {
                    games--;
                    bestOfGamesView.setText(String.valueOf(games));
                }
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int games = Integer.parseInt(bestOfGamesView.getText().toString());
                games++;
                bestOfGamesView.setText(String.valueOf(games));
            }
        });

        Button startGameButton = (Button) findViewById(R.id.start_game_button);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ScoreboardActivity.class);
                startActivity(i);
            }
        });
    }


    public void addPlayer(View v) {
        playerArrayList.add(new Player("Player " + ++playerCounter, 20));
        adapter.notifyDataSetChanged();
    }

}