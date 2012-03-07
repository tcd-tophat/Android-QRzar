package org.tophat.QRzar;

import android.app.Activity;
import android.os.Bundle;

/* Handle all signing in work */
public class SignInActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	if(signedIn()){
    		Intent signInIntent = new Intent(this, MainScreenActivity.class);
    		startActivity(signInIntent);
    	}
    	else{
    		//Handle login
    	}
    }
}
