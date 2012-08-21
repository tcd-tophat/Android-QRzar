package org.tophat.QRzar;

import org.tophat.android.networking.ApiCommunicator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class QRzarLaunch extends Activity {
	
	public static ApiCommunicator apic;
	public static Constants constants;
	
    /* Called when the app is first started. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingscreen);
        
        constants = new Constants();
        apic = new ApiCommunicator(constants);
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
    	
    	Intent signInIntent = new Intent(this, MainScreenActivity.class);
    	startActivity(signInIntent);
    }
}
