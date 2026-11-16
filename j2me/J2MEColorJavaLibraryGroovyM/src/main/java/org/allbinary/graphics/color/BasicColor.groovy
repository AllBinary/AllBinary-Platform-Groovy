/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color;

import jsinterop.annotations.JsType;
import org.allbinary.logic.string.StringMaker;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;

@JsType
@groovy.transform.CompileStatic
public class BasicColor {
    // this.id = index++;
    private final String name;

    private final int value;

    private final float redComponent;

    private final float greenComponent;

    private final float blueComponent;

    private final float alphaComponent;

    @JsProperty
    public final short red;

    @JsProperty
    public final short green;

    @JsProperty
    public final short blue;

    @JsProperty
    public final short alpha;

    /*      * BasicColor.init(true, true);      *       * public static void setAlpha(boolean alpha) { BasicColor.alpha = alpha; }      *       * public static void init(boolean alpha, boolean ffOpaque) {      * BasicColor.setAlpha(alpha); BasicColor.ffOpaque = ffOpaque; }      */
    @JsConstructor
    BasicColor(final int alphaValue, final int value, final String name) {
        this.name = name;
        int tempValue;
        final BasicColorUtil basicColorUtil = BasicColorUtil.getInstance();
        if (basicColorUtil.@isAlpha) {
            if (basicColorUtil.@ffOpaque) {
                tempValue = alphaValue | value;
            } else {
                tempValue = 0x00000000 | value;
            }
        } else {
            tempValue = value;
        }
        int alphaInt = ((tempValue >> 24) & 255);
        this.alpha = ((short) alphaInt);
        this.alphaComponent = ((float) ((((float) alphaInt)) / 255));
        int redInt = ((tempValue >> 16) & 255);
        this.red = ((short) redInt);
        this.redComponent = ((float) ((((float) redInt)) / 255));
        int greenInt = ((tempValue >> 8) & 255);
        this.green = ((short) greenInt);
        this.greenComponent = ((float) ((((float) greenInt)) / 255));
        int blueInt = ((tempValue) & 255);
        this.blue = ((short) blueInt);
        this.blueComponent = ((float) ((((float) blueInt)) / 255));
        this.value = tempValue;
    }

    //    }
    @JsMethod
    public int intValue() {
        return this.value;
    }

    @JsMethod
    public int toInt() {
        return this.value;
    }

    @JsMethod
    public String toString() {
        StringMaker stringBuffer = new StringMaker();
        stringBuffer.append('BasicColor: ');
        stringBuffer.append('Alpha: ');
        stringBuffer.appendshort(this.alpha);
        stringBuffer.append(' Red: ');
        stringBuffer.appendshort(this.red);
        stringBuffer.append(' Green: ');
        stringBuffer.appendshort(this.green);
        stringBuffer.append(' Blue: ');
        stringBuffer.appendshort(this.blue);
        stringBuffer.append(' Value: ');
        stringBuffer.appendint(this.value);
        return stringBuffer.toString();
    }

    /**      * @return the name      */
    @JsMethod
    public String getName() {
        return this.name;
    }

    @JsMethod
    public float getRedComponent() {
        return this.redComponent;
    }

    @JsMethod
    public float getGreenComponent() {
        return this.greenComponent;
    }

    @JsMethod
    public float getBlueComponent() {
        return this.blueComponent;
    }

    @JsMethod
    public float getAlphaComponent() {
        return this.alphaComponent;
    }

}


