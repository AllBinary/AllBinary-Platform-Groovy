/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.device;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.microemu.device.swt.SwtMutableImage;
import org.allbinary.AvianUtil;
import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.graphics.PointFactory;
import org.allbinary.graphics.Rectangle;
import org.allbinary.graphics.color.BasicColor;
import org.allbinary.graphics.color.BasicColorFactory;
import org.allbinary.graphics.displayable.CanvasStrings;
import org.allbinary.graphics.opengles.OpenGLCapabilities;
import org.allbinary.image.PreResourceImageUtil;
import org.allbinary.image.opengles.OpenGLESImage;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.string.CommonSeps;
import org.allbinary.string.CommonStrings;

//TTF
@groovy.transform.CompileStatic
public class TrueTypeFontUtil extends TrueTypeFontUtilBase {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final TrueTypeFontUtil instance = new TrueTypeFontUtil();

    public static TrueTypeFontUtil getInstance() {
        return TrueTypeFontUtil.instance;
    }

    private final PreResourceImageUtil preResourceImageUtil = PreResourceImageUtil.getInstance();

    private final float[] widthFloatArray;

    public OpenGLESImage fontImage = OpenGLESImage.NULL_OPENGL_IMAGE;

    private final float widthScale;

    private TrueTypeFontUtil() {
        super(2);
        if (AvianUtil.isAvian()) {
            this.widthFloatArray = new float[] {1504.0f, 967.0f, 527.0f, 961.0f, 957.0f, 1087.0f, 920.0f, 954.0f, 973.0f, 961.0f, 955.0f, 1296.0f, 1013.0f, 1106.0f, 1167.0f, 815.0f, 815.0f, 1216.0f, 1110.0f, 170.0f, 520.0f, 1056.0f, 815.0f, 1448.0f, 1142.0f, 1345.0f, 927.0f, 1345.0f, 1030.0f, 920.0f, 1096.0f, 1119.0f, 1219.0f, 1841.0f, 1166.0f, 1147.0f, 1005.0f, 879.0f, 965.0f, 792.0f, 964.0f, 927.0f, 753.0f, 1034.0f, 916.0f, 196.0f, 469.0f, 877.0f, 166.0f, 1563.0f, 916.0f, 1007.0f, 965.0f, 964.0f, 631.0f, 777.0f, 649.0f, 917.0f, 1026.0f, 1548.0f, 993.0f, 1028.0f, 795.0f, 241.0f, 798.0f, 241.0f, 905.0f, 1477.0f, 393.0f, 961.0f, 961.0f, 961.0f, 961.0f, 555.0f, 1029.0f, 1010.0f, 1378.0f, 952.0f, 952.0f, 952.0f, 952.0f, 463.0f, 463.0f, 926.0f, 961.0f, 491.0f, 930.0f, 457.0f, 457.0f, 644.0f, 643.0f, 326.0f, 186.0f, 1219.0f, 241.0f, 1599.0f, 961.0f, 302.0f, 711.0f, 961.0f, 961.0f, 710.0f, 141.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f};
        } else {
            this.widthFloatArray = new float[] {1504.0f, 967.0f, 527.0f, 961.0f, 957.0f, 1087.0f, 920.0f, 954.0f, 973.0f, 961.0f, 955.0f, 1296.0f, 1013.0f, 1106.0f, 1167.0f, 815.0f, 815.0f, 1216.0f, 1110.0f, 170.0f, 520.0f, 1056.0f, 815.0f, 1448.0f, 1142.0f, 1345.0f, 927.0f, 1345.0f, 1030.0f, 920.0f, 1096.0f, 1119.0f, 1219.0f, 1841.0f, 1166.0f, 1147.0f, 1005.0f, 879.0f, 965.0f, 792.0f, 964.0f, 927.0f, 753.0f, 1034.0f, 916.0f, 196.0f, 469.0f, 877.0f, 166.0f, 1563.0f, 916.0f, 1007.0f, 965.0f, 964.0f, 631.0f, 777.0f, 649.0f, 917.0f, 1026.0f, 1548.0f, 993.0f, 1028.0f, 795.0f, 241.0f, 798.0f, 241.0f, 905.0f, 1477.0f, 393.0f, 961.0f, 555.0f, 1029.0f, 1010.0f, 1378.0f, 952.0f, 463.0f, 463.0f, 926.0f, 961.0f, 491.0f, 930.0f, 457.0f, 457.0f, 644.0f, 643.0f, 326.0f, 186.0f, 1219.0f, 241.0f, 1599.0f, 961.0f, 302.0f, 711.0f, 961.0f, 961.0f, 710.0f, 141.0f, 1504.0f, 1504.0f};
        }
        this.widthScale = (this.scale == 2) ? 1.2f : 1f;
    }

