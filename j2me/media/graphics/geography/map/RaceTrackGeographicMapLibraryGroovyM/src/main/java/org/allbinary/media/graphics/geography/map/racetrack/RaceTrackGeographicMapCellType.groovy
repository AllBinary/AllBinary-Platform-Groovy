/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack;

import org.allbinary.string.CommonStrings;
import org.allbinary.media.graphics.geography.map.GeographicMapCellType;

@groovy.transform.CompileStatic
public class RaceTrackGeographicMapCellType extends GeographicMapCellType {
    /*    public long northTravelCostBetweenArray[][] = {       //MAX        { max, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, 0, 0, max, max, max, 0, 0 },       { 0, 0, 0, max, max, max, 0, 0 },       { 0, max, max, max, max, max, max, max },       { 0, 0, 0, max, max, max, 0, 0 },       { 0, 0, 0, max, max, max, max, max }    };     public long southTravelCostBetweenArray[][] = {       { max, max, max, max, max, max, max, max },       { 0, max, max, 0, 0, max, 0, 0 },       { 0, max, max, 0, 0, max, 0, 0 },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, 0, 0, max, 0, 0 },       { 0, max, max, 0, 0, max, max, max }    };     public long eastTravelCostBetweenArray[][] = {       { max, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, 0, max, 0, max, 0, max, max },       { 0, max, max, max, max, max, max, max },       { 0, 0, max, 0, max, 0, max, max },       { 0, 0, max, 0, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max }    };     public long westTravelCostBetweenArray[][] = {       { max, max, max, max, max, max, max, max },       { 0, max, 0, max, 0, 0, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, 0, max, 0, 0, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, 0, max, 0, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max }    };       */
    public final String name;

    private final int travelCost;

    //   }
    public RaceTrackGeographicMapCellType(final String name, final int type, final int travelCost, final int reset) {
        super(type, reset);
        this.name = name;
        this.travelCost = travelCost;
    }

    //}
    public int getTravelCost() {
        return this.travelCost;
    }

}


