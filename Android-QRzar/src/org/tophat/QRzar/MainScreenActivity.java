package org.tophat.QRzar;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainScreenActivity extends Activity{
	
	public final static int SCAN_RESULT = 1;
	
	public static Context c;
	
	 /* Control the main screen of the app. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        
        c = this.getApplicationContext();
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
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  if (intent != null) {
    		  String response = intent.getStringExtra("SCAN_RESULT");
    		  setContentView(R.layout.mainscreen);
    		  showNotification("data" + response );
    	  }
    }
    
	/**
	 * Makes Toast twice as fast, without burning!
	 * @param data
	 */
	public static void showNotification(String data)
	{
		MainScreenActivity.showNotification(data, Toast.LENGTH_SHORT);
	}

	/**
	 * Shows the notification for a custom defined period.
	 * @param data
	 * @param duration
	 */
	public static void showNotification(String data, int duration)
	{
		Toast toast;
		toast = Toast.makeText(MainScreenActivity.c, data, duration);
		toast.show();
	}
}
