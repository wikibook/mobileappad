package com.mobilead.cube3dmediba1;

import mediba.ad.sdk.android.openx.MasAdView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	private MasAdView mad = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mad = (MasAdView)findViewById(R.id.adview);
        mad.setSid("9dc279bec0d0c4419582d58d1f8a11ca29bc24a4e39a3059");
        mad.start();        
    }

    @Override
    protected void onResume()
    {
        mad.start();
        super.onResume();
    }
     
    @Override
    protected void onPause()
    {
        mad.stop();
        super.onPause();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
