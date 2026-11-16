/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map;

import org.allbinary.logic.communication.log.LogUtil;

@groovy.transform.CompileStatic
public class GeographicMapCellTypeFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final GeographicMapCellTypeFactory instance = new GeographicMapCellTypeFactory();

    public static GeographicMapCellTypeFactory getInstance() {
        return GeographicMapCellTypeFactory.instance;
    }

    //512 should be the max tileid
    private final GeographicMapCellType[] geographicMapCellTypeArray = new GeographicMapCellType[512];

    public GeographicMapCellType get(int type) {
        //        return geographicMapCellType;
        return this.geographicMapCellTypeArray[type];
    }

    public GeographicMapCellType[] getGeographicMapCellTypeArray() {
        return this.geographicMapCellTypeArray;
    }

    public int getStartType() {
        throw new RuntimeException();
    }

    public int getEndType() {
        throw new RuntimeException();
    }

    public int getEmptyType() {
        throw new RuntimeException();
    }

    public boolean isPath(GeographicMapCellType cellType) {
        throw new RuntimeException();
    }

}


