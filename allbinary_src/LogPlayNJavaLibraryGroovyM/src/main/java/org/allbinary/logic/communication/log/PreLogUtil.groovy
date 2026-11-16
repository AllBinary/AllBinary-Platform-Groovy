/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.string.CommonSeps;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.string.StringUtil;
import playn.core.PlayN;

//ActualPlatform
@groovy.transform.CompileStatic
public class PreLogUtil {
    //ActualPlatform
    public PreLogUtil() {
    }

    //ActualPlatform
    public static void put(final String specialMessage, final Object anyType, final String functionName) {
        //       String className = EMPTY;
        String className = PreLogUtil.getClassName(anyType);
        if (className == null) {
            className = CommonStrings.getInstance().@EMPTY;
        }
        className = new StringMaker().append(className).append(CommonSeps.getInstance().@FORWARD_SLASH).append(StringUtil.getInstance().toString(anyType)).toString();
        final String message = LogFormatUtil.getInstance().getS(className, functionName, specialMessage);
        PlayN.log().debug(PreLogUtil.LOG_SUCCESS + message);
    }

    private final static String LOG_SUCCESS = 'org.allbinary: ';

    //ActualPlatform
    public static void putOE(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        //       String className = EMPTY;
        String className = PreLogUtil.getClassName(anyType);
        if (className == null) {
            className = CommonStrings.getInstance().@EMPTY;
        }
        className = new StringMaker().append(className).append(CommonSeps.getInstance().@FORWARD_SLASH).append(StringUtil.getInstance().toString(anyType)).toString();
        final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
        PlayN.log().error(PreLogUtil.LOG_SUCCESS + message, ((Throwable) exception));
    }

    //ActualPlatform
    public static void putS(final String specialMessage, final String className, final String functionName) {
        final String message = LogFormatUtil.getInstance().getS(className, functionName, specialMessage);
        PlayN.log().debug(PreLogUtil.LOG_SUCCESS + message);
    }

    //ActualPlatform
    public static void putSE(final String specialMessage, final String className, final String functionName, final Object exception) {
        final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
        PlayN.log().error(PreLogUtil.LOG_SUCCESS + message, ((Throwable) exception));
    }

    //ActualPlatform
    public static native String getClassName(Object anyType);

}


