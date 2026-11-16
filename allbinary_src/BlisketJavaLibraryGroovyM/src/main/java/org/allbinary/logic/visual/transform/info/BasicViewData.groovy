/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info;


/**  *  * @author user  */
@groovy.transform.CompileStatic
public class BasicViewData {
    private static final BasicViewData instance = new BasicViewData();

    public static BasicViewData getInstance() {
        return BasicViewData.instance;
    }

    private BasicViewData() {
    }

    @groovy.transform.PackageScope final String GENERICDIR = 'generic/';

    @groovy.transform.PackageScope final String USERDIR = this.GENERICDIR + 'user/';

    @groovy.transform.PackageScope final String ADDRESSDIR = this.USERDIR + 'address/';

    @groovy.transform.PackageScope final String BILLINGADDRESSDIR = this.ADDRESSDIR + 'billing/';

    @groovy.transform.PackageScope final String SHIPPINGADDRESSDIR = this.ADDRESSDIR + 'shipping/';

    @groovy.transform.PackageScope final String COMMERCEDIR = this.USERDIR + 'commerce/';

    @groovy.transform.PackageScope final String INVENTORYDIR = this.COMMERCEDIR + 'inventory/';

    @groovy.transform.PackageScope final String BASKETDIR = this.INVENTORYDIR + 'basket/';

    @groovy.transform.PackageScope final String ITEMDIR = this.INVENTORYDIR + 'item/';

    @groovy.transform.PackageScope final String MONEYDIR = this.COMMERCEDIR + 'money/';

    @groovy.transform.PackageScope final String SHIPPINGDIR = this.COMMERCEDIR + 'shipping/';

    @groovy.transform.PackageScope final String ORDERDIR = this.INVENTORYDIR + 'order/';

    @groovy.transform.PackageScope final String ORDEREMAILDIR = this.ORDERDIR + 'email/';

    @groovy.transform.PackageScope final String ORDERHISTORYDIR = this.ORDERDIR + 'history/';

    @groovy.transform.PackageScope final String ORDERREVIEWDIR = this.ORDERDIR + 'review/';

    public final String PAYMENTDIR = this.MONEYDIR + 'payment/';

    @groovy.transform.PackageScope final String GENERATIONDIR = this.GENERICDIR + 'generation/';

    @groovy.transform.PackageScope final String PRODUCTSDIR = this.GENERICDIR + 'products/';

    //used as a place holder for future view
    public final String IGNOREXMLXSL = this.GENERICDIR + 'ignoreXmlView.xsl';

    //Dynamic Views
    public final String REVIEWORDERVIEWXSL = this.ORDERREVIEWDIR + 'reviewOrderView.xsl';

    public final String ORDERVIEWXSL = this.REVIEWORDERVIEWXSL;

    public final String INVENTORYXSL = this.INVENTORYDIR + 'inventory.xsl';

    public final String BASKETXSL = this.BASKETDIR + 'basket.xsl';

    public final String CHECKOUTBASKETXSL = this.BASKETDIR + 'staticBasket.xsl';

    public final String MINIBASKETXSL = this.BASKETDIR + 'miniBasket.xsl';

    public final String BILLINGADDRESSCHANGEFORMXSL = this.BILLINGADDRESSDIR + 'billingAddressChangeForm.xsl';

    public final String BILLINGADDRESSINPUTFORMXSL = this.BILLINGADDRESSDIR + 'billingAddressInputForm.xsl';

    public final String BILLINGADDRESSVIEWXSL = this.BILLINGADDRESSDIR + 'billingAddressView.xsl';

    public final String SHIPPINGADDRESSCHANGEFORMXSL = this.SHIPPINGADDRESSDIR + 'shippingAddressChangeForm.xsl';

    public final String SHIPPINGADDRESSINPUTFORMXSL = this.SHIPPINGADDRESSDIR + 'shippingAddressInputForm.xsl';

    public final String SHIPPINGADDRESSVIEWXSL = this.SHIPPINGADDRESSDIR + 'shippingAddressView.xsl';

    public final String NEWTAXADDRESSXSL = this.SHIPPINGADDRESSDIR + 'newTaxAddressView.xsl';

    public final String EDITTAXADDRESSXSL = this.SHIPPINGADDRESSDIR + 'editTaxAddressView.xsl';

    public final String SHIPPINGMETHODSXSL = this.SHIPPINGDIR + 'shippingMethods.xsl';

    public final String ORDERCUSTOMEREMAILVIEWXSL = this.ORDEREMAILDIR + 'orderCustomerEmailView.xsl';

    public final String ORDERMANAGEREMAILVIEWXSL = this.ORDEREMAILDIR + 'orderManagerEmailView.xsl';

    public final String EDITCUSTOMERXSL = this.USERDIR + 'editCustomerInputForm.xsl';

    public final String ORDERHISTORYXSL = this.ORDERHISTORYDIR + 'orderHistory.xsl';

    public final String PAYMENTVIEWXSL = this.PAYMENTDIR + 'paymentView.xsl';

    public final String SUMMARYXSL = this.ITEMDIR + 'summary/summary.xsl';

    public final String PAYMENTGATEWAYOPTIONSXSL = this.PAYMENTDIR + 'paymentGatewayOptions.xsl';

    public final String MAKEPAYMENTVIEWXSL = this.PAYMENTDIR + 'invoice/' + 'makePayment.xsl';

}


