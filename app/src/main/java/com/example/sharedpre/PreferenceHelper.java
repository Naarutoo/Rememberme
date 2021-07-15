package com.example.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static final String package_name = "saurabh.sharma";

    public static SharedPreferences preference(Context context){
        return context.getSharedPreferences(package_name,Context.MODE_PRIVATE);
    }
    public static void writeStringTopreference(Context context,String key,String value){
        SharedPreferences.Editor editor = preference(context).edit();
        editor.putString(key,value);
        editor.apply();

    }
    public static void writeBooleanTopreference(Context context,String key,boolean value){
        SharedPreferences.Editor editor = preference(context).edit();
        editor.putBoolean(key,value);
        editor.apply();

    }
    public static String getStringfromPrefernce(Context context,String key){
        return preference( context).getString(key,null);
    }
    public static boolean getBooleanfromPrefernce(Context context,String key){
        return preference(context).getBoolean(key,false);
    }

}
