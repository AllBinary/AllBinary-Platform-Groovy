/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.draw;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import org.allbinary.AndroidUtil;
import org.allbinary.J2MEUtil;
import org.allbinary.graphics.Anchor;
import org.allbinary.graphics.opengles.OpenGLFeatureUtil;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.string.StringUtil;

/**  *  * @author user  */
@groovy.transform.CompileStatic
public class DrawStringUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final DrawStringUtil instance = new DrawStringUtil();

    public static DrawStringUtil getInstance() {
        return DrawStringUtil.instance;
    }

    private final String EMPTY_STRING = StringUtil.getInstance().@EMPTY_STRING;

    private int anchor = Anchor.TOP_LEFT;

    public void drawCenterString(final Graphics graphics, final String string, final int offset, int length, int x, int y) {
        final int width = (graphics.getFont().substringWidth(string, offset, length) >> 1);
        //width = (width * length) / string.length();
        try {
            graphics.drawSubstring(string, offset, length, x - width, y, this.anchor);
        } catch (Exception e) {
            PreLogUtil.put(new StringMaker().append('Exception: stringLength: ').appendint(string.length()).append(' offset: ').appendint(offset).append(' currentLength: ').appendint(length).toString(), this, 'drawCenterString');
        }
    }

    public void drawCenterStrings(final Graphics graphics, final String[] stringArray, final int maxWidth, final int charHeight, final int x, final int y) {
        int extraLines = 0;
        for (int index = 0; index < stringArray.length; index++) {
            String string = stringArray[index];
            if (string !== this.EMPTY_STRING) {
                int width = graphics.getFont().stringWidth(string);
                int minTotalLines = 1;
                if (width > maxWidth) {
                    minTotalLines = (Math.divideExact(width, maxWidth)) + 1;
                }
                int linePortion = Math.divideExact(string.length(), minTotalLines);
                int offset = 0;
                int currentLength = linePortion;
                //for (int lineIndex = 0; lineIndex < minTotalLines; lineIndex++)
                int size = string.length();
                while (offset < size) {
                    //|| lineIndex == minTotalLines - 1
                    if (offset + currentLength > size) {
                        currentLength = size - offset;
                    }
                    if (offset + currentLength != size) {
                        while (currentLength > 0 && stringArray[index].charAt(offset + currentLength) != (' ' as char)) {
                            currentLength--;
                        }
                        //If no spaces after tab size then stick with limit
                        if (currentLength <= 4) {
                            currentLength = linePortion;
                        }
                    }
                    //PreLogUtil.put("stringLength: ").append(string.length()).append(" offset: ").append(offset).append(" currentLength: ").append(currentLength, graphics, "drawCenterStrings");
                    this.drawCenterString(graphics, string, offset, currentLength, x, y + ((index + extraLines++) * charHeight));
                    offset = offset + currentLength;
                    currentLength = linePortion;
                }
                extraLines--;
            }
        }
    }

}


