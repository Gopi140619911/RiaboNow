package com.example.riabonow.utils;


import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.File;


public class CacheSetUtil {
    static final String TAG = "AlixSet";
    public static final String FILE_NAME = "AppHall.cache";
    private Context mContext;
    private int mMode;
    @Nullable
    private static CacheSetUtil sRef = null;

    @NonNull
    public static synchronized CacheSetUtil getInstance() {
        return getInstance(AppInfo.getInstance().getApplication(), Context.MODE_PRIVATE);
    }

    @NonNull
    public static synchronized CacheSetUtil getInstance(@NonNull Context context) {
        return getInstance(context, Context.MODE_PRIVATE);
    }

    @NonNull
    public static synchronized CacheSetUtil getInstance(@NonNull Context context, int mode) {
        if (sRef == null) {
            sRef = new CacheSetUtil();
        }

        sRef.mContext = context.getApplicationContext();
        sRef.mMode = mode;
        return sRef;
    }

    private CacheSetUtil() {
    }

    @NonNull
    public String getString(@NonNull String key) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return null == sharedPref ? "" : sharedPref.getString(key, "");
    }

    @NonNull
    public String getString(@NonNull String key, String defValue) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return null == sharedPref ? "" : sharedPref.getString(key, defValue);
    }

    public void putString(@NonNull String key, String value) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        sharedPref.edit().putString(key, value).commit();
    }

    public boolean getBoolean(@NonNull String key, boolean defValue) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return null == sharedPref ? defValue : sharedPref.getBoolean(key, defValue);
    }

    public void putBoolean(@NonNull String key, boolean value) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        sharedPref.edit().putBoolean(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return null == sharedPref ? defValue : sharedPref.getLong(key, defValue);
    }

    public void putLong(@NonNull String key, long value) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        sharedPref.edit().putLong(key, value).commit();
    }

    public float getFloat(@NonNull String key, float defValue) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return null == sharedPref ? defValue : sharedPref.getFloat(key, defValue);
    }

    public void putFloat(String key, float value) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        sharedPref.edit().putFloat(key, value).commit();
    }

    public int getInt(@NonNull String key, int defValue) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return null == sharedPref ? defValue : sharedPref.getInt(key, defValue);
    }

    public void putInt(@NonNull String key, int value) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        sharedPref.edit().putInt(key, value).commit();
    }

    public void remove(@NonNull String key) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        sharedPref.edit().remove(key).commit();
    }

    public void clearPrefCache() {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        sharedPref.edit().clear().commit();
    }

    public void clearAppCache() {
        clearPrefCache();
        try {
            File cache = mContext.getCacheDir();
            File appDir = new File(cache.getParent());
            if (appDir.exists()) {
                String[] children = appDir.list();
                for (String s : children) {
                    if (s.equals("shared_prefs") || s.equals("files") || s.equals("cache")) {
                        deleteDir(new File(appDir, s));
                    } else if (s.equals("databases")) {
                        deleteDirDatabase(new File(appDir, s));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean contains(@NonNull String key) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        return sharedPref.contains(key);
    }

    public void putObject(String key, Object value) {
        SharedPreferences sharedPref = this.mContext.getSharedPreferences(FILE_NAME, mMode);
        Gson gson = new Gson();
        String json = gson.toJson(value);
        sharedPref.edit().putString(key, json).commit();
    }

    public static boolean deleteDir(File dir) {
        try {
            if (dir != null && dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    boolean success = deleteDir(new File(dir, children[i]));
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteDirDatabase(File dir) {
        try {
            if (dir != null && dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    boolean success = false;
                    if (children[i].equals("notifications")) {
                        success = deleteDir(new File(dir, children[i]));
                    }
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean dateAfter(String date, String cacheH5Date) {
        try {
            long configDate = Long.parseLong(date);
            long localConfigDate = Long.parseLong(cacheH5Date);
            if (configDate > localConfigDate) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

