package br.com.smart.formatter;

import android.content.Context;
import android.util.Log;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.smart.formatter.environment.DiskEnvironment;
import br.com.smart.formatter.environment.Environment;
import br.com.smart.formatter.environment.StringsXMLEnvironment;
import br.com.smart.formatter.environment.VolatileEnvironment;

/**
 * Created by alexandre on 08/03/15.
 */
public class SmartFormatter {

    private Context context;

    private CharSequence text;

    private final Map<String, Object> tags = new LinkedHashMap<String, Object>();

    private SmartFormatter(Context context) {
        this.context = context;
    }

    public static SmartFormatter getFormatter(Context context){
        return new SmartFormatter(context);
    }

    public SmartFormatter from(CharSequence text) {
        this.text = text;
        return this;
    }

    public SmartFormatter from(String text) {
        return from(text);
    }

    public SmartFormatter from(int resId) {
        return from(context.getString(resId));
    }

    public SmartFormatter with(String key, Object value) {
        if (value != null) {
            tags.put("\\{" + key + "\\}", value);
        }
        return this;
    }

    public String format() {
        String formatted = text.toString();
        for (Map.Entry<String, Object> tag : tags.entrySet()) {
            formatted = formatted.replaceAll(tag.getKey(), tag.getValue().toString());
        }
        return formatted;
    }

    private Set<String> getAllFormatTagsFromText() {

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

    private void setUpTags() {
        for (String tag : getAllFormatTagsFromText()) {
            with(tag, getTagValue(tag));
        }
    }

    private String getTagValue(String tag) {
        return getTagValue(tag, new VolatileEnvironment(), new DiskEnvironment(), new StringsXMLEnvironment());
    }

    private String getTagValue(String tag, Environment...envs) {

        String value = null;

        for (Environment env : envs){
            value = env.getTagValue(context, tag);
            if(value != null){
                return value;
            }
        }

        return value;
    }

}
