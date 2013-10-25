package com.mobilead.cube3dinmobi1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdView;

public class MainActivity extends Activity {
	private IMAdView mIMAdView;
	private IMAdRequest mAdRequest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		// Get the IMAdView instance
		mIMAdView = (IMAdView) findViewById(R.id.imAdview);			
		
		// set the test mode to true (Make sure you set the test mode to false
		// when distributing to the users)
		mAdRequest = new IMAdRequest();
		mAdRequest.setTestMode(false);
		mIMAdView.setIMAdRequest(mAdRequest);
		
		//load new ad has to be called explicitly..Just adding xml to layout wont call load new ad
		mIMAdView.loadNewAd(mAdRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }    
}
