/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import javax.microedition.lcdui.Image;
import org.allbinary.graphics.Anchor;
import org.allbinary.graphics.color.BasicColor;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.string.CommonStrings;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class ImageModifierUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final ImageModifierUtil instance = new ImageModifierUtil();

    /**      * @return the instance      */
    public static ImageModifierUtil getInstanceOrCreate() {
        return ImageModifierUtil.instance;
    }

    private final ImageUtil imageUtil = ImageUtil.getInstance();

    public void setBasicColorP(final BasicColor basicColor) {
    }

    //private final int[] alphaArray = new int[MAX_WIDTH * MAX_HEIGHT];
    private final int[] colorArray = new int[1];

    public void setColor(final Image unusedOriginalImage, final Image image, final int imageIndex, final BasicColor basicColor) {
        final BufferedImage newBufferedImage = this.imageUtil.getBufferedImage(image);
        //java.awt.Image newBufferedImage;
        final short r = basicColor.@red;
        final short g = basicColor.@green;
        final short b = basicColor.@blue;
        final int width = image.getWidth();
        final int height = image.getHeight();
        ColorModel colorModel;
        Object dataElements;
        int ax;
        int rx;
        int gx;
        int bx;
        for (int index = 0; index < width; index++) {
            for (int index2 = 0; index2 < height; index2++) {
                colorModel = newBufferedImage.getColorModel();
                dataElements = newBufferedImage.getRaster().getDataElements(index, index2, null);
                ax = colorModel.getAlpha(dataElements);
                rx = colorModel.getRed(dataElements);
                gx = colorModel.getGreen(dataElements);
                bx = colorModel.getBlue(dataElements);
                if (rx != 0 || gx != 0 || bx != 0) {
                    newBufferedImage.setRGB(index, index2, (ax << 24) | (r << 16) | (g << 8) | (b));
                }
            }
        }
    }

    public void changeColor(final Image unusedOriginalImage, final Image image, final int imageIndex, final BasicColor basicColor) {
        final BufferedImage newBufferedImage = this.imageUtil.getBufferedImage(image);
        //java.awt.Image newBufferedImage;
        final float MAX = 255;
        final float r = ((float) ((((float) basicColor.@red)) / MAX));
        final float g = ((float) ((((float) basicColor.@green)) / MAX));
        final float b = ((float) ((((float) basicColor.@blue)) / MAX));
        final int width = image.getWidth();
        final int height = image.getHeight();
        ColorModel colorModel;
        Object dataElements;
        int ax;
        int rx;
        int gx;
        int bx;
        for (int index = 0; index < width; index++) {
            for (int index2 = 0; index2 < height; index2++) {
                colorModel = newBufferedImage.getColorModel();
                dataElements = newBufferedImage.getRaster().getDataElements(index, index2, null);
                ax = colorModel.getAlpha(dataElements);
                rx = colorModel.getRed(dataElements);
                gx = colorModel.getGreen(dataElements);
                bx = colorModel.getBlue(dataElements);
                //ax *= a;
                rx = ((int) (((float) (rx * r))));
                gx = ((int) (((float) (gx * g))));
                bx = ((int) (((float) (bx * b))));
                newBufferedImage.setRGB(index, index2, (ax << 24) | (rx << 16) | (gx << 8) | (bx));
            }
        }
    }

    public void setAlpha(final Image unusedOriginalImage, final Image image, final int imageIndex, final int alphaInt) {
        byte alpha = ((byte) alphaInt);
        final BufferedImage newBufferedImage = this.imageUtil.getBufferedImage(image);
        //java.awt.Image newBufferedImage;
        final int width = image.getWidth();
        final int height = image.getHeight();
        final WritableRaster raster = newBufferedImage.getAlphaRaster();
        //raster.getPixels(0, 0, width, height, alphaArray);
        for (int index = 0; index < width; index++) {
            for (int index2 = 0; index2 < height; index2++) {
                raster.getPixel(index, index2, this.colorArray);
                this.colorArray[0] = alpha & this.colorArray[0];
                raster.setPixel(index, index2, this.colorArray);
            }
        }
    }

    public Image[] getImageArray(final Image[] originalImageArray) {
        //return originalImageArray;
        try {
            final Image[] newImageArray = new Image[originalImageArray.length];
            final int size = newImageArray.length;
            Image originalImage;
            for (int index = 0; index < size; index++) {
                originalImage = originalImageArray[index];
                final Image image = ImageCreationUtil.getInstance().createImageWH(originalImage.getWidth(), originalImage.getHeight());
                image.getGraphics().drawImage(originalImage, 0, 0, Anchor.TOP_LEFT);
                newImageArray[index] = image;
            }
            return newImageArray;
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            PreLogUtil.putOE(commonStrings.@EXCEPTION, this, 'getImageArray', e);
            return originalImageArray;
        }
    }

    public void handleImage(final Image[] imageArray, final int index, final Image image) {
    }

    public void reset() {
    }

}


