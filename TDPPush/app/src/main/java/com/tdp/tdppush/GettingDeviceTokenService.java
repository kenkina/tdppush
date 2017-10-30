package com.tdp.tdppush;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tdp.tdppush.util.SharedPreferencesUtil;

/**
 * Created by kenkina on 29/10/2017.
 */

public class GettingDeviceTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("token ==> ", token);
        SharedPreferencesUtil.saveTokenToPrefs(getApplicationContext(), token);
    }


}
