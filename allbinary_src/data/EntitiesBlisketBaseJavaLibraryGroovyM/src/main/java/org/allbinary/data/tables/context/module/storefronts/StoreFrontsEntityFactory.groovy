/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.context.module.storefronts;

import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class StoreFrontsEntityFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final StoreFrontsEntityFactory instance = new StoreFrontsEntityFactory();

    /**      * @return the instance      */
    public static StoreFrontsEntityFactory getInstance() {
        return StoreFrontsEntityFactory.instance;
    }

    //private final String CLASSNAME = "org.allbinary.data.tables.StoreFrontsEntity";
    private StoreFrontsEntityFactory() {
    }

    public StoreFrontsEntity getStoreFrontsEntityInstance() {
        try {
            //return (StoreFrontsEntityInterface) InterfaceCastProxy.newInstance(object);
            return new org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntity();
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@ENTITYFACTORYERROR)) {
                this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@GET_INSTANCE, e);
            }
            return null;
        }
    }

}


