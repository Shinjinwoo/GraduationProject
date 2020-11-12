package com.example.abptest;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtil {

    //프리퍼런스 KEY값
    public static final String PREFERENCE_NAME="preference_nm";
    private static PrefUtil preferencemodule = null;
    private static Context mContext;
    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;

    public static PrefUtil getInstance(Context context) {
        mContext = context;

        if (preferencemodule == null) {
            preferencemodule = new PrefUtil();
        }
        if(prefs==null){
            prefs = mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            editor = prefs.edit();
        }
        return preferencemodule;
    }

    public void putStringExtra(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringExtra(String key, String def) {
        return prefs.getString(key, def);
    }


}
