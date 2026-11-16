/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion.api1;

import android.view.MotionEvent;
import org.allbinary.android.input.motion.BaseGameInputMotionEventProcessor;
import org.allbinary.input.motion.AllMotionRecognizer;
import org.allbinary.input.motion.MotionRecognizer;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.LogUtil;

@groovy.transform.CompileStatic
public class GameInputMotionEventProcessorAPI1 extends BaseGameInputMotionEventProcessor {
    private static Object instance = NullUtil.getInstance().@NULL_OBJECT;

    public static GameInputMotionEventProcessorAPI1 getInstance() {
        //PROCESSOR.setMidlet(midlet);
        if (GameInputMotionEventProcessorAPI1.instance === NullUtil.getInstance().@NULL_OBJECT) {
            GameInputMotionEventProcessorAPI1.instance = new GameInputMotionEventProcessorAPI1();
        }
        return ((GameInputMotionEventProcessorAPI1) GameInputMotionEventProcessorAPI1.instance);
    }

    protected final LogUtil logUtil = LogUtil.getInstance();

    private final MotionRecognizer motionRecognizer = new AllMotionRecognizer();

    private GameInputMotionEventProcessorAPI1() {
    }

    @Override
    public void process(final MotionEvent motionEvent) {
        try {
            //API 1 is not scalable so no need to waste processing on it.
            int x = ((int) motionEvent.getX());
            int y = ((int) motionEvent.getY());
            int action = motionEvent.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                this.motionRecognizer.processStartMotionEvent(x, y, motionEvent.getDeviceId(), 0);
            } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                this.motionRecognizer.processEndMotionEvent(x, y, motionEvent.getDeviceId(), 0);
            } else if (action == MotionEvent.ACTION_MOVE) {
                this.motionRecognizer.processDraggedMotionEvent(x, y, motionEvent.getDeviceId(), 0);
            }
        } catch (Exception e) {
            this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.commonStrings.@PROCESS, e);
        }
    }

}


