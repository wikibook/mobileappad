package com.mobilead.cube3dinmobi2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.inmobi.androidsdk.IMAdView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        IMAdView imAdView = new IMAdView(MainActivity.this, IMAdView.INMOBI_AD_UNIT_320X50,
                "4028cbff379738bf0137d59ac8800cda");

	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
	              ViewGroup.LayoutParams.WRAP_CONTENT,
	              ViewGroup.LayoutParams.WRAP_CONTENT);
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    imAdView.setLayoutParams(params);

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.linearLayout);

        layout.addView(imAdView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
