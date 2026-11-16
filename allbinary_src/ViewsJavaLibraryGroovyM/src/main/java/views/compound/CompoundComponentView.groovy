/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.compound;

import org.allbinary.data.tree.dom.document.XmlDocumentHelper;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.visual.transform.info.TransformInfoInterface;
import views.business.context.modules.storefront.HttpStoreComponentView;

@groovy.transform.CompileStatic
public class CompoundComponentView extends HttpStoreComponentView {
    protected final LogUtil logUtil = LogUtil.getInstance();

    public CompoundComponentView(TransformInfoInterface transformInfoInterface) throws Exception {
        super(transformInfoInterface);
    }

    //Override view for Compound View
    public String view() throws Exception {
        try {
            String success = XmlDocumentHelper.toString(this.getDoc());
            String result = new CompoundTransform(this.getTransformInfoInterface()).translate(success);
            return result;
        } catch (Exception e) {
            //String error = "Failed To View Store Template Compound Component";
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@TAGHELPERERROR)) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, 'view()', e);
            }
            throw e;
        }
    }

}


