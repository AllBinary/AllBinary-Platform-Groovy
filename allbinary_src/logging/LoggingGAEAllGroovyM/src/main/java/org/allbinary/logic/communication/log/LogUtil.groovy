/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.allbinary.logic.NullUtil;
import org.allbinary.string.CommonStrings;

//ActualPlatform
@groovy.transform.CompileStatic
public class LogUtil {
    private static final LogUtil instance = new LogUtil();

    //ActualPlatform
    public static final LogUtil getInstance() {
        return LogUtil.instance;
    }

    private final Logger logger = Logger.getLogger(LogUtil.class.getName());

    private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();

    /*    private final static String DEFAULT_PATH;     static    {        StringMaker stringBuffer = new StringMaker();         stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP);        stringBuffer.append(AbPathData.getInstance().SEPARATOR);        stringBuffer.append(LogData.ALLBINARY);        stringBuffer.append(LogData.extension);         LogUtil.DEFAULT_PATH = stringBuffer.toString();         LogUtil.init();    }      */
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
    public void putF(final String specialMessage, final Object anyType, final String functionName) {
        this.put(specialMessage, anyType, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    //ActualPlatform
    public void putFS(final String specialMessage, final String className, final String functionName) {
        this.putS(specialMessage, className, functionName, NullUtil.getInstance().@NULL_OBJECT);
    }

    //ActualPlatform
    public void put(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        try {
            String className = CommonStrings.getInstance().@EMPTY;
            final Class clazz = anyType.getClass();
            if (clazz.getName() != null) {
                className = clazz.getName();
            }
            final String message = this.logFormatUtil.getS(className, functionName, specialMessage);
            //className, functionName, specialMessage, exception);
            if (exception != null) {
                //logger.severe(message);
                this.logger.log(Level.SEVERE, message, exception);
            } else {
                //Change this back to warning when I get a stable version of gaefv without massive warnings
                this.logger.log(Level.INFO, message);
            }
        } catch (Exception e) {
        }
    }

    //ActualPlatform
    public void putS(final String specialMessage, final String className, final String functionName, final Object exception) {
        try {
            final String message = this.logFormatUtil.getS(className, functionName, specialMessage);
            //className, functionName, specialMessage, exception);
            if (exception != null) {
                //logger.severe(message);
                this.logger.log(Level.SEVERE, message, exception);
            } else {
                //Change this back to warning when I get a stable version of gaefv without massive warnings
                this.logger.log(Level.INFO, message);
            }
        } catch (Exception e) {
        }
    }

}


