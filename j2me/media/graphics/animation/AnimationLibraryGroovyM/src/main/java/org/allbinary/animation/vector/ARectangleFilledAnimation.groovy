/* Generated Code Do Not Modify */
package org.allbinary.animation.vector;

import javax.microedition.lcdui.Graphics;
import org.allbinary.graphics.color.BasicColorFactory;

@groovy.transform.CompileStatic
public class ARectangleFilledAnimation extends RectangleFilledAnimation {
    public int x;

    public int y;

    public ARectangleFilledAnimation() {
        super(0, 0, BasicColorFactory.getInstance().@BLACK);
    }

    @Override
    public void nextFrame() {
    }

    @Override
    public void paintXY(final Graphics graphics, final int unusedX, final int unusedY) {
        super.paintXY(graphics, this.x, this.y);
    }

}


