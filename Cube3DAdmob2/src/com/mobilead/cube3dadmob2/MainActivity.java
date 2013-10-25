package com.mobilead.cube3dadmob2;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MainActivity extends Activity {
	private AdView adView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
    	glSurfaceView.setRenderer(new CubeRenderer(false));
    	
    	AdRequest adRequest = new AdRequest();
		adView = new AdView(this, AdSize.BANNER, "a1510b12aa73ce6");
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.linearLayout);
		
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
	              ViewGroup.LayoutParams.WRAP_CONTENT,
	              ViewGroup.LayoutParams.WRAP_CONTENT);
	    
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    adView.setLayoutParams(params);	    
		
		layout.addView(adView);
		adView.loadAd(adRequest);
   	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