    public Image getFontBitmapGL(final GL10 gl, final String filename, final int cellSize, final BasicColor basicColor) {
        try {
            if (this.fontImage === OpenGLESImage.NULL_OPENGL_IMAGE) {
                final CanvasStrings canvasStrings = CanvasStrings.getInstance();
                final OpenGLCapabilities openGLCapabilities = OpenGLCapabilities.getInstance();
                if (openGLCapabilities.isTextureSizeValid(1024) && this.scale == 2) {
                    final String FONT_ATLAS_1024 = '/font_1024.png';
                    final Image image = Image.createImage(ResourceUtil.getInstance().getResourceAsStream(FONT_ATLAS_1024));
                    image.setName(canvasStrings.@FONT_ATLAS);
                    this.fontImage = ((OpenGLESImage) this.preResourceImageUtil.encapsulate(image));
                } else if (openGLCapabilities.isTextureSizeValid(512)) {
                    final String FONT_ATLAS_512 = '/font_512.png';
                    final Image image = Image.createImage(ResourceUtil.getInstance().getResourceAsStream(FONT_ATLAS_512));
                    image.setName(canvasStrings.@FONT_ATLAS);
                    this.fontImage = ((OpenGLESImage) this.preResourceImageUtil.encapsulate(image));
                } else {
                    final String FONT_ATLAS_512 = '/font_512.png';
                    final Image image = Image.createImage(ResourceUtil.getInstance().getResourceAsStream(FONT_ATLAS_512));
                    image.setName(canvasStrings.@FONT_ATLAS);
                    this.fontImage = ((OpenGLESImage) this.preResourceImageUtil.encapsulate(image));
                }
                return this.fontImage;
            } else {
                return this.fontImage;
            }
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            PreLogUtil.putOE(commonStrings.@EXCEPTION, this, commonStrings.@EXCEPTION, e);
            throw new RuntimeException();
        }
    }

    //For SWT this just saves a copy of the existing font image.
    public void saveFontAtlasAsFile() {
        //this.logUtil.putF(commonStrings.START, this, "saveFontAtlasAsFile");
        final Image image = this.getFontBitmap(null, cellSize, BasicColorFactory.getInstance().@WHITE);
        final ImageLoader imageLoader = new ImageLoader();
        final ImageData imageData = (((SwtMutableImage) image)).@image.getImageData();
        imageData.@transparentPixel = imageData.getPixel(0, 0);
        imageLoader.@data = new ImageData[] {imageData};
        imageLoader.save(CommonSeps.getInstance().@PERIOD + CanvasStrings.getInstance().@FONT_ATLAS, SWT.IMAGE_PNG);
    }

