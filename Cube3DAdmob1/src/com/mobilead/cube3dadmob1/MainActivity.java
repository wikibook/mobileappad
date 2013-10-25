package com.mobilead.cube3dadmob1;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
    	glSurfaceView.setRenderer(new CubeRenderer(false));
    
    	AdView adView = (AdView)this.findViewById(R.id.adView);
	    adView.loadAd(new AdRequest());
   	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
