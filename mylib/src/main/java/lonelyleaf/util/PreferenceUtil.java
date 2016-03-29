package rock.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 主要用于获得一些全局变量
 * Created by Rock on 2015/1/11.
 */
class PreferenceUtil {
    private PreferenceUtil() {
    }

    private static Context mContext;
    private static final String NAME = "GMT-Logistics";//Preference的name
    private static final int MODE = Context.MODE_PRIVATE;

    public static void inti(Context appContext) {
        mContext = appContext;
    }

    @SuppressLint("CommitPrefEdits")
    public static void clearSharedPreference() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, MODE);
    }

    @SuppressLint("CommitPrefEdits")
    public static void putString(String key, String value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, MODE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static String getString(String key) {
        String result = null;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, MODE);
        result = sharedPreferences.getString(key, "");
        return result;
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, MODE);
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key) {
        boolean result;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, MODE);
        result = sharedPreferences.getBoolean(key, false);
        return result;
    }

}