    public Image getFontBitmap(final String filename, final int cellSize, final BasicColor basicColor) {
        //this.logUtil.putF(commonStrings.START, this, GET_FONT_BITMAP);
        final int cellsPerRow2 = this.CELLS_PER_ROW * 2;
        final int cellsPerRow3 = this.CELLS_PER_ROW * 3;
        final int cellsPerRow4 = this.CELLS_PER_ROW * 4;
        final int cellsPerRow5 = this.CELLS_PER_ROW * 5;
        final int cellsPerRow6 = this.CELLS_PER_ROW * 6;
        final int cellsPerRow7 = this.CELLS_PER_ROW * 7;
        //this.logUtil.putF("textureSize: " + textureSize, this, GET_FONT_BITMAP);
        final Image image = Image.createImage(textureSize, textureSize);
        final Graphics graphics = image.getGraphics();
        graphics.setColor(basicColor.intValue());
        //this.logUtil.putF("graphics: " + graphics, this, GET_FONT_BITMAP);
        int biggestHeight = 0;
        final Rectangle bounds = new Rectangle(PointFactory.getInstance().createXY(0, 0), cellSize, cellSize);
        int x;
        int y;
        for (int index = 0; index < size; index++) {
            //if(pattern.length() > index) {
            this.characterArray[0] = pattern.charAt(index);
            //paint.getTextBounds(characterArray, 0, 1, bounds);
            _characterWidth[index] = bounds.getMaxX();
            if (bounds.getMaxY() - bounds.getPoint().getX() > biggestHeight) {
                biggestHeight = bounds.getMaxY() - bounds.getPoint().getX();
            }
            x = (index % this.CELLS_PER_ROW) * cellSize;
            x += (cellSize >> 1);
            x -= (_characterWidth[index] >> 1);
            y = -(cellSize >> 1);
            if (index >= this.CELLS_PER_ROW) {
                y += cellSize;
            }
            if (index >= cellsPerRow2) {
                y += cellSize;
            }
            if (index >= cellsPerRow3) {
                y += cellSize;
            }
            if (index >= cellsPerRow4) {
                y += cellSize;
            }
            if (index >= cellsPerRow5) {
                y += cellSize;
            }
            if (index >= cellsPerRow6) {
                y += cellSize;
            }
            if (index >= cellsPerRow7) {
                y += cellSize;
            }
            y += cellSize;
            y -= (cellSize >> 2);
            //graphics.drawRect(x, y, bounds.getWidth(), bounds.getHeight());
            graphics.drawChar(this.characterArray[0], x, y, 0);
        }
        //this.saveFontAtlasAsFile();
        return image;
    }

    public int[] getFontWidths(String filename, int fontSize) {
        final CommonStrings commonStrings = CommonStrings.getInstance();
        //final Rectangle bounds = new Rectangle(PointFactory.getInstance().getInstance(0, 0), (this.cellSize / 10) * 4, this.cellSize);
        for (int index = 0; index < size; index++) {
            this.characterArray[0] = pattern.charAt(index);
            //            }
            if (this.characterArray[0] == (' ' as char)) {
                _characterWidth[index] = (Math.divideExact(fontSize, 4));
            } else {
                //this.logUtil.putF("character: " + characterArray[0], this, commonStrings.START);
                final int shortPatternIndex = this.shortPattern.indexOf(((int) this.characterArray[0]));
                //this.logUtil.putF("shortPatternIndex: " + shortPatternIndex, this, commonStrings.START);
                final int w = ((int) (((float) (this.widthFloatArray[shortPatternIndex] / 75)))) + 19;
                //                    .toString(), this, commonStrings.START);
                _characterWidth[index] = ((int) w);
                //if(characterArray[0] == 'E' || characterArray[0] == 'P') _characterWidth[index] += 5;
                if (this.characterArray[0] == ('.' as char) || this.characterArray[0] == ('1' as char)) {
                    _characterWidth[index] += 4;
                }
                if (this.characterArray[0] >= ('a' as char) && this.characterArray[0] < ('k' as char)) {
                    _characterWidth[index] -= 2;
                }
                if (this.characterArray[0] >= ('k' as char) && this.characterArray[0] < ('v' as char)) {
                    _characterWidth[index] -= 4;
                }
                if (this.characterArray[0] >= ('v' as char) && this.characterArray[0] < ('z' as char)) {
                    _characterWidth[index] -= 8;
                }
                if (this.characterArray[0] == ('D' as char)) {
                    _characterWidth[index] -= 4;
                }
                if (this.characterArray[0] >= ('A' as char) && this.characterArray[0] <= ('Z' as char)) {
                    _characterWidth[index] -= 2;
                }
            }
            _characterWidth[index] = ((int) (((float) (_characterWidth[index] * this.widthScale))));
        }
        return _characterWidth;
    }

}


