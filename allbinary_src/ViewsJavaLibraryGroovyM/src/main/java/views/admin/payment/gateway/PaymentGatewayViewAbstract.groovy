/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment.gateway;

import javax.servlet.http.HttpServletRequest;
import org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData;
import org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayPrimaryKey;
import org.allbinary.logic.visual.transform.info.TransformInfoHttpComposite;
import org.allbinary.logic.visual.transform.info.TransformInfoInterface;

@groovy.transform.CompileStatic
public class PaymentGatewayViewAbstract extends TransformInfoHttpComposite {
    private PaymentGatewayPrimaryKey paymentGatewayPrimaryKey;

    public PaymentGatewayViewAbstract(TransformInfoInterface transformInfoInterface) {
        super(transformInfoInterface);
        this.getFormData(((HttpServletRequest) this.getPageContext().getRequest()));
    }

    public void getFormData(HttpServletRequest request) {
        /*       this.storeName =       request.getParameter(       allbinary.business.context.modules.storefront.StoreFrontData.NAME);              if(this.storeName==null)       {        **/
        String storeName = this.getWeblisketSession().getStoreName();
        /*       }       else       {          this.weblisketSession.setStoreName(storeName);       }*/
        String gatewayName = request.getParameter(PaymentGatewayData.NAME.toString());
        //this.paymentGatewayInterface = new PaymentGateway(hashMap);
        this.setPaymentGatewayPrimaryKey(new PaymentGatewayPrimaryKey(storeName, gatewayName));
    }

    public PaymentGatewayPrimaryKey getPaymentGatewayPrimaryKey() {
        return this.paymentGatewayPrimaryKey;
    }

    public void setPaymentGatewayPrimaryKey(PaymentGatewayPrimaryKey paymentGatewayPrimaryKey) {
        this.paymentGatewayPrimaryKey = paymentGatewayPrimaryKey;
    }

}


