package com.nolanroe.magicscoreboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int player1Score = 20;
    private int player2Score = 20;
    private int player1GameScore = 0;
    private int player2GameScore = 0;
    private int draw = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayP1Score(int scored) {
        TextView p1Score = (TextView) findViewById(R.id.score);
        p1Score.setText(String.valueOf(scored));
    }

    public void displayP2Score(int scored) {
        TextView p2Score = (TextView) findViewById(R.id.score2);
        p2Score.setText(String.valueOf(scored));
    }

    public void displayP1MatchScore(int matchScore) {
        TextView p1MatchScore = (TextView) findViewById(R.id.player1_match_score);
        p1MatchScore.setText(String.valueOf(matchScore));
    }

    public void displayP2MatchScore(int matchScore) {
        TextView p2MatchScore = (TextView) findViewById(R.id.player2_match_score);
        p2MatchScore.setText(String.valueOf(matchScore));
    }

    public void displayDraws(int draws) {
        TextView drawsView = (TextView) findViewById(R.id.draws_view);
        drawsView.setText(String.valueOf(draws));
    }

    public void reset(View view) {
        player1Score = 20;
        player2Score = 20;
        displayP1Score(player1Score);
        displayP2Score(player2Score);
    }

    public void draw(View view) {
        ++draw;
        displayDraws(draw);
    }

    public void player1Victory(View view) {
        ++player1GameScore;
        displayP1MatchScore(player1GameScore);
    }

    public void player2Victory(View view) {
        ++player2GameScore;
        displayP2MatchScore(player2GameScore);
    }

    public void decrementP1(View view) {
        --player1Score;
        displayP1Score(player1Score);
    }

    public void incrementP1(View view) {
        ++player1Score;
        displayP1Score(player1Score);
    }

    public void decrementP2(View view) {
        --player2Score;
        displayP2Score(player2Score);
    }

    public void incrementP2(View view) {
        ++player2Score;
        displayP2Score(player2Score);
    }
}
