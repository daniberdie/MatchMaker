package com.example.matchmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

public class MatchInfoActivity extends AppCompatActivity {

    private TextView description, location, date, time, level, players;
    private String strDesc, strLoc, strDate, strTime, strLevel, strPlayers;
    private Set<String> setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_info);

        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_infoMatch);

        description = findViewById(R.id.saved_description);
        location = findViewById(R.id.saved_ubi);
        date = findViewById(R.id.saved_date);
        time = findViewById(R.id.saved_time);
        level = findViewById(R.id.saved_level);
        players = findViewById(R.id.saved_players);

        if(getIntent().getStringExtra("sport").equals("fut"))
        {
            layout.setBackground(getResources().getDrawable(R.drawable.football));
        }
        else if(getIntent().getStringExtra("sport").equals("bas"))
        {
            layout.setBackground(getResources().getDrawable(R.drawable.basket));
        }
        else if(getIntent().getStringExtra("sport").equals("pad"))
        {
            layout.setBackground(getResources().getDrawable(R.drawable.padel_initial));
        }

        setTextInfoActivity();

    }

    private void setTextInfoActivity() {
        getDataInfo(this);
        description.setText(strDesc);
        //location.setText(strLoc);
        date.setText(strDate);
        time.setText(strTime);
        level.setText(strLevel);
        players.setText(strPlayers);

    }

    private void getDataInfo(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.match_shared_data),Context.MODE_PRIVATE);
        setData = sharedPref.getStringSet(getString(R.string.saved_data),null);
        String [] dataArray;
        dataArray = setData.toArray(new String[setData.size()]);
        //TODO: Revisar ordre he fet un apanyo temporal XD
        strDesc = dataArray [4];
        strLoc  = dataArray [0];
        strDate = dataArray [2];
        strTime = dataArray [3];
        strLevel = dataArray [5];
        strPlayers = dataArray [1];
    }
}
