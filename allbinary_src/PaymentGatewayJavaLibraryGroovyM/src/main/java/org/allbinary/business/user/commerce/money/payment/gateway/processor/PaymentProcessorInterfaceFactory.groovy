/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.processor;

import org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterface;
import org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterfaceRequestFactory;
import org.allbinary.business.user.commerce.money.payment.types.PaymentType;
import org.allbinary.business.user.commerce.money.payment.types.PaymentTypeUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringValidationUtil;
import org.allbinary.logic.visual.transform.info.TransformInfoInterface;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class PaymentProcessorInterfaceFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final PaymentProcessorInterfaceFactory instance = new PaymentProcessorInterfaceFactory();

    public static PaymentProcessorInterfaceFactory getInstance() {
        return PaymentProcessorInterfaceFactory.instance;
    }

    private PaymentProcessorInterfaceFactory() {
    }

    public synchronized PaymentProcessorInterface getInstance(TransformInfoInterface transformInfoInterface) throws Exception {
        try {
            PaymentTransactionInterface paymentTransactionInterface = PaymentTransactionInterfaceRequestFactory.getInstance().getInstance(transformInfoInterface);
            //PageContext pageContext = transformInfoInterface.getPageContext();
            String gatewayName = paymentTransactionInterface.getOrderHistory().getPaymentMethod();
            if (!StringValidationUtil.getInstance().isEmpty(gatewayName)) {
                //storeTransformInfoInterface
                PaymentType paymentType = PaymentTypeUtil.getInstance().get(gatewayName);
                PaymentProcessorInterfaceFactoryInterface paymentProcessorInterfaceFactoryInterface = paymentType.getPaymentProcessorInterfaceFactoryInterface();
                return ((PaymentProcessorInterface) paymentProcessorInterfaceFactoryInterface.getInstance(transformInfoInterface, paymentTransactionInterface));
            }
            throw new Exception('Error Getting PaymentProcessorInterface');
        } catch (Exception e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@PAYMENTERROR)) {
                final CommonStrings commonStrings = CommonStrings.getInstance();
                this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@GET_INSTANCE, e);
            }
            throw e;
        }
    }

}


