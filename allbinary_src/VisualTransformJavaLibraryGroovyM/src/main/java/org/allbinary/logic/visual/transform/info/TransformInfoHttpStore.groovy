/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info;

import java.util.HashMap;
import javax.servlet.jsp.PageContext;
import org.allbinary.business.context.modules.storefront.StoreFrontData;
import org.allbinary.business.context.modules.storefront.StoreFrontInterface;
import org.allbinary.globals.FREEBLISKET_PATH_GLOBALS;
import org.allbinary.globals.URLGLOBALS;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.io.path.AbPath;
import org.allbinary.logic.io.path.AbPathData;
import org.allbinary.logic.string.StringMaker;

@groovy.transform.CompileStatic
public class TransformInfoHttpStore extends TransformInfoHttp implements TransformInfoHttpStoreInterface {
    protected final LogUtil logUtil = LogUtil.getInstance();

    //TWB - for Inserting transforms into database
    public TransformInfoHttpStore(HashMap propertiesHashMap, PageContext pageContext) throws Exception {
        super(propertiesHashMap, pageContext, true);
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@VIEW)) {
            this.logUtil.putF('Properties HashMap: ' + propertiesHashMap.toString(), this, this.commonStrings.@CONSTRUCTOR);
        }
    }

    //in a special type of viewinfo
    public TransformInfoHttpStore(HashMap databaseHashMap, HashMap propertiesHashMap, PageContext pageContext) throws Exception {
        super(databaseHashMap, propertiesHashMap, pageContext);
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@VIEW)) {
            StringMaker stringBuffer = new StringMaker();
            stringBuffer.append('Database HashMap: ');
            stringBuffer.append(databaseHashMap.toString());
            stringBuffer.append('\nProperties HashMap: ');
            stringBuffer.append(propertiesHashMap.toString());
            this.logUtil.putF(stringBuffer.toString(), this, 'Constructor(HashMap, HashMap , PageContext)');
        }
        this.setStoreName(((String) databaseHashMap.get(StoreFrontData.getInstance().@NAME)));
    }

    public TransformInfoHttpStore(StoreFrontInterface storeFrontInterface, HashMap propertiesHashMap, PageContext pageContext) throws Exception {
        super(propertiesHashMap, pageContext);
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@VIEW)) {
            this.logUtil.putF('Properties HashMap: ' + propertiesHashMap.toString(), this, this.commonStrings.@CONSTRUCTOR);
        }
        this.setStoreName(storeFrontInterface.getName());
    }

    private String getPath() throws Exception {
        StringMaker stringBuffer = new StringMaker();
        stringBuffer.append(URLGLOBALS.getMainPath());
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().@XSLPATH);
        stringBuffer.append(this.getStoreName());
        stringBuffer.append(AbPathData.getInstance().@SEPARATOR);
        return stringBuffer.toString();
    }

    public AbPath getTemplateFilePath() throws Exception {
        return new AbPath(this.getPath(), this.getTemplateFile());
    }

    public AbPath getObjectConfigFilePath() throws Exception {
        return new AbPath(this.getPath(), this.getObjectConfigFile());
    }

    public AbPath getDataFilePath() throws Exception {
        return new AbPath(this.getPath(), this.getDataFile());
    }

    //Needed for polyglot do not remove
    @Override
    public void setStoreName(final String value) {
        super.setStoreName(value);
    }

    //Needed for polyglot do not remove
    @Override
    public String getStoreName() {
        return super.getStoreName();
    }

}


