/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow;

import java.lang.reflect.Method;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class WorkFlowWrapper implements WorkFlowInterface {
    protected final LogUtil logUtil = LogUtil.getInstance();

    protected final CommonStrings commonStrings = CommonStrings.getInstance();

    private Object anyType;

    public WorkFlowWrapper(Object anyType) {
        this.anyType = anyType;
    }

    protected Object getWorkFlowObject() {
        return this.anyType;
    }

    public String getName() throws Exception {
        try {
            Class helperClass = this.anyType.getClass();
            Method method = helperClass.getMethod('getName', null);
            String result = ((String) method.invoke(this.anyType, null));
            return result;
        } catch (Exception e) {
            String error = 'Reflection Exception';
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLTAGSERROR)) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, 'getName()', e);
            }
            throw new Exception(error);
        }
    }

    public String getStoreName() throws Exception {
        try {
            Class helperClass = this.anyType.getClass();
            Method method = helperClass.getMethod('getStoreName', null);
            String result = ((String) method.invoke(this.anyType, null));
            return result;
        } catch (Exception e) {
            String error = 'Reflection Exception';
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLTAGSERROR)) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, 'getStoreName()', e);
            }
            throw new Exception(error);
        }
    }

    public Integer process() throws Exception {
        try {
            Class helperClass = this.anyType.getClass();
            Method method = helperClass.getMethod(this.commonStrings.@PROCESS, null);
            Integer result = ((Integer) method.invoke(this.anyType, null));
            return result;
        } catch (Exception e) {
            String error = 'Reflection Exception';
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLTAGSERROR)) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.commonStrings.@PROCESS, e);
            }
            throw new Exception(error);
        }
    }

}


