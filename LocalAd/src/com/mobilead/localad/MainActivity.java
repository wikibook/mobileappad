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
    	// ���� �����ٸ� ������ ���� �Ʒ� ������ ���α׷� ����� �ѹ��� �����մϴ�. (ó�� ����Ǵ� activity���� �ѹ��� ȣ�����ּ���.)
    	
		// ���� subview �� ��Ű�� ��θ� �����մϴ�. (������ �ۼ��� ��Ű�� ��η� �������ּ���.)
		// ���� ���� �����÷����� �������ּ���.
        AdlibConfig.getInstance().bindPlatform("ADAM","com.mobilead.localad.ads.SubAdlibAdViewAdam");
        AdlibConfig.getInstance().bindPlatform("ADMOB","com.mobilead.localad.ads.SubAdlibAdViewAdmob");
        AdlibConfig.getInstance().bindPlatform("NAVER","com.mobilead.localad.ads.SubAdlibAdViewNaverAdPost");

        // ���� ���� �÷����� JAR ���� �� test.adlib.project.ads ��ο��� �����ϸ� ���� ���̳ʸ� ũ�⸦ ���� �� �ֽ��ϴ�.
        
        // adlibr.com ���� �߱޹��� api Ű�� �Է��մϴ�.
        // http://adlibr.com/admin/myapplist.jsp
        AdlibConfig.getInstance().setAdlibKey("511b44cae4b02fa05c6b9d5a");

        // ���� Ÿ������ ���� ����� ������ �Է��մϴ�. (option)
        // gender(M/F/0), age(10/20/30/40/0), lat(����), lon(�浵)
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
