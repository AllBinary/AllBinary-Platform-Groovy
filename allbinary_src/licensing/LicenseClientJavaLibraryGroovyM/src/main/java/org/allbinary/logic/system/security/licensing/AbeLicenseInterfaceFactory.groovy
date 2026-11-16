/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing;

import java.io.IOException;
import java.util.Calendar;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.system.security.licensing.client.AbeLicenseClient;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class AbeLicenseInterfaceFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final AbeLicenseInterfaceFactory SINGLETON = new AbeLicenseInterfaceFactory();

    public static AbeLicenseInterfaceFactory getInstance() {
        return AbeLicenseInterfaceFactory.SINGLETON;
    }

    private final CommonStrings commonStrings = CommonStrings.getInstance();

    private long time = 0;

    //100000;
    private boolean check = false;

    //100000;
    private int checkPeriod = 36000000;

    private AbeLicenseInterface abeLicenseInterface = null;

    private AbeLicenseInterfaceFactory() {
    }

    public AbeLicenseInterface getLicenseInstance(final AbeClientInformationInterface abeClientInformation) throws LicensingException {
        if (isTimeToGetKey()) {
            return this.get(abeClientInformation);
        } else {
            return this.abeLicenseInterface;
        }
    }

    private AbeLicenseInterface get(final AbeClientInformationInterface abeClientInformation) throws LicensingException {
        try {
            //{
            this.logUtil.putF('Getting Keys', this, this.commonStrings.@GET);
            //}
            this.abeLicenseInterface = AbeNoLicense.getInstance();
            AbeLicenseClient licenseClient = new AbeLicenseClient();
            this.abeLicenseInterface = licenseClient.get(abeClientInformation);
            //{
            if (this.abeLicenseInterface != null) {
                this.logUtil.putF('Default Key: ' + this.abeLicenseInterface.getKey(AbeClientInformationData.getInstance().@KEY), this, this.commonStrings.@GET);
            }
            //}
            return this.abeLicenseInterface;
        } catch (IOException e) {
            //{
            this.logUtil.put('Licensing IO Error', this, this.commonStrings.@GET, e);
            //}
            throw new LicensingException('License Server Connection Error');
        } catch (Exception e) {
            //{
            this.logUtil.put('Licensing Failure', this, this.commonStrings.@GET, e);
            //}
            throw new LicensingException('Unknown License Failure: ' + this.getClass().getName());
        }
    }

    private boolean isTimeToGetKey() {
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis();
        if (this.abeLicenseInterface == null || this.abeLicenseInterface === AbeNoLicense.getInstance() || !this.abeLicenseInterface.hasKey() || isCheck() || currentTime - checkPeriod > time) {
            this.abeLicenseInterface = null;
            this.time = currentTime;
            return true;
        } else {
            return false;
        }
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    private boolean isCheck() {
        return this.check;
    }

}


