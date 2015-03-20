# SmartFormatter

It is a Android library for format strings using a tag instead position. It can be used with `String.format(...)` to be more powerful.

## SmartTextView

You can just create your words or texts in `strings.xml`.

```xml
<resources>
  <string name="hello_world">Hello world!</string>
  <string name="my_project">Project!</string>
  <string name="text">This is my {hello_world} Sample {my_project}</string>
</resources>
```

Usin a SmartTextView in your layout xml:

```xml
<br.com.smart.formatter.SmartTextView
        android:id="@+id/txt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/text" />
```

And the result is:

![Screenshots](https://raw.githubusercontent.com/alexandreant/SmartFormatter/master/readme-assets/screenshot.png)
