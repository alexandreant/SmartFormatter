package br.com.smart.formatter.environment;

import android.content.Context;

/**
 * Created by alexandre on 08/03/15.
 */
public interface Environment {

    String getTagValue(Context context, String tag);

    void saveTagValue(Context context, String tag, Object value);
}
