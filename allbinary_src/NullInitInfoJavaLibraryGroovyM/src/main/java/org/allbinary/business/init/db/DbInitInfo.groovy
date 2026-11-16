/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db;

import org.allbinary.logic.communication.log.PreLogUtil;

//import org.allbinary.logic.communication.log.config.type.LogConfigTypes;
@groovy.transform.CompileStatic
public class DbInitInfo extends DbConnectionInfo {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    public DbInitInfo(String initFileName, boolean read) {
        super();
    }

    public String getUrl() {
        String url = super.getUrl();
        //{
        PreLogUtil.put('Url: ' + url, this, 'getUrl');
        //}
        return url;
    }

    public synchronized void write() throws Exception {
    }

    private synchronized void load() throws Exception {
    }

    public synchronized void setHasRead(boolean value) {
    }

}


