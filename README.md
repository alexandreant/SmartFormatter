# SmartFormatter

It's an Android library to format strings using a tag instead position. It can be used with `String.format(...)` to be more powerful.

## Using SmartFormatter

You can use the formatter when you want:

```xml
<resources>
  <string name="text">This is my {hello_world} Sample {my_project}</string>
</resources>
```

```java
TextView txt = (TextView) findViewById(R.id.txt);

String str = SmartFormatter.getFormatter(mContext)
                .from(getString(R.string.text))
                .with("hello_world","Hello world!")
                .with("my_project","Project!")
                .format()

txt.setText(str);
```

## Using SmartTextView

You can just create your words or texts in `strings.xml`.

```xml
<resources>
  <string name="hello_world">Hello world!</string>
  <string name="my_project">Project!</string>
  <string name="text">This is my {hello_world} Sample {my_project}</string>
</resources>
```

Using a SmartTextView in your layout xml:

```xml
<br.com.smart.formatter.SmartTextView
        android:id="@+id/txt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/text" />
```

And the result is:

![Screenshots](https://raw.githubusercontent.com/alexandreant/SmartFormatter/master/readme-assets/screenshot.png)
