/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import org.allbinary.animation.AnimationBehavior;
import org.allbinary.graphics.font.FontDebugFactory;
import org.allbinary.logic.string.StringUtil;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class CustomTextAnimation extends TextAnimation implements TextInterface {
    protected final FontDebugFactory fontDebugFactory = FontDebugFactory.getInstance();

    protected final int fontSize;

    protected Font font;

    private String lastText = StringUtil.getInstance().@INIT_STRING;

    protected boolean hasChanged = true;

    public CustomTextAnimation(final String text, final int fontSize, final AnimationBehavior animationBehavior) {
        super(text, animationBehavior);
        this.fontSize = fontSize;
        this.font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, fontSize);
    }

    //    }
    @Override
    public void paintXY(final Graphics graphics, final int x, final int y) {
        this.myFontProcessor.process(graphics);
        final Font existingFont = graphics.getFont();
        this.fontDebugFactory.setFont(this.font, graphics);
        //super.paint(graphics, x + this.xtraWidth, y);
        super.paintXYNoUpdate(graphics, x, y);
        this.fontDebugFactory.setFont(existingFont, graphics);
    }

    @Override
    public void setScale(final float scaleX, final float scaleY) {
        if (scaleX != scaleY) {
            throw new RuntimeException();
        }
        //this.logUtil.putF(new StringMaker().append("setScale font: ").append((fontSize * scaleX)).append(" text: ").append(this.getText()).toString(), this, this.commonStrings.PROCESS);
        this.hasChanged = true;
        this.font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, ((int) (((float) (this.fontSize * scaleX)))));
    }

    //Needed for polyglot do not remove
    @Override
    public void setTextWithOnMeasure(final String text, final TextChangeListener textChangeListener) {
        super.setTextWithOnMeasure(text, textChangeListener);
    }

    @Override
    public void setText(final String text) {
        //this.logUtil.putF(new StringMaker().append(" text: ").append(text).toString(), this, this.commonStrings.PROCESS);        
        if (this.lastText !== text) {
            this.hasChanged = true;
            this.lastText = text;
            super.setText(text);
        }
    }

    @Override
    public String getText() {
        return this.lastText;
    }

    private int textWidth;

    @Override
    public int getWidth() {
        if (this.hasChanged) {
            this.textWidth = this.font.stringWidth(this.textArrayP[0]);
            this.hasChanged = false;
        }
        return this.textWidth;
    }

    @Override
    public int getFontHeight() {
        return this.font.getHeight();
    }

}


