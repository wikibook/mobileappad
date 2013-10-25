package com.mobilead.cube3dadam1;

import net.daum.adam.publisher.AdView;
import net.daum.adam.publisher.AdView.AnimationType;
import net.daum.adam.publisher.AdView.OnAdClickedListener;
import net.daum.adam.publisher.AdView.OnAdClosedListener;
import net.daum.adam.publisher.AdView.OnAdFailedListener;
import net.daum.adam.publisher.AdView.OnAdLoadedListener;
import net.daum.adam.publisher.AdView.OnAdWillLoadListener;
import net.daum.adam.publisher.impl.AdError;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private static final String LOGTAG = "BannerTypeXML1";
	private AdView adView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
    	glSurfaceView.setRenderer(new CubeRenderer(false));
    
    	initAdam();
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
    
    private void initAdam() {    
    	// Ad@m sdk 초기화 시작
    	adView = (AdView) findViewById(R.id.adview);
    	// 광고 리스너 설정
    	// 1. 광고 클릭시 실행할 리스너
    	adView.setOnAdClickedListener(new OnAdClickedListener() {
    		@Override
    		public void OnAdClicked() {
    			Log.i(LOGTAG, "광고를 클릭했습니다.");
    		}
    	});
    	
    	// 2. 광고 내려받기 실패했을 경우에 실행할 리스너
    	adView.setOnAdFailedListener(new OnAdFailedListener() {
    		@Override
    		public void OnAdFailed(AdError error, String message) {
    			Log.w(LOGTAG, message);
    		}
    	});
    	
    	// 3. 광고를 정상적으로 내려받았을 경우에 실행할 리스너
    	adView.setOnAdLoadedListener(new OnAdLoadedListener() {
    		@Override
    		public void OnAdLoaded() {
    			Log.i(LOGTAG, "광고가 정상적으로 로딩되었습니다.");
    		}
    	});
    	
    	// 4. 광고를 불러올때 실행할 리스너
    	adView.setOnAdWillLoadListener(new OnAdWillLoadListener() {
    		@Override
    		public void OnAdWillLoad(String url) {
    			Log.i(LOGTAG, "광고를 불러옵니다. : " + url);
    		}
    	});
    	
    	// 5. 전면형 광고를 닫았을때 실행할 리스너
    	adView.setOnAdClosedListener(new OnAdClosedListener() {
    		@Override
    		public void OnAdClosed() {
    			Log.i(LOGTAG, "광고를 닫았습니다.");
    		}
    	});
    	
    	// 할당 받은 clientId 설정
    	// adView.setClientId("TestClientId");
    	// 광고 갱신 주기를 12초로 설정
    	// adView.setRequestInterval(12);
    	// 광고 영역에 캐시 사용 여부 : 기본 값은 true
    	adView.setAdCache(false);
    	// Animation 효과 : 기본 값은 AnimationType.NONE
    	adView.setAnimationType(AnimationType.FLIP_HORIZONTAL);
    	adView.setVisibility(View.VISIBLE);
    }    	
}
