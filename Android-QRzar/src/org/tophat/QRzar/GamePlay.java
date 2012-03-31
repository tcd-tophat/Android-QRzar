package org.tophat.QRzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GamePlay extends Activity{

    /* Called when the app is first started. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingscreen);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	
    	Intent signInIntent = new Intent(this, MainScreenActivity.class);
    	startActivity(signInIntent);
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	finish();
    }
}
