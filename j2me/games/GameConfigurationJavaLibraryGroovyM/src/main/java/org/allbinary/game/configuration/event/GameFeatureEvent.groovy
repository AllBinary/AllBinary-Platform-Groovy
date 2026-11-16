/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.event;

import org.allbinary.logic.util.event.AllBinaryEventObject;

@groovy.transform.CompileStatic
public class GameFeatureEvent extends AllBinaryEventObject {
    private final String whatChanged;

    public GameFeatureEvent(Object anyType, String whatChanged) {
        super(anyType);
        this.whatChanged = whatChanged;
    }

    public String getWhatChanged() {
        return this.whatChanged;
    }

    public Object getGameOption() {
        return this.getSource();
    }

}


