/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os.android;

import android.content.Context;
import android.os.Build;
import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.string.CommonStrings;

/**  *  * @author Berthelot, Travis  * @version 1.0  */
@groovy.transform.CompileStatic
public class AndroidSystemProperties {
    //private static AndroidSystemProperties SINGLETON = null;
    private static final AndroidSystemProperties SINGLETON = new AndroidSystemProperties(ResourceUtil.getInstance().getContext());

    //private TelephonyManager telephonyManager;
    public static AndroidSystemProperties getInstance() {
        return AndroidSystemProperties.SINGLETON;
    }

    private final CommonStrings commonStrings = CommonStrings.getInstance();

    //private final String androidId;
    public AndroidSystemProperties(Context context) {
    }

    //IMEI
    public String getDeviceId() {
        return StringUtil.getInstance().@EMPTY_STRING;
    }

    public String getDeviceSoftwareVersion() {
        return this.commonStrings.@DISABLE;
    }

    public String getLine1Number() {
        return this.commonStrings.@DISABLE;
    }

    public String getNetworkCountryIso() {
        return this.commonStrings.@DISABLE;
    }

    public String getNetworkOperator() {
        return this.commonStrings.@DISABLE;
    }

    public String getNetworkOperatorName() {
        return this.commonStrings.@DISABLE;
    }

    public String getSimCountryIso() {
        return this.commonStrings.@DISABLE;
    }

    public String getSimOperator() {
        return this.commonStrings.@DISABLE;
    }

    public String getSimOperatorName() {
        return this.commonStrings.@DISABLE;
    }

    public String getSimSerialNumber() {
        return this.commonStrings.@DISABLE;
    }

    public String getSubscriberId() {
        return this.commonStrings.@DISABLE;
    }

    public String getVoiceMailAlphaTag() {
        return this.commonStrings.@DISABLE;
    }

    public String getVoiceMailNumber() {
        return this.commonStrings.@DISABLE;
    }

    public int getNetworkType() {
        return -1;
    }

    public int getPhoneType() {
        return -1;
    }

    //Build Properties
    public String getBoard() {
        return Build.BOARD;
    }

    public String getBrand() {
        return Build.BRAND;
    }

    /*     public String getCpuAbi()     {      return Build.CPU_ABI;     }     */
    public String getDevice() {
        return Build.DEVICE;
    }

    /*     public String getDisplay()     {      return Build.DISPLAY;     }     */
    public String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public String getHost() {
        return Build.HOST;
    }

    public String getId() {
        return Build.ID;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getProduct() {
        return Build.PRODUCT;
    }

    public String getTags() {
        return Build.TAGS;
    }

    public long getTime() {
        return Build.TIME;
    }

    public String getType() {
        return Build.TYPE;
    }

    public String getUser() {
        return Build.USER;
    }

}


