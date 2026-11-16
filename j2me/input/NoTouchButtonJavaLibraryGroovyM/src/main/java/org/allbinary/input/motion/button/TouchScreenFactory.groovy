/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button;


@groovy.transform.CompileStatic
public class TouchScreenFactory {
    private static final TouchScreenFactory SINGLETON = new TouchScreenFactory();

    private boolean multiTouch;

    private boolean touch;

    private TouchScreenType touchScreenType = TouchScreenTypesFactory.getInstance().@NOTOUCH;

    private TouchScreenFactory() {
    }

    public static final TouchScreenFactory getInstance() {
        return TouchScreenFactory.SINGLETON;
    }

    /*     public void setMultiTouch(boolean multiTouch)     {         this.multiTouch = multiTouch;     }     */
    public boolean isMultiTouch() {
        return this.multiTouch;
    }

    public void setTouch(boolean touch) {
    }

    public boolean isTouch() {
        return this.touch;
    }

    public TouchScreenType getTouchScreenType() {
        return this.touchScreenType;
    }

}


