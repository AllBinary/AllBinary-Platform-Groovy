/* * AllBinary Open License Version 1 * Copyright (c) 2026 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas;

import org.allbinary.canvas.Processor;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class InitGameProcessor extends Processor {
    private AllBinaryGameCanvas gameCanvas;

    public InitGameProcessor(AllBinaryGameCanvas gameCanvas) {
        this.gameCanvas = gameCanvas;
    }

    @Override
    public void process() throws Exception {
        //logUtil.putF("ProgressCanvasFactory.getInstance().isInGame(): " + ProgressCanvasFactory.getInstance().isInGame(), this, CommonStrings.getInstance().PROCESS);
        if (ProgressCanvasFactory.getInstance().isInGame()) {
            this.gameCanvas.setProcessGameProcessorInit();
        }
    }

}


