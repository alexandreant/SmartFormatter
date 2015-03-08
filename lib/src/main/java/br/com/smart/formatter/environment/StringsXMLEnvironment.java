package br.com.smart.formatter.environment;

import android.content.Context;

/**
 * Created by alexandre on 08/03/15.
 */
public class StringsXMLEnvironment implements Environment {

    @Override
    public String getTagValue(Context context, String tag) {
        int id = context.getResources().getIdentifier(tag, "string", context.getPackageName());
        if (id <= 0) {
            return null;
        }
        return context.getResources().getString(id);
    }

    @Override
    public void saveTagValue(Context context, String tag, Object value) {
        throw new IllegalAccessError("Strings XML file is read only access!");
    }
}
