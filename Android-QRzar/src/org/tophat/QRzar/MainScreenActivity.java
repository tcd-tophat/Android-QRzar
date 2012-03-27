package org.tophat.QRzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreenActivity extends Activity{
	
	public final static int SCAN_RESULT = 1;
	
	 /* Control the main screen of the app. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    }
    
    public void showRanks(View v)
    {
    	System.out.println("View v");
    }
    
    public void showInfo(View v)
    {
    	System.out.println("Info v");
    }
    
    public void joinGame(View v)
    {
    	System.out.println("Join Game");
    	
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, SCAN_RESULT);
		setContentView(R.layout.loadingscreen);
    }
}
