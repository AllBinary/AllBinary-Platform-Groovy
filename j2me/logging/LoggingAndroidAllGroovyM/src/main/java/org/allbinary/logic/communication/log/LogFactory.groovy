/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.logic.NullUtil;
import org.allbinary.logic.string.StringUtil;

//ActualPlatform
@groovy.transform.CompileStatic
public class LogFactory {
    //ActualPlatform
    public static final Log getInstanceD() {
        final StringUtil stringUtil = StringUtil.getInstance();
        final NullUtil nullUtil = NullUtil.getInstance();
        return new Log(stringUtil.@EMPTY_STRING, nullUtil.@NULL_OBJECT, stringUtil.@EMPTY_STRING, nullUtil.@NULL_OBJECT);
    }

    //ActualPlatform
    public static final Log getInstanceNoF(String specialMessage, Object anyType, Object exception) {
        return new Log(specialMessage, anyType, StringUtil.getInstance().@EMPTY_STRING, exception);
    }

    //ActualPlatform
    public static final Log getInstance(String specialMessage, Object anyType, String functionName, Object exception) {
        return new Log(specialMessage, anyType, functionName, exception);
    }

    //ActualPlatform
    public static final Log getInstanceF(String specialMessage, Object anyType, String functionName) {
        return new Log(specialMessage, anyType, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

}


