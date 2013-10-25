package com.mobilead.adlib;

import android.os.Bundle;
import android.view.Menu;

import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibConfig;

public class MainActivity extends AdlibActivity {

	protected void initAds()
    {
        AdlibConfig.getInstance().bindPlatform("ADAM","com.mobilead.adlib.ads.SubAdlibAdViewAdam");
        AdlibConfig.getInstance().bindPlatform("ADMOB","com.mobilead.adlib.ads.SubAdlibAdViewAdmob");
        AdlibConfig.getInstance().bindPlatform("NAVER","com.mobilead.adlib.ads.SubAdlibAdViewNaverAdPost");

        AdlibConfig.getInstance().setAdlibKey("511b44cae4b02fa05c6b9d5a");

        AdlibConfig.getInstance().setAdInfo("0", "0", "31.111", "127.111");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initAds();
		this.setAdsContainer(R.id.ads);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
