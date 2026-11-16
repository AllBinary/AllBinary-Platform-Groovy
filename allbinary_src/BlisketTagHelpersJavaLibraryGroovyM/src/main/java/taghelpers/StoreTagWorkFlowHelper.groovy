/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers;

import java.util.HashMap;
import javax.servlet.jsp.PageContext;
import admin.taghelpers.TagHelper;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.control.workflow.StoreTagWorkFlowFactory;
import org.allbinary.logic.control.workflow.StoreWorkFlowInterface;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory;

@groovy.transform.CompileStatic
public class StoreTagWorkFlowHelper extends TagHelper {
    //implements StoreWorkFlowInterface
    protected final LogUtil logUtil = LogUtil.getInstance();

    private final AbeClientInformationInterface abeClientInformation = ServiceClientInformationInterfaceFactory.getInstance();

    private StoreWorkFlowInterface storeWorkFlowInterface;

    public StoreTagWorkFlowHelper(HashMap hashMap, PageContext pageContext) throws Exception {
        /*       StoreFrontInterface storeFrontInterface =          StoreFrontFactory.getInstance(             new WeblisketSession(hashMap, pageContext).getStoreName());              viewName = storeFrontInterface.getName() + " " + viewName + " " + CustomizerTransformInfoData.NAME ;       hashMap.put(TransformInfoData.NAME, viewName);       */
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@TAGHELPER)) {
            this.logUtil.putF('Properties: ' + hashMap.toString(), this, 'StoreTagWorkFlowHelper()');
        }
        this.storeWorkFlowInterface = StoreTagWorkFlowFactory.getInstance().getInstance(this.abeClientInformation, hashMap, pageContext);
    }

    public Integer process() throws Exception {
        try {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@TAGHELPER)) {
                this.logUtil.putF('Process', this, this.commonStrings.@PROCESS);
            }
            return this.storeWorkFlowInterface.process();
        } catch (Exception e) {
            String error = 'Failed to process workflow: ';
            //else error += "Unknown";
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLTAGSERROR)) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, 'view()', e);
            }
            throw e;
        }
    }

}


