package com.example.misionservi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void settoken(String token) {
        prefs.edit().putString("token", token).commit();
    }

    public String gettoken() {
        String usename = prefs.getString("token","");
        return usename;
    }
}
