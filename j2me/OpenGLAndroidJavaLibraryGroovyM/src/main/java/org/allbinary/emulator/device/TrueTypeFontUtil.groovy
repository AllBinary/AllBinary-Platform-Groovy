/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.device;

import java.io.File;
import java.io.FileOutputStream;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.lcdui.Image;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.graphics.color.BasicColor;
import org.allbinary.graphics.displayable.CanvasStrings;
import org.allbinary.image.PreResourceImageUtil;
import org.allbinary.image.opengles.OpenGLESImage;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.string.CommonStrings;
import org.microemu.android.device.AndroidImageInterface;
import org.microemu.android.device.AndroidImmutableImage;

//TTF
@groovy.transform.CompileStatic
public class TrueTypeFontUtil extends TrueTypeFontUtilBase {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final TrueTypeFontUtil instance = new TrueTypeFontUtil();

    public static TrueTypeFontUtil getInstance() {
        return TrueTypeFontUtil.instance;
    }

    protected final PreResourceImageUtil preResourceImageUtil = PreResourceImageUtil.getInstance();

    private final int realFontSize = 18;

    public OpenGLESImage fontImage = OpenGLESImage.NULL_OPENGL_IMAGE;

    private TrueTypeFontUtil() {
        super(1);
    }

    //This is only called from OpenGLES on Android via OpenGLESStrings
    public void saveFontAtlasAsFile() {
        try {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            final File file = ResourceUtil.getInstance().getContext().getFilesDir();
            final String path = String.valueOf(file.getAbsolutePath()) + CanvasStrings.getInstance().@FONT_ATLAS;
            this.logUtil.putF(path, this, commonStrings.@CONSTRUCTOR);
            final FileOutputStream fos = new FileOutputStream(path);
            final Bitmap bitmap = (((AndroidImageInterface) this.fontImage.@openGLBitmap.getImage())).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            PreLogUtil.putOE(commonStrings.@EXCEPTION, this, commonStrings.@EXCEPTION, e);
        }
    }

    public Image getFontBitmapGL(final GL10 gl, final String filename, final int cellSize, final BasicColor basicColor) {
        if (this.fontImage === OpenGLESImage.NULL_OPENGL_IMAGE) {
            final int cellsPerRow2 = this.CELLS_PER_ROW * 2;
            final int cellsPerRow3 = this.CELLS_PER_ROW * 3;
            final int cellsPerRow4 = this.CELLS_PER_ROW * 4;
            final int cellsPerRow5 = this.CELLS_PER_ROW * 5;
            final int cellsPerRow6 = this.CELLS_PER_ROW * 6;
            final int cellsPerRow7 = this.CELLS_PER_ROW * 7;
            final Typeface typeface = Typeface.DEFAULT;
            //Must make bitmap as texture for GL so it must be as a texture size.
            final int textureSize = this.getAsTextureSize(this.CELLS_PER_ROW * cellSize);
            final Bitmap bitmap = Bitmap.createBitmap(textureSize, textureSize, Bitmap.Config.ARGB_8888);
            // AndroidBitmapConfigUtil.get());
            final Canvas canvas = new Canvas(bitmap);
            final Paint paint = new Paint();
            paint.setTypeface(typeface);
            paint.setTextSize(((float) this.realFontSize));
            //(int) basicColor.blue);
            paint.setAlpha(((int) basicColor.@alpha));
            paint.setColor(basicColor.intValue());
            int biggestHeight = 0;
            final Rect bounds = new Rect();
            int x;
            int y;
            for (int index = 0; index < this.size; index++) {
                this.characterArray[0] = this.pattern.charAt(index);
                paint.getTextBounds(this.characterArray, 0, 1, bounds);
                this._characterWidth[index] = bounds.@right;
                if (bounds.@bottom - bounds.@top > biggestHeight) {
                    biggestHeight = bounds.@bottom - bounds.@top;
                }
                x = (index % this.CELLS_PER_ROW) * cellSize;
                x += (cellSize >> 1);
                x -= (this._characterWidth[index] >> 1);
                y = 0;
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
                canvas.drawText(this.characterArray, 0, 1, ((float) (((float) x) - 3)), ((float) (((float) y) - 6)), paint);
            }
            canvas.save();
            final Image image = AndroidImmutableImage.create(bitmap);
            //image.setName(FONT_ATLAS);
            this.fontImage = ((OpenGLESImage) this.preResourceImageUtil.encapsulate(image));
            return this.fontImage;
        } else {
            return this.fontImage;
        }
    }

