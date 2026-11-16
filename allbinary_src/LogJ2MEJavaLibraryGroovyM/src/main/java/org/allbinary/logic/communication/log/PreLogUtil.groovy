/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.logic.NullUtil;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.string.CommonStrings;

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

    private final static String LOG_SUCCESS = 'org.allbinary: ';

    //ActualPlatform
    public static void putOE(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        String className = CommonStrings.getInstance().@EMPTY;
        if (anyType.getClass().getName() != null) {
            className = new String(anyType.getClass().getName());
        }
        final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
        System.out.print(PreLogUtil.LOG_SUCCESS);
        System.out.println(message);
    }

    //ActualPlatform
    public static void putS(String specialMessage, String className, String functionName) {
        PreLogUtil.putSE(specialMessage, className, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    //ActualPlatform
    public static void putSE(final String specialMessage, final String className, final String functionName, final Object exception) {
        final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
        System.out.print(PreLogUtil.LOG_SUCCESS);
        System.out.println(message);
    }

    public static String getClassName(Object anyType) {
        return anyType.getClass().getName();
    }

}


