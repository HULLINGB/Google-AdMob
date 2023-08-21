package com.example.googleadmob;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

// Add the app ID to the AndroidManifest.xml file.
//<meta-data android:name="com.google.android.gms.ads.APPLICATION_ID" android:value="YOUR_APP_ID"/>

// Add the AdMob SDK to your app.
/**
 dependencies {
 implementation 'com.google.android.gms:play-services-ads:22.2.0'
 implementation 'com.google.android.gms:play-services-ads-lite:22.2.0'
 }
 **/
public class MainActivity extends Activity {
    String appId = "YOUR_APP_ID";
    String adUnitId = "YOUR_AD_UNIT_ID";
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Android Java code
        //Initialize the AdView object.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Create an AdView object
        adView = new AdView(this);

        // Set the ad size and ad unit ID for the AdView object
        //adView.setAdSize(AdSize.BANNER);
        //adView.setAdUnitId("YOUR_AD_UNIT_ID");
        //AdSize adSize = new AdSize(300, 50);
        adView.setId(Integer.parseInt(appId));
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });
    }
}