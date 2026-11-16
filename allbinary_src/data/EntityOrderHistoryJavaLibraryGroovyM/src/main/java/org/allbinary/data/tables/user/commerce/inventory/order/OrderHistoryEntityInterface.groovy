/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.order;

import java.util.HashMap;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.business.context.modules.storefront.StoreFrontInterface;
import org.allbinary.business.user.commerce.inventory.order.Order;
import org.allbinary.business.user.commerce.inventory.order.OrderHistory;
import org.allbinary.data.tables.BasicDataTableInterface;

@groovy.transform.CompileStatic
public interface OrderHistoryEntityInterface extends BasicDataTableInterface {
    void insert(String userName, Order order);

    void setStatus(String orderId, String status);

    void setPaymentMethod(String orderId, String status);

    // public String getOrderForm(String orderId);
    BasicArrayList getStoreOrders(StoreFrontInterface storeFrontInterface) throws Exception;

    BasicArrayList getOrders(String userName) throws Exception;

    BasicArrayList getOrders(String status, String fromDate, String toDate) throws Exception;

    OrderHistory getOrder(String id) throws Exception;

    void update(HashMap whereHashMap, HashMap orderHashMap) throws Exception;

}


