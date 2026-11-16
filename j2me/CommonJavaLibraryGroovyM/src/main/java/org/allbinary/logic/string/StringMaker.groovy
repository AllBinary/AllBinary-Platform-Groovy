/* Generated Code Do Not Modify */
package org.allbinary.logic.string;

import jsinterop.annotations.JsType;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsConstructor;

@JsType
@groovy.transform.CompileStatic
public class StringMaker {
    //private final StringUtil stringUtil = StringUtil.getInstance();
    private char[] charArray;

    private int currentLength;

    @JsConstructor
    public StringMaker() {
        this.charArray = new char[20];
    }

    @JsMethod
    public StringMaker append(final String string) {
        final int stringLength = string.length();
        this.ensureCapacity(this.currentLength + stringLength);
        string.getChars(0, stringLength, this.charArray, this.currentLength);
        this.currentLength += stringLength;
        return this;
    }

    //    }
    @JsMethod
    public StringMaker appendchar(final char c) {
        this.ensureCapacity(this.currentLength + 1);
        this.charArray[this.currentLength++] = c;
        return this;
    }

    @JsMethod
    public StringMaker appendCharArray(final char[] charArray, final int start, final int end) {
        this.ensureCapacity(this.currentLength + (end - start));
        for (int index = start; index < end; index++) {
            this.charArray[this.currentLength++] = charArray[index];
        }
        return this;
    }

    @JsMethod
    public StringMaker appendbyte(final byte b) {
        //change to PrimitiveLongUtil
        this.append(Integer.toString(b));
        return this;
    }

    @JsMethod
    public StringMaker appendshort(final short b) {
        //change to PrimitiveLongUtil
        this.append(Integer.toString(b));
        return this;
    }

    @JsMethod
    public StringMaker appendint(final int i) {
        //change to PrimitiveLongUtil
        this.append(Integer.toString(i));
        return this;
    }

    @JsMethod
    public StringMaker appendlong(final long l) {
        //change to PrimitiveLongUtil
        this.append(Long.toString(l));
        return this;
    }

    @JsMethod
    public StringMaker appendfloat(float f) {
        //change to PrimitiveLongUtil
        this.append(Float.toString(f));
        return this;
    }

    //    }
    @JsMethod
    public StringMaker appendboolean(final boolean bool) {
        if (bool) {
            this.ensureCapacity(this.currentLength + 4);
            this.charArray[this.currentLength++] = ('t' as char);
            this.charArray[this.currentLength++] = ('r' as char);
            this.charArray[this.currentLength++] = ('u' as char);
            this.charArray[this.currentLength++] = ('e' as char);
        } else {
            this.ensureCapacity(this.currentLength + 5);
            this.charArray[this.currentLength++] = ('f' as char);
            this.charArray[this.currentLength++] = ('a' as char);
            this.charArray[this.currentLength++] = ('l' as char);
            this.charArray[this.currentLength++] = ('s' as char);
            this.charArray[this.currentLength++] = ('e' as char);
        }
        return this;
    }

    @JsMethod
    public void ensureCapacity(final int minSize) {
        final int oldCapacity = this.charArray.length;
        if (minSize > oldCapacity) {
            int newCapacity = oldCapacity * 3;
            if (newCapacity < minSize) {
                newCapacity = minSize;
            }
            final char[] copy = new char[newCapacity];
            final int min = this.min(this.charArray.length, newCapacity);
            System.arraycopy(this.charArray, 0, copy, 0, min);
            this.charArray = copy;
        }
    }

    //mathUtil.min(this.charArray.length, newCapacity)
    @JsMethod
    public int min(int value, int value2) {
        return (value <= value2) ? value : value2;
    }

    @JsMethod
    public StringMaker delete(final int start, final int end) {
        this.currentLength -= (end - start);
        return this;
    }

    @JsMethod
    public int length() {
        return this.currentLength;
    }

    @JsMethod
    public String toString() {
        return new String(this.charArray, 0, this.currentLength);
    }

}


