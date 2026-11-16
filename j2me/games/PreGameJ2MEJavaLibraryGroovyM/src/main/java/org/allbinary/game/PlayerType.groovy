/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game;

import org.allbinary.logic.string.StringUtil;

@groovy.transform.CompileStatic
public class PlayerType {
    private int id;

    private String name = StringUtil.getInstance().@EMPTY_STRING;

    PlayerType(final String name, final int value) {
        this.name = name;
        this.id = value;
    }

    //    }
    public int getId() {
        return this.id;
    }

    //    }
    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.getName();
    }

}