    public int[] getFontWidths(final String filename, final int fontSize) {
        final Typeface typeface = Typeface.DEFAULT;
        //Typeface.createFromAsset(ResourceUtil.getInstance().getContext().getAssets(), filename);
        final Paint paint = new Paint();
        paint.setTypeface(typeface);
        paint.setTextSize(((float) fontSize));
        paint.setARGB(255, 255, 255, 255);
        final Rect bounds = new Rect();
        for (int index = 0; index < this.size; index++) {
            this.characterArray[0] = this.pattern.charAt(index);
            paint.getTextBounds(this.characterArray, 0, 1, bounds);
            if (index < this.lastCapIndex) {
                if (this.characterArray[0] == ('1' as char)) {
                    this._characterWidth[index] = bounds.@right + 3;
                } else if (this.characterArray[0] == ('J' as char) || this.characterArray[0] == ('V' as char) || this.characterArray[0] == ('2' as char) || this.characterArray[0] == ('9' as char) || this.characterArray[0] == ('I' as char) || this.characterArray[0] == ('N' as char) || this.characterArray[0] == ('U' as char)) {
                    this._characterWidth[index] = bounds.@right + 1;
                } else if (this.characterArray[0] == ('4' as char) || this.characterArray[0] == ('C' as char) || this.characterArray[0] == ('E' as char) || this.characterArray[0] == ('O' as char)) {
                    this._characterWidth[index] = bounds.@right - 2;
                } else if (this.characterArray[0] == ('B' as char) || this.characterArray[0] == ('D' as char) || this.characterArray[0] == ('G' as char) || this.characterArray[0] == ('H' as char) || this.characterArray[0] == ('T' as char) || this.characterArray[0] == ('W' as char)) {
                    this._characterWidth[index] = bounds.@right - 3;
                } else if (this.characterArray[0] == ('A' as char) || this.characterArray[0] == ('Q' as char) || this.characterArray[0] == ('R' as char)) {
                    this._characterWidth[index] = bounds.@right - 5;
                } else if (this.characterArray[0] == ('M' as char)) {
                    this._characterWidth[index] = bounds.@right - 6;
                } else if (this.characterArray[0] == ('m' as char)) {
                    this._characterWidth[index] = bounds.@right - 8;
                } else {
                    this._characterWidth[index] = bounds.@right;
                }
            } else {
                if (this.characterArray[0] == (' ' as char)) {
                    this._characterWidth[index] = bounds.@right + 10;
                } else if (this.characterArray[0] == ('l' as char) || this.characterArray[0] == ('i' as char) || this.characterArray[0] == ('j' as char) || this.characterArray[0] == ('.' as char) || this.characterArray[0] == ('!' as char) || this.characterArray[0] == ('|' as char)) {
                    this._characterWidth[index] = bounds.@right + 6;
                } else if (this.characterArray[0] == ('f' as char) || this.characterArray[0] == ('t' as char) || this.characterArray[0] == ('u' as char) || this.characterArray[0] == ('v' as char)) {
                    this._characterWidth[index] = bounds.@right + 1;
                } else if (this.characterArray[0] == ('r' as char)) {
                    this._characterWidth[index] = bounds.@right + 2;
                } else if (this.characterArray[0] == ('a' as char) || this.characterArray[0] == ('b' as char) || this.characterArray[0] == ('g' as char) || this.characterArray[0] == ('u' as char)) {
                    this._characterWidth[index] = bounds.@right - 1;
                } else if (this.characterArray[0] == ('o' as char) || this.characterArray[0] == ('e' as char)) {
                    this._characterWidth[index] = bounds.@right - 2;
                } else if (this.characterArray[0] == ('m' as char)) {
                    this._characterWidth[index] = bounds.@right - 7;
                } else {
                    this._characterWidth[index] = bounds.@right;
                }
            }
        }
        this._characterWidth[0] = (fontSize >> 1) - 2;
        return this._characterWidth;
    }

}


