/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.LogFormatUtil;

//ActualPlatform
@groovy.transform.CompileStatic
public class PreLogUtil {
    //ActualPlatform
    public PreLogUtil() {
    }

    //ActualPlatform
    public static void put(final String specialMessage, final Object anyType, final String functionName) {
        PreLogUtil.putOE(specialMessage, anyType, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    private static final String LABEL = 'org.allbinary';

    //ActualPlatform
    public static void putOE(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        String className = PreLogUtil.LABEL;
        String actualClassName = anyType.getClass().getName();
        if (actualClassName != null) {
            className = actualClassName;
        }
        final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
        //android.util.Log.i(className, LOG_SUCCESS + message);
        android.util.Log.i(PreLogUtil.LABEL, message);
    }

    //ActualPlatform
    public static void putS(final String specialMessage, final String className, final String functionName) {
        PreLogUtil.putSE(specialMessage, className, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    //ActualPlatform
    public static void putSE(final String specialMessage, final String className, final String functionName, final Object exception) {
        final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
        //android.util.Log.i(className, LOG_SUCCESS + message);
        android.util.Log.i(className, message);
    }

}


