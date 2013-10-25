package com.mobilead.cube3dadam2;

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
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private static final String LOGTAG = "BannerTypeJava";
	private RelativeLayout relativeLayout = null;
	private AdView adView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
    	glSurfaceView.setRenderer(new CubeRenderer(false));

    	RelativeLayout layout = (RelativeLayout)findViewById(R.id.linearLayout);
    	
    	// Ad@m 광고 뷰 생성 및 설정
    	adView = new AdView(this);
    	
	    // 할당 받은 clientId 설정
	    adView.setClientId("44b0Z1NT13c7f2b4ae5");
	    // 광고 갱신 시간 : 기본 60초
	    adView.setRequestInterval(12);
	    // Animation 효과 : 기본 값은 AnimationType.NONE
	    adView.setAnimationType(AnimationType.FLIP_HORIZONTAL);
	    adView.setVisibility(View.VISIBLE);
	    
	    // XML상에 android:layout_alignParentBottom="true"와 같은 역할을 함
	    /*
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
	              ViewGroup.LayoutParams.WRAP_CONTENT,
	              ViewGroup.LayoutParams.WRAP_CONTENT);
	    
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    // 앞에서 만든 params 레이아웃을 광고 뷰에 적용함.
	    adView.setLayoutParams(params);
	    */
	    layout.addView(adView);

    
	    // 광고 클릭시 실행할 리스너
    	adView.setOnAdClickedListener(new OnAdClickedListener() {
    		@Override
    		public void OnAdClicked() {
    			Log.i(LOGTAG, "광고를 클릭했습니다.");
    		}
    	});
    	
    	// 광고 내려받기 실패했을 경우에 실행할 리스너
    	adView.setOnAdFailedListener(new OnAdFailedListener() {
    		@Override
    		public void OnAdFailed(AdError arg0, String arg1) {
    			Log.w(LOGTAG, arg1);
    		}
    	});

    	// 광고를 정상적으로 내려받았을 경우에 실행할 리스너
    	adView.setOnAdLoadedListener(new OnAdLoadedListener() {
    		@Override
    		public void OnAdLoaded() {
    			Log.i(LOGTAG, "광고가 정상적으로 로딩되었습니다.");
    		}
    	});
    	
    	// 광고를 불러올때 실행할 리스너
    	adView.setOnAdWillLoadListener(new OnAdWillLoadListener() {
    		@Override
    		public void OnAdWillLoad(String arg1) {
    			Log.i(LOGTAG, "광고를 불러옵니다. : " + arg1);
    		}
    	});
    	
    	// 광고를 닫았을때 실행할 리스너
	    adView.setOnAdClosedListener(new OnAdClosedListener() {
	    	@Override
	    	public void OnAdClosed() {
	    		Log.i(LOGTAG, "광고를 닫았습니다.");
	    	}
	    });
        
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
}
