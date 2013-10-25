/*
 * adlibr - Library for mobile AD mediation.
 * http://adlibr.com
 * Copyright (c) 2012 Mocoplex, Inc.  All rights reserved.
 * Licensed under the BSD open source license.
 */

/*
 * confirmed compatible with ad@m SDK 2.0.3
 */

package com.mobilead.adlib.ads;

import net.daum.adam.publisher.AdView.OnAdFailedListener;
import net.daum.adam.publisher.AdView.OnAdLoadedListener;
import net.daum.adam.publisher.impl.AdError;
import android.content.Context;
import android.util.AttributeSet;

import com.mocoplex.adlib.SubAdlibAdViewCore;

public class SubAdlibAdViewAdam extends SubAdlibAdViewCore  {
	
	protected net.daum.adam.publisher.AdView ad;
	protected boolean bGotAd = false;

	public SubAdlibAdViewAdam(Context context) {
		this(context,null);
	}	
	
	public SubAdlibAdViewAdam(Context context, AttributeSet attrs) {
		super(context, attrs);
				
		ad = new net.daum.adam.publisher.AdView(context);
		
		// ���⿡ ADAM ID �� �Է��ϼ���.
		String adamID = "102eZ2FT1327b365215";
		
		// �Ҵ� ���� clientId ����
		ad.setClientId(adamID);
		// ���� ���� �ð� : �⺻ 60��
		ad.setRequestInterval(12);		
		
		ad.setOnAdLoadedListener(new OnAdLoadedListener() {
			@Override
			public void OnAdLoaded() {
				bGotAd = true;
				gotAd();
			} });
		
		ad.setOnAdFailedListener(new OnAdFailedListener() {
			@Override
			public void OnAdFailed(AdError arg0, String arg1) {
				if(!bGotAd)
					failed();
			} });

		this.addView(ad);
	}
	
	// �����ٷ������� �ڵ����� ȣ��˴ϴ�.
	// ������ ���� �����ֱ� ���Ͽ� ��û�մϴ�.	
	public void query()
	{
		ad.resume();

		// ad@m ȭ�鿡 ���̴� ���¿��� ����� �޾ƿ� �� �ֽ��ϴ�.		
		this.gotAd();
	}
	
	// ����䰡 ������� ��� ȣ��˴ϴ�. 
	public void clearAdView()
	{
		if(ad != null)
		{
			ad.pause();
		}

		super.clearAdView();
	}
	
	public void onResume()
	{
		super.onResume();
		
		if(ad != null)
		{
			ad.resume();
		}
	}
	public void onPause()
	{
		super.onPause();
		
		if(ad != null)
		{
			ad.pause();
		}		
	}
	public void onDestroy()
	{
		super.onDestroy();
		
		if(ad != null)
		{
			ad.destroy();
			ad = null;
		}		
	}	
}
