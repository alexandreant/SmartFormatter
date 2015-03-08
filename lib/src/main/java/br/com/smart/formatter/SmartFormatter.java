package br.com.smart.formatter;

import android.content.Context;
import android.util.Log;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexandre on 08/03/15.
 */
public class SmartFormatter {

    public static CharSequence format(Context context, int textId) {
        return format(context, context.getString(textId));
    }

    public static CharSequence format(Context context, CharSequence text) {

        for (String tag : getAllFormatTags(text)) {

            Log.d("format", "tag na lista: " + tag);
            text = text.toString().replaceAll("\\{" + tag + "\\}", getTagValue(context, tag));
        }

        return text;
    }

    private static Set<String> getAllFormatTags(CharSequence text) {

        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(text);

        Set<String> matches = new HashSet<String>();

        while (matcher.find()) {
            String group = matcher.group().replaceAll("\\{", "").replaceAll("\\}", "");
            Log.d("matcher", "tag: " + group);
            matches.add(group);
        }

        return matches;
    }

    private static String getTagValue(Context context, String tag) {
        String value = null;
        int id = context.getResources().getIdentifier(tag, "string", context.getPackageName());
        if (id > 0) {
            value = context.getResources().getString(id);
        }

        Log.d("getTagValue", "tag: " + tag + " - value: " + value);
        return value;
    }
}
