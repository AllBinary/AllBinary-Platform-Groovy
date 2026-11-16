/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.transaction;

import org.allbinary.business.user.commerce.money.payment.gateway.transaction.TransactionResultInterface;
import org.allbinary.data.tables.BasicDataTableInterface;

@groovy.transform.CompileStatic
public interface TransactionResultEntityInterface extends BasicDataTableInterface {
    TransactionResultInterface getTransactionResultInterface(String orderNumber);

    void remove(String userName, String orderNumber);

    void add(String userName, String orderNumber, TransactionResultInterface resultInterface);

}


