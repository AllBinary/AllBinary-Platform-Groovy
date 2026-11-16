/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas;

import javax.microedition.lcdui.Graphics;
import org.allbinary.graphics.paint.InitUpdatePaintable;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class OverlayPaintable extends InitUpdatePaintable {
    protected final LogUtil logUtil = LogUtil.getInstance();

    //private final GameNotificationHud gameNotificationHud;
    public OverlayPaintable() throws Exception {
    }

    @Override
    public void update() {
        try {
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@UPDATE, e);
        }
    }

    @Override
    public void paint(Graphics graphics) {
    }

}


