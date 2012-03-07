package org.tophat.QRzar;

import android.app.Activity;
import android.os.Bundle;

public class AndroidQRzarActivity extends Activity {
    /* Called when the app is first started. */
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
    	Intent signInIntent = new Intent(this, SignInActivity.class);
    	startActivity(signInIntent);
    }
}
