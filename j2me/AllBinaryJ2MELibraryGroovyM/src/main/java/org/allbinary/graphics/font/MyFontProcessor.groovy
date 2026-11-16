/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.font;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class MyFontProcessor {
    public static int defaultCharWidth(final Font font) {
        return font.charWidth(('C' as char));
    }

    public static int defaultStringWidth(final Font font, final int size) {
        return MyFontProcessor.defaultCharWidth(font) * size;
    }

    private static final MyFontProcessor instance = new MyFontProcessor();

    /**      * @return the instance      */
    public static MyFontProcessor getInstance() {
        return MyFontProcessor.instance;
    }

    public void process(final Graphics graphics) {
    }

}


