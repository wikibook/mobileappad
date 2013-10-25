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
    	// Ad@m sdk �ʱ�ȭ ����
    	adView = (AdView) findViewById(R.id.adview);
    	// ���� ������ ����
    	// 1. ���� Ŭ���� ������ ������
    	adView.setOnAdClickedListener(new OnAdClickedListener() {
    		@Override
    		public void OnAdClicked() {
    			Log.i(LOGTAG, "���� Ŭ���߽��ϴ�.");
    		}
    	});
    	
    	// 2. ���� �����ޱ� �������� ��쿡 ������ ������
    	adView.setOnAdFailedListener(new OnAdFailedListener() {
    		@Override
    		public void OnAdFailed(AdError error, String message) {
    			Log.w(LOGTAG, message);
    		}
    	});
    	
    	// 3. ���� ���������� �����޾��� ��쿡 ������ ������
    	adView.setOnAdLoadedListener(new OnAdLoadedListener() {
    		@Override
    		public void OnAdLoaded() {
    			Log.i(LOGTAG, "���� ���������� �ε��Ǿ����ϴ�.");
    		}
    	});
    	
    	// 4. ���� �ҷ��ö� ������ ������
    	adView.setOnAdWillLoadListener(new OnAdWillLoadListener() {
    		@Override
    		public void OnAdWillLoad(String url) {
    			Log.i(LOGTAG, "���� �ҷ��ɴϴ�. : " + url);
    		}
    	});
    	
    	// 5. ������ ���� �ݾ����� ������ ������
    	adView.setOnAdClosedListener(new OnAdClosedListener() {
    		@Override
    		public void OnAdClosed() {
    			Log.i(LOGTAG, "���� �ݾҽ��ϴ�.");
    		}
    	});
    	
    	// �Ҵ� ���� clientId ����
    	// adView.setClientId("TestClientId");
    	// ���� ���� �ֱ⸦ 12�ʷ� ����
    	// adView.setRequestInterval(12);
    	// ���� ������ ĳ�� ��� ���� : �⺻ ���� true
    	adView.setAdCache(false);
    	// Animation ȿ�� : �⺻ ���� AnimationType.NONE
    	adView.setAnimationType(AnimationType.FLIP_HORIZONTAL);
    	adView.setVisibility(View.VISIBLE);
    }    	
}
