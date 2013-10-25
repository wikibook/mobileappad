package com.mobilead.localad;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.ads.AdRequest;
import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibConfig;

public class MainActivity extends AdlibActivity {
	private com.google.ads.AdView adViewMob;
	private com.mocoplex.adlib.AdlibAdViewContainer adViewAdlib;

	protected void initAds()
    {
    	// 광고 스케줄링 설정을 위해 아래 내용을 프로그램 실행시 한번만 실행합니다. (처음 실행되는 activity에서 한번만 호출해주세요.)
    	
		// 광고 subview 의 패키지 경로를 설정합니다. (실제로 작성된 패키지 경로로 수정해주세요.)
		// 쓰지 않을 광고플랫폼은 삭제해주세요.
        AdlibConfig.getInstance().bindPlatform("ADAM","com.mobilead.localad.ads.SubAdlibAdViewAdam");
        AdlibConfig.getInstance().bindPlatform("ADMOB","com.mobilead.localad.ads.SubAdlibAdViewAdmob");
        AdlibConfig.getInstance().bindPlatform("NAVER","com.mobilead.localad.ads.SubAdlibAdViewNaverAdPost");

        // 쓰지 않을 플랫폼은 JAR 파일 및 test.adlib.project.ads 경로에서 삭제하면 최종 바이너리 크기를 줄일 수 있습니다.
        
        // adlibr.com 에서 발급받은 api 키를 입력합니다.
        // http://adlibr.com/admin/myapplist.jsp
        AdlibConfig.getInstance().setAdlibKey("511b44cae4b02fa05c6b9d5a");

        // 광고 타겟팅을 위한 사용자 정보를 입력합니다. (option)
        // gender(M/F/0), age(10/20/30/40/0), lat(위도), lon(경도)
        AdlibConfig.getInstance().setAdInfo("0", "0", "31.111", "127.111");
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		adViewAdlib = (com.mocoplex.adlib.AdlibAdViewContainer) findViewById(R.id.ads);
		adViewMob = (com.google.ads.AdView) this.findViewById(R.id.adview_admob);

		if (getResources().getConfiguration().locale.getCountry().equals("KR")) {
			adViewMob.setVisibility(View.INVISIBLE);

			initAds();
			this.setAdsContainer(R.id.ads);
		}
		else if (getResources().getConfiguration().locale.getCountry().equals("JP")) {
			adViewAdlib.setVisibility(View.INVISIBLE);
			adViewMob.setVisibility(View.INVISIBLE);
		}
		else {
			adViewAdlib.setVisibility(View.INVISIBLE);
			
			adViewMob.loadAd(new AdRequest());
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
