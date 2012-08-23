package org.tophat.QRzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CountDown extends Activity{

    /* Called when the app is first started. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
        
        TextView ta  = (TextView) findViewById(R.id.player_team);
        
        ta.setText((MainScreenActivity.playerDetails.getTeam()));
        
        TextView ta1  = (TextView) findViewById(R.id.playerId);
        
        ta1.setText(""+(MainScreenActivity.playerDetails.getPlayerId()));
        
        TextView ta2  = (TextView) findViewById(R.id.game_id);
        
        ta2.setText(""+(MainScreenActivity.playerDetails.getGameId()));
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    }
}
