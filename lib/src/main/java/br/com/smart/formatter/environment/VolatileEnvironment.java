package br.com.smart.formatter.environment;

import android.content.Context;

/**
 * Created by alexandre on 08/03/15.
 */
public class VolatileEnvironment implements Environment {

    @Override
    public String getTagValue(Context context, String tag) {
        if (VolatileRepository.getInstance().getValue(tag) == null) {
            return null;
        }
        return VolatileRepository.getInstance().getValue(tag).toString();
    }

    @Override
    public void saveTagValue(Context context, String tag, Object value) {
        VolatileRepository.getInstance().save(tag, value);
    }
}
