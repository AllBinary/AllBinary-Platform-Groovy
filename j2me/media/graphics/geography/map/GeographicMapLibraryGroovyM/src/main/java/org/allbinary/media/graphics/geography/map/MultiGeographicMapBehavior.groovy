/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map;


/**  *  * @author User  */
@groovy.transform.CompileStatic
public class MultiGeographicMapBehavior {
    public GeographicMapCellType[] getCellTypeAt(final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellType[] geographicMapCellTypeArray, final GeographicMapCellPosition geographicMapCellPosition) throws Exception {
        final int size = geographicMapInterfaceArray.length;
        GeographicMapCellType cellType = GeographicMapCellType.NULL_GEOGRAPHIC_MAP_CELL_TYPE;
        for (int index = size; --index >= 0; ) {
            cellType = geographicMapInterfaceArray[index].getCellTypeAt(geographicMapCellPosition);
            geographicMapCellTypeArray[index] = cellType;
        }
        return geographicMapCellTypeArray;
    }

}


