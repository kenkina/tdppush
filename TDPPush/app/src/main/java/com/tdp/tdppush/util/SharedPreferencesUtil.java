package com.tdp.tdppush.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by kenkina on 29/10/2017.
 */

public class SharedPreferencesUtil {

    public static void saveTokenToPrefs(Context context, String token) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firebase_client_token", token);
        editor.apply();
    }

    public static String getTokenFromPrefs(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("firebase_client_token", null);
    }
}
