/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags;

import java.util.HashMap;
import admin.taghelpers.BasicGroupItemsHelperFactory;
import admin.taghelpers.BasicGroupItemsRequestHelperFactory;

@groovy.transform.CompileStatic
public class BasicGroupItemsTag extends TableTag {
    private HashMap propertiesHashMap;

    public BasicGroupItemsTag() {
        this.setTagHelperFactory(new BasicGroupItemsHelperFactory());
        this.setTagRequestHelperFactory(new BasicGroupItemsRequestHelperFactory());
    }

}


