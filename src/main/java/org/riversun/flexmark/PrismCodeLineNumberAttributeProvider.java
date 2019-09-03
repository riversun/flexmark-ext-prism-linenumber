/*
 * Copyright (c) 2006-2019 Tom Misawa, riversun.org@gmail.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 * 
 */
package org.riversun.flexmark;

import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.html.AttributeProvider;
import com.vladsch.flexmark.html.AttributeProviderFactory;
import com.vladsch.flexmark.html.IndependentAttributeProviderFactory;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.Attributes;

/**
 * AttributeProvider of flexmark-java extension for prism syntax highlighter.
 * 
 * To Insert 'class="line-numbers"' attribute into code block.
 * 
 * 
 * @author Tom Misawa (riversun.org@gmail.com)
 *
 */
public class PrismCodeLineNumberAttributeProvider implements AttributeProvider {

  @Override
  public void setAttributes(final Node node, final AttributablePart part, final Attributes attributes) {

    if (node instanceof FencedCodeBlock && part == AttributablePart.NODE) {
      attributes.replaceValue("class", "line-numbers");
    }

    // if (node instanceof FencedCodeBlock &&
    // part.getName().equals("FENCED_CODE_CONTENT")) {
    // String attrValue = attributes.getValue("class");
    // attributes.replaceValue("class", "xxxxx");
    // }
  }

  static AttributeProviderFactory Factory() {
    return new IndependentAttributeProviderFactory() {

      @Override
      public AttributeProvider apply(LinkResolverContext context) {
        return new PrismCodeLineNumberAttributeProvider();
      }
    };
  }
}