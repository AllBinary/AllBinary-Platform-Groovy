/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info;

import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.system.loader.AbeFactory;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.logic.system.security.licensing.LicensingException;
import org.allbinary.logic.visual.transform.TransformInterface;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class TransformInfoObjectFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final TransformInfoObjectFactory instance = new TransformInfoObjectFactory();

    public static TransformInfoObjectFactory getInstance() {
        return TransformInfoObjectFactory.instance;
    }

    private TransformInfoObjectFactory() {
    }

    public TransformInterface getInstance(final AbeClientInformationInterface abeClientInformation, final TransformInfoInterface transformInfoInterface) throws Exception {
        try {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@TAGHELPERFACTORY)) {
                final CommonStrings commonStrings = CommonStrings.getInstance();
                this.logUtil.putF('Creating View: ' + transformInfoInterface.getName(), this, commonStrings.@GET_INSTANCE);
            }
            //validate view data before creating view object
            Object[] params = new Object[1];
            Class[] classes = new Class[1];
            //TWB - Moved to obf on everything that is no bolted to dynamic loading
            classes[0] = TransformInfoInterface.class;
            //Add arguments
            params[0] = ((Object) transformInfoInterface);
            final TransformInterface anyType = ((TransformInterface) AbeFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface.getObjectFile(), classes, params));
            if (anyType == null) {
                if (transformInfoInterface != null) {
                    StringMaker stringBuffer = new StringMaker();
                    stringBuffer.append('\nNo Such View Name: ');
                    stringBuffer.append(transformInfoInterface.getName());
                    stringBuffer.append('\nNo Such View Object: ');
                    stringBuffer.append(transformInfoInterface.getObjectFile());
                    throw new Exception(stringBuffer.toString());
                } else {
                    throw new Exception('No Such View Object since transformInfo is null');
                }
            }
            return anyType;
        } catch (LicensingException e) {
            String error = 'Failed To Get Instance: ';
            if (transformInfoInterface != null) {
                error = error + transformInfoInterface.getName();
            }
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@TAGHELPERFACTORYERROR)) {
                final CommonStrings commonStrings = CommonStrings.getInstance();
                this.logUtil.put(error, this, commonStrings.@GET_INSTANCE, e);
            }
            throw e;
        } catch (Exception e) {
            String error = 'Failed To Get Instance: ';
            if (transformInfoInterface != null) {
                error = error + transformInfoInterface.getName();
            }
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@TAGHELPERFACTORYERROR)) {
                final CommonStrings commonStrings = CommonStrings.getInstance();
                this.logUtil.put(error, this, commonStrings.@GET_INSTANCE, e);
            }
            throw e;
        }
    }

}


