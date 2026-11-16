/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.logic.NullUtil;
import org.allbinary.TsUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.string.CommonSeps;

//ActualPlatform
@groovy.transform.CompileStatic
public class LogUtil {
    private static final LogUtil instance = new LogUtil();

    //ActualPlatform
    public static final LogUtil getInstance() {
        return LogUtil.instance;
    }

    private final CommonSeps commonSeps = CommonSeps.getInstance();

    private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();

    private final String LABEL = 'org.allbinary';

    //private final String LOG_SUCCESS = "org.allbinary: ";
    private LogUtil() {
    }

    //ActualPlatform
    public void putL(final Log log) {
        final String specialMessage = log.getSpecialMessage();
        final Object anyType = log.getObject();
        final String functionName = log.getFunctionName();
        final Object exception = log.getThrowable();
        this.put(specialMessage, anyType, functionName, exception);
    }

    //ActualPlatform
    public void putF(final String specialMessage, final Object anyType, String functionName) {
        this.put(specialMessage, anyType, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    public void putFS(final String specialMessage, final String string, String functionName) {
        this.putS(specialMessage, string, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    //ActualPlatform
    public void put(final String specialMessage, final Object anyType, String functionName, Object exception) {
        String className = this.LABEL;
        /*       if(exception == null && specialMessage.indexOf(this.commonStrings.EXCEPTION) < 0)       {           return;       }          */
        className = new String(new StringMaker().append(anyType.getClass().getName()).append(this.commonSeps.@COLON).append(Integer.toHexString(TsUtil.getInstance().hashCode(anyType))).toString());
        final String message = this.logFormatUtil.get(className, functionName, specialMessage, exception);
        android.util.Log.i(this.LABEL, message);
    }

    //ActualPlatform
    public void putS(final String specialMessage, final String string, String functionName, Object exception) {
        String className = this.LABEL;
        /*       if(exception == null && specialMessage.indexOf(this.commonStrings.EXCEPTION) < 0)       {           return;       }          */
        className = new String(new StringMaker().append(string).append(this.commonSeps.@COLON).append(Integer.toHexString(TsUtil.getInstance().hashCode(string))).toString());
        final String message = this.logFormatUtil.get(className, functionName, specialMessage, exception);
        android.util.Log.i(this.LABEL, message);
    }

}


