/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item.permissions;

import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class PermissionItemsEntityFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final PermissionItemsEntityFactory instance = new PermissionItemsEntityFactory();

    /**      * @return the instance      */
    public static PermissionItemsEntityFactory getInstance() {
        return PermissionItemsEntityFactory.instance;
    }

    //private final String CLASSNAME = "org.allbinary.data.tables.InventoryEntity";
    private PermissionItemsEntityFactory() {
    }

    public static PermissionItemsEntity getPermissionItemsEntityInstance() {
        final LogUtil logUtil = LogUtil.getInstance();
        try {
            //return (InventoryEntityInterface) InterfaceCastProxy.newInstance(object);
            return new org.allbinary.data.tables.user.commerce.inventory.item.permissions.PermissionItemsEntity();
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@ENTITYFACTORYERROR)) {
                logUtil.put(commonStrings.@EXCEPTION, 'PermissionItemsEntityFactory', commonStrings.@GET_INSTANCE, e);
            }
            return null;
        }
    }

}


