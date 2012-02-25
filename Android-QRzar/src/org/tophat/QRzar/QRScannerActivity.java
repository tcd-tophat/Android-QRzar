package org.tophat.QRzar;

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
}
