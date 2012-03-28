package org.tophat.QRzar;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class LoadingActivity extends Activity{
	
	public final static int SCAN_RESULT = 1;
	
	 /* Control the main screen of the app. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingscreen);
        
        new Thread() {
        	@Override
        	public void run()
        	{
        		try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		closeLoadingScreen();
        	}
        }.start();
        
    }
    
    private void closeLoadingScreen()
    {	
        setResult(RESULT_OK, this.getIntent());
        finish();    	
    }
}
