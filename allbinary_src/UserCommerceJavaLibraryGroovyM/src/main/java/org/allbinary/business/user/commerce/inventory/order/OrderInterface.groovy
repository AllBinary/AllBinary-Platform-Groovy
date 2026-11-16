/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order;

import org.allbinary.business.user.commerce.inventory.basket.BasketInterface;

@groovy.transform.CompileStatic
public interface OrderInterface {
    //public void setBasket(BasketInterface basket);
    void setShippingMethod(String shippingType);

    void setPaymentMethod(String value);

    void setSpecial(String special);

    void setStoreName(String value);

    void setUserComments(String value);

    void setUserCancelComments(String value);

    void setStoreComments(String value);

    void setStoreCancelComments(String value);

    BasketInterface getBasket();

    String getShippingMethod();

    String getPaymentMethod();

    String getSpecial();

    String getId();

    String getStoreName();

    String getUserComments();

    String getUserCancelComments();

    String getStoreComments();

    String getStoreCancelComments();

}


