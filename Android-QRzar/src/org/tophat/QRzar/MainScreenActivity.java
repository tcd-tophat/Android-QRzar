package org.tophat.QRzar;


import org.tophat.android.exceptions.Forbidden;
import org.tophat.android.exceptions.HttpException;
import org.tophat.android.exceptions.NoInternetConnection;
import org.tophat.android.exceptions.NotFound;
import org.tophat.android.exceptions.Unauthorised;
import org.tophat.android.model.ApiTokenMapper;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainScreenActivity extends Activity{
	
	public final static int SCAN_RESULT = 1;
	
	public static QRparser playerDetails;
	
	public static Context c;
	
	 /* Control the main screen of the app. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        
        playerDetails = null;
        
        c = this.getApplicationContext();
    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    }
    
    public void showRanks(View v)
    {
    	System.out.println("View v");
    	
    	showNotification("Pressed Show Rank");
    }
    
    public void showInfo(View v)
    {
    	System.out.println("Info v");
    	showNotification("Pressed Info");
    }
 
    public void joinGame(View v)
    {
		new AnonTokenTask().execute();    	
    }
    
    public void qrcodeScan()
    {
    	System.out.println("Join Game");
    	showNotification("Pressed Join Game");
    	
		Intent intent = new Intent("com.google.zxing.client.android.SCAN_QR");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, SCAN_RESULT);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) 
    {
    	  if (intent != null) 
    	  {
    		  String response = intent.getStringExtra("SCAN_RESULT");
    		  
    		  QRparser qr = new QRparser(response);
    		  
    		  if( qr.isValid() )
    		  {
	    		  showNotification("Team " + qr.getTeam() );
	    		  showNotification("Game ID " + qr.getGameId() );
	    		  showNotification("Player ID " + qr.getPlayerId() );
	    		  
	    		  playerDetails = qr;
	    		  
				  Intent myIntent = new Intent(c, PlayGame.class);
				  startActivityForResult(myIntent, 8);
				  
				  //TCPStream tcp = new TCPStream();
	    	        
	    		  try
	    		  {
	    			  //tcp.connect();
	    		  } 
	    		  catch ( Exception e )
	    		  {
	    			  e.printStackTrace();
	    		  }
    		  }
    		  else
    		  {
    			  showNotification("The Scanned QR Code was invalid.");
    		  }
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
	
	private class AnonTokenTask extends AsyncTask<String, Integer, String> 
	{
		 
		private ProgressDialog dialog;
		
		@Override    
		protected void onPreExecute() 
		{       
		    super.onPreExecute();
		    dialog = ProgressDialog.show(MainScreenActivity.this, "", 
                    "Loading. Please wait...", true);
		}
		    
		protected String doInBackground(String... details) 
		{
			ApiTokenMapper atm = new ApiTokenMapper(QRzarLaunch.apic);
			 
			try 
			{
				QRzarLaunch.apic.setApitoken(atm.getAnonymousToken());
			} 
			catch (Forbidden f)
			{
				return "Getting an Anonymous token is forbidden here";
			}
			catch (NoInternetConnection e)
			{
				return "Please ensure you have an working internet connection, and please try again.";
			}
			catch (HttpException e) 
			{
				e.printStackTrace();
				return "Error. Please check logs.";
			}
			 
			return null;
		 }

	     protected void onPostExecute(String error)
	     {
	    	 dialog.cancel();
	    	 
	    	 if (error == null)
	    	 {
	    		 qrcodeScan();
	    	 }
	    	 else
	    	 {
	    		showNotification(error);
	    	 }
	     }
	 }
}
