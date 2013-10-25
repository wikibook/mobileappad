package com.mobilead.cube3dadpost2;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

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
    
    	RelativeLayout layout = (RelativeLayout)findViewById(R.id.linearLayout);

    	adView = new MobileAdView(this); 
    	adView.setChannelID("mandroid_a0d6c63b341a4051b13af1a76af0f38e"); 
    	adView.setTest(false); 
    	adView.setListener(this);
    	adView.start(); 
    	
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
	              ViewGroup.LayoutParams.WRAP_CONTENT,
	              ViewGroup.LayoutParams.WRAP_CONTENT);
	    
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    // 앞에서 만든 params 레이아웃을 광고 뷰에 적용함.
	    adView.setLayoutParams(params);
	    
	    layout.addView(adView);
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
