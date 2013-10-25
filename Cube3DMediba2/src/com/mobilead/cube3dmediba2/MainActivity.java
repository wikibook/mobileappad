package com.mobilead.cube3dmediba2;

import mediba.ad.sdk.android.openx.MasAdView;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private final String TAG = "MedibaAd";
	private final int WC = LayoutParams.WRAP_CONTENT;
	private final int FP = LayoutParams.FILL_PARENT;

	MasAdView mad = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		// ContentView		
		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(new LayoutParams(FP, FP));
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		mad = new MasAdView(this);
		//mad.setSid("9dc279bec0d0c4419582d58d1f8a11ca29bc24a4e39a3059");
		mad.setSid("2c81229f027a01903c6e85c0d5e8aaf91ef0031499b2e8b0");

		layout.addView(mad);
    }

	@Override
	public void onResume() {
		super.onResume();
		mad.start();
		Log.i(TAG, "onResume");
	}

	@Override
	public void onPause() {
		super.onPause();
		mad.stop();
		Log.i(TAG, "onPause");
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
