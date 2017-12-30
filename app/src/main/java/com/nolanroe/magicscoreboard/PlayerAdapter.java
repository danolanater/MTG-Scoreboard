package com.nolanroe.magicscoreboard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Danolanater on 12/26/2017.
 */



public class PlayerAdapter extends ArrayAdapter<Player> {

    String name;
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            name = editable.toString();
        }
    };


    public PlayerAdapter(Activity context, ArrayList<Player> playerArrayList) {
        super(context, R.layout.player_list_item, playerArrayList);
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;



        if(listItemView == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            listItemView = li.inflate(R.layout.player_list_item,parent,false);
        }

        Player currentPlayer = getItem(position);



        EditText playerNameView = (EditText) listItemView.findViewById(R.id.player_name);
        playerNameView.setHint(currentPlayer.getName());

        Button minusButton = (Button) listItemView.findViewById(R.id.minus_button);

        final TextView lifeView = (TextView) listItemView.findViewById(R.id.life_view);

        Button plusButton = (Button) listItemView.findViewById(R.id.plus_button);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int life = Integer.parseInt(lifeView.getText().toString());
                life--;
                lifeView.setText(String.valueOf(life));
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int life = Integer.parseInt(lifeView.getText().toString());
                life++;
                lifeView.setText(String.valueOf(life));
            }
        });

        return listItemView;
    }


}
