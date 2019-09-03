# Overview

flexmark-java extension for prism syntax highlighter.

This extension will insert 'class="line-numbers"' attribute into fenced code block.

It is licensed under [MIT](https://opensource.org/licenses/MIT).

# How to use

## Maven


```xml
<dependency>
	<groupId>org.riversun</groupId>
	<artifactId>flexmark-ext-prism-linenumber</artifactId>
	<version>1.0.0</version>
</dependency>
```

## This library and flexmark-java 


**Input markdown**

````

**Hello**

```java

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

```

````


**Output markdown**

```
<p><strong>Hello</strong></p>
<pre class="line-numbers"><code class="language-java">

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( &quot;Hello World!&quot; );
    }
}

</code></pre>
```




## Example


```java

import java.io.IOException;
import java.util.Arrays;

import org.riversun.flexmark.PrismCodeLineNumberExtension;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.builder.Extension;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

/**
 * 
 * Example for flexmark-java extension for prism syntax highlighter linenumber
 * rendering
 *
 */
public class Example {

  public static void main(String[] args) throws IOException {

    String srcMarkdown = "**Hello**\n" +
        "\n" +
        "```java\n" +
        "\n" +
        "/**\n" +
        " * Hello world!\n" +
        " *\n" +
        " */\n" +
        "public class App \n" +
        "{\n" +
        "    public static void main( String[] args )\n" +
        "    {\n" +
        "        System.out.println( \"Hello World!\" );\n" +
        "    }\n" +
        "}\n" +
        "\n" +
        "```";

    MutableDataHolder options = new MutableDataSet();
    options.set(Parser.EXTENSIONS, Arrays.asList(new Extension[] {
        PrismCodeLineNumberExtension.create()

    }));

    Parser parser = Parser.builder(options).build();

    Node document = parser.parse(srcMarkdown);

    HtmlRenderer renderer = HtmlRenderer.builder(options).build();

    final String html = renderer.render(document);

    System.out.println(html);

  }
```  