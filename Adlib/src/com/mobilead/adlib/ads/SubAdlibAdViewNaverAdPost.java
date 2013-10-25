/*
 * adlibr - Library for mobile AD mediation.
 * http://adlibr.com
 * Copyright (c) 2012 Mocoplex, Inc.  All rights reserved.
 * Licensed under the BSD open source license.
 */

/*
 * confirmed compatible with NaverAdPost SDK 1.0
 */

package com.mobilead.adlib.ads;

import android.content.Context;
import android.util.AttributeSet;

import com.mocoplex.adlib.SubAdlibAdViewCore;
import com.nbpcorp.mobilead.sdk.MobileAdListener;
import com.nbpcorp.mobilead.sdk.MobileAdView;


/*
AndroidManifest.xml �� �Ʒ� ������ �߰����ּ���.

<activity android:name="com.nbpcorp.mobilead.sdk.MobileAdBrowserActivity" />
*/

public class SubAdlibAdViewNaverAdPost extends SubAdlibAdViewCore  {
	
	protected MobileAdView ad;
	protected boolean bGotAd = false;
   	
	public SubAdlibAdViewNaverAdPost(Context context) {
		this(context,null);
	}	
	
	public SubAdlibAdViewNaverAdPost(Context context, AttributeSet attrs) {
		super(context, attrs);
	
		// ���⿡ ���̹����� �߱޹��� key �� �Է��ϼ���.
		String naverAdPostKey = "mandroid_81aa302e5d3b4943930c3541d45d9a65";		
		
		ad = new MobileAdView(context);
		ad.setChannelID(naverAdPostKey);
		ad.setTest(false);

		this.addView(ad);
		
		LayoutParams l = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
		ad.setLayoutParams(l);
		
		ad.setListener(new MobileAdListener() {

			@Override
			public void onReceive(int arg0) {
				
				if(arg0 == 0 || arg0 == 104 || arg0 == 101)
				{
					// ���� ���� ������ ��쳪, �˼����� ��츸 ȭ�鿡 ���Դϴ�.
					bGotAd = true;
					gotAd();
				}
				else
				{
					if(!bGotAd)
						failed();
				}
				
			}});
	}
	
	// �����ٷ������� �ڵ����� ȣ��˴ϴ�.
	// ������ ���� �����ֱ� ���Ͽ� ��û�մϴ�.	
	public void query()
	{
		ad.start();
		if(bGotAd)
			gotAd();
	}
	
	// ����䰡 ������� ��� ȣ��˴ϴ�. 
	public void clearAdView()
	{
		if(ad != null)
		{
			ad.stop();
		}

		super.clearAdView();
	}
	
	public void onResume()
	{
		super.onResume();
		
		if(ad != null)
		{
			ad.start();
		}
	}
	public void onPause()
	{
		super.onPause();
		
		if(ad != null)
		{
			ad.stop();
		}		
	}	
	public void onDestroy()
	{
		super.onDestroy();
		
		if(ad != null)
		{			
			ad.stop();
			ad.destroy();
			ad = null;
		}				
	}
}