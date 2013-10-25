package com.mobilead.cube3dadpost1;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;

import com.nbpcorp.mobilead.sdk.MobileAdListener;
import com.nbpcorp.mobilead.sdk.MobileAdView;

public class MainActivity extends Activity implements MobileAdListener  {
	private MobileAdView adView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
    	glSurfaceView.setRenderer(new CubeRenderer(false));
    
    	adView = (MobileAdView) findViewById(R.id.adview1);
    	adView.setListener(this); 
    	adView.start(); 
   	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onDestroy() {
    	super.onDestroy();
    	if (adView != null) {
    		adView.destroy();
    		adView = null;
    	}
    }
    
    @Override
    public void onReceive(int err) {
    // event for receive ad
    }
}
