package org.tophat.QRzar;

import android.app.Activity;
import android.os.Bundle;

public class MainScreenActivity extends Activity{
	 /* Control the main screen of the app. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    }
}
