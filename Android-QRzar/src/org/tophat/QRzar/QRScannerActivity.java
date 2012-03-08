package org.tophat.QRzar;

import com.google.zxing.integration.android.IntentIntegrator;

import android.app.Activity;
import android.os.Bundle;

public class QRScannerActivity extends Activity{
	/*Handle scanning a QR code. */
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
    	IntentIntegrator integrator = new IntentIntegrator(this);
    	integrator.initiateScan();
    }
}
