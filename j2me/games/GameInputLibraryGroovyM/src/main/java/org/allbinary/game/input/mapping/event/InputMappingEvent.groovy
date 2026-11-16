/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping.event;

import org.allbinary.game.input.mapping.InputToGameKeyMapping;
import org.allbinary.logic.util.event.AllBinaryEventObject;

@groovy.transform.CompileStatic
public class InputMappingEvent extends AllBinaryEventObject {
    private InputToGameKeyMapping inputToGameKeyMapping = InputToGameKeyMapping.getNullInstance();

    public InputMappingEvent(Object anyType) {
        super(anyType);
    }

    public void setInputToGameKeyMapping(InputToGameKeyMapping inputToGameKeyMapping) {
        this.inputToGameKeyMapping = inputToGameKeyMapping;
    }

    public InputToGameKeyMapping getInputToGameKeyMapping() {
        return this.inputToGameKeyMapping;
    }

}


