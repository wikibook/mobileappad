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
    	
    	// Ad@m ���� �� ���� �� ����
    	adView = new AdView(this);
    	
	    // �Ҵ� ���� clientId ����
	    adView.setClientId("44b0Z1NT13c7f2b4ae5");
	    // ���� ���� �ð� : �⺻ 60��
	    adView.setRequestInterval(12);
	    // Animation ȿ�� : �⺻ ���� AnimationType.NONE
	    adView.setAnimationType(AnimationType.FLIP_HORIZONTAL);
	    adView.setVisibility(View.VISIBLE);
	    
	    // XML�� android:layout_alignParentBottom="true"�� ���� ������ ��
	    /*
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
	              ViewGroup.LayoutParams.WRAP_CONTENT,
	              ViewGroup.LayoutParams.WRAP_CONTENT);
	    
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    // �տ��� ���� params ���̾ƿ��� ���� �信 ������.
	    adView.setLayoutParams(params);
	    */
	    layout.addView(adView);

    
	    // ���� Ŭ���� ������ ������
    	adView.setOnAdClickedListener(new OnAdClickedListener() {
    		@Override
    		public void OnAdClicked() {
    			Log.i(LOGTAG, "���� Ŭ���߽��ϴ�.");
    		}
    	});
    	
    	// ���� �����ޱ� �������� ��쿡 ������ ������
    	adView.setOnAdFailedListener(new OnAdFailedListener() {
    		@Override
    		public void OnAdFailed(AdError arg0, String arg1) {
    			Log.w(LOGTAG, arg1);
    		}
    	});

    	// ���� ���������� �����޾��� ��쿡 ������ ������
    	adView.setOnAdLoadedListener(new OnAdLoadedListener() {
    		@Override
    		public void OnAdLoaded() {
    			Log.i(LOGTAG, "���� ���������� �ε��Ǿ����ϴ�.");
    		}
    	});
    	
    	// ���� �ҷ��ö� ������ ������
    	adView.setOnAdWillLoadListener(new OnAdWillLoadListener() {
    		@Override
    		public void OnAdWillLoad(String arg1) {
    			Log.i(LOGTAG, "���� �ҷ��ɴϴ�. : " + arg1);
    		}
    	});
    	
    	// ���� �ݾ����� ������ ������
	    adView.setOnAdClosedListener(new OnAdClosedListener() {
	    	@Override
	    	public void OnAdClosed() {
	    		Log.i(LOGTAG, "���� �ݾҽ��ϴ�.");
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
