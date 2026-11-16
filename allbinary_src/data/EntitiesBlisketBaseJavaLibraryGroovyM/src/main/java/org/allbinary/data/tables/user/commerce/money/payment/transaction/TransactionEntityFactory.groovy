/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.transaction;

import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class TransactionEntityFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final TransactionEntityFactory instance = new TransactionEntityFactory();

    /**      * @return the instance      */
    public static TransactionEntityFactory getInstance() {
        return TransactionEntityFactory.instance;
    }

    //privatec final String CLASSNAME = "org.allbinary.data.tables.transaction.TransactionEntity";
    private TransactionEntityFactory() {
    }

    public TransactionEntity getTransactionEntityInstance() {
        try {
            //return (TransactionEntityInterface) InterfaceCastProxy.newInstance(object);
            return new org.allbinary.data.tables.user.commerce.money.payment.transaction.TransactionEntity();
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@ENTITYFACTORYERROR)) {
                this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@GET_INSTANCE, e);
            }
            return null;
        }
    }

}


