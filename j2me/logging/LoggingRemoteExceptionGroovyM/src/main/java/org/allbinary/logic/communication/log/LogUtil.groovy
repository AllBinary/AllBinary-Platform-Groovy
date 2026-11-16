/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import java.io.IOException;
import org.apache.xmlrpc.XmlRpcException;
import org.allbinary.string.CommonSeps;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.canvas.SpecialMessageUtil;
import org.allbinary.string.CommonStrings;
import org.allbinary.time.TimeDelayHelper;
import org.allbinary.util.ABHashtable;

//ActualPlatform
@groovy.transform.CompileStatic
public class LogUtil {
    private static final LogUtil instance = new LogUtil();

    //ActualPlatform
    public static final LogUtil getInstance() {
        return LogUtil.instance;
    }

    //private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();
    private final String MESSAGE = 'message';

    private boolean isFirstException = true;

    private TimeDelayHelper timeDelayHelper = new TimeDelayHelper(200000);

    public AbeClientInformationInterface abeClientInformation;

    private LogUtil() {
    }

    private final StringMaker stringBuffer = new StringMaker();

    //ActualPlatform
    public void putL(Log log) {
        if (log == null) {
            return;
        }
        final String specialMessage = log.getSpecialMessage();
        final Object anyType = log.getObject();
        final String functionName = log.getFunctionName();
        final Object exception = log.getThrowable();
        this.put(specialMessage, anyType, functionName, exception);
    }

    //ActualPlatform
    public void putF(final String specialMessage, final Object anyType, final String functionName) {
    }

    //ActualPlatform
    public void putFS(final String specialMessage, final String className, final String functionName) {
    }

    //ActualPlatform
    public void put(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        if (exception != null) {
            //If XmlRpcException then don't try to log it
            if (exception.getClass().getName().compareTo(XmlRpcException.class.getName()) == 0) {
                return;
            }
            if (exception.getClass().getName().compareTo(IOException.class.getName()) == 0) {
                return;
            }
            if (this.isFirstException || this.timeDelayHelper.isTimeTNT()) {
                String className = CommonStrings.getInstance().@EMPTY;
                this.isFirstException = false;
                if (anyType != null && anyType.getClass().getName() != null) {
                    className = new String(anyType.getClass().getName());
                }
                final String message = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception);
                try {
                    System.out.println('Eeeek');
                    //System.out.println("message: " + message);
                    if (this.abeClientInformation == null) {
                        throw new RuntimeException();
                    }
                    final ABHashtable<Object, Object> hashtable = this.abeClientInformation.toHashtable();
                    this.stringBuffer.delete(0, this.stringBuffer.length());
                    this.stringBuffer.append(message);
                    this.stringBuffer.append(CommonSeps.getInstance().@SPACE);
                    this.stringBuffer.append(SpecialMessageUtil.getInstance().get());
                    hashtable.put(this.MESSAGE, this.stringBuffer.toString());
                    //System.out.println("Sending");
                    new XmlRpcRemoteLogClient(this.abeClientInformation).get(hashtable);
                } catch (Throwable e) {
                    //Hmmmm well you will never know
                    System.out.println('Exception');
                    e.printStackTrace();
                }
            }
        }
    }

}


