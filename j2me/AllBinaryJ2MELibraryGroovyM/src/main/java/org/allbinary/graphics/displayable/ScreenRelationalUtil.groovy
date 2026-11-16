/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable;

import javax.microedition.lcdui.Image;

@groovy.transform.CompileStatic
public class ScreenRelationalUtil {
    private static final ScreenRelationalUtil instance = new ScreenRelationalUtil();

    public static ScreenRelationalUtil getInstance() {
        return ScreenRelationalUtil.instance;
    }

    public float getScaleImage(final Image image) {
        return this.getScaleWH(image.getWidth(), image.getHeight());
    }

    public float getScaleWH(final int aWidth, final int aHeight) {
        return this.getScaleWHA(aWidth, aHeight, 20);
    }

    public float getScaleWHA(final int aWidth, final int aHeight, final int add) {
        final DisplayInfoSingleton displayInfoSingleton = DisplayInfoSingleton.getInstance();
        final int[] last = displayInfoSingleton.getLast();
        final float width = ((float) last[displayInfoSingleton.@WIDTH]);
        final float height = ((float) last[displayInfoSingleton.@HEIGHT]);
        float largestSize = width;
        if (largestSize < height) {
            largestSize = height;
        }
        float scale = ((float) ((largestSize) / aWidth));
        /*          float scaleX = width/aWidth;          float scaleY = height/aHeight;          float scale = scaleX;                 if(scaleX < scaleY)          {          scale = scaleY;           }          */
        return scale;
    }

    public int getScaledHeight(final int aWidth, final int aHeight) {
        return ((int) (((float) (this.getScaleWH(aWidth, aHeight) * aHeight))));
    }

    public int getScaledHeightAdd(final int aWidth, final int aHeight, final int add) {
        return ((int) (((float) (this.getScaleWHA(aWidth, aHeight, add) * aHeight))));
    }

}


