package com.nolanroe.magicscoreboard;

import android.app.Activity;
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
