package br.com.smart.formatter.environment;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alexandre on 08/03/15.
 */
public class DiskEnvironment implements Environment {

    @Override
    public String getTagValue(Context context, String tag) {
        return getStringPreference(context, tag, null);
    }

    @Override
    public void saveTagValue(Context context, String tag, Object value) {
        savePreference(context, tag, value.toString());
    }

    public static String getStringPreference(Context context, String prefKey, String defaultValue) {
        return getSharedPreferences(context).getString(prefKey, defaultValue);
    }

    private static void savePreference(Context context, String prefKey, String newValue) {
        SharedPreferences mPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(prefKey, newValue);
        editor.commit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }
}
