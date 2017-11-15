package com.nolanroe.magicscoreboard;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Danolanater on 11/14/2017.
 */

public class MatchHistoryAdapter extends ArrayAdapter<MatchHistory> {


    public MatchHistoryAdapter(Activity context, ArrayList<MatchHistory> matchHistories) {
        super(context, R.layout.list_item, matchHistories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            listItemView = li.inflate(R.layout.list_item,parent,false);
        }

        MatchHistory currentMatch = getItem(position);

        TextView bigLetterView = (TextView) listItemView.findViewById(R.id.big_letter);
        View squareView = (View) listItemView.findViewById(R.id.square);
        if(currentMatch.getmResult().equals("Win")) {
            bigLetterView.setText("W");
            squareView.setBackgroundColor(Color.parseColor("#008000"));
        }
        else if(currentMatch.getmResult().equals("Loss")) {
            bigLetterView.setText("L");
            squareView.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        else {
            bigLetterView.setText("D");
            squareView.setBackgroundColor(Color.parseColor("#A6A6A6"));
        }
        TextView opponentNameView = (TextView) listItemView.findViewById(R.id.opponent_name_textview);
        opponentNameView.setText(currentMatch.getmOpponentName());

        TextView gameTypeView = (TextView) listItemView.findViewById(R.id.game_type_textview);
        gameTypeView.setText(currentMatch.getmGameType());

        TextView matchScoreView = (TextView) listItemView.findViewById(R.id.match_score_textview);
        matchScoreView.setText(currentMatch.getmMatchScore());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date_textview);
        dateView.setText(currentMatch.getmDate());

        return listItemView;
    }
}
