/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding;

import org.allbinary.media.graphics.geography.map.BasicGeographicMap;
import org.allbinary.media.graphics.geography.map.GeographicMapCellPosition;

@groovy.transform.CompileStatic
public class PathFindingNodeCostInfoFactory extends PathFindingNodeCostInfoFactoryBase {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final PathFindingNodeCostInfo[][] pathFindingNodeCostInfoAdjacencyList;

    public PathFindingNodeCostInfoFactory(int max) {
        this.pathFindingNodeCostInfoAdjacencyList = new PathFindingNodeCostInfo[max][max];
    }

    @Override
    public void create(final BasicGeographicMap geographicMapInterface, final GeographicMapCellPosition goingToGeographicMapCellPosition, final GeographicMapCellPosition geographicMapCellPosition, final long costFromStart, final long costToEnd) throws Exception {
        this.getInstance(goingToGeographicMapCellPosition, geographicMapCellPosition, costFromStart, costToEnd);
    }

    public PathFindingNodeCostInfo getInstance(final GeographicMapCellPosition goingToGeographicMapCellPosition, final GeographicMapCellPosition geographicMapCellPosition, final long costFromStart, final long costToEnd) throws Exception {
        PathFindingNodeCostInfo pathFindingNodeCostInfo = this.getInstance(goingToGeographicMapCellPosition, geographicMapCellPosition);
        if (pathFindingNodeCostInfo == null) {
            //PathFindingNodeCostInfo pathFindingNodeCostInfo =
            pathFindingNodeCostInfo = new PathFindingNodeCostInfo(costFromStart, costToEnd);
            pathFindingNodeCostInfo.setCalculatedTotalCost();
            this.pathFindingNodeCostInfoAdjacencyList[geographicMapCellPosition.getId()][goingToGeographicMapCellPosition.getId()] = pathFindingNodeCostInfo;
        } else {
            pathFindingNodeCostInfo.setCostFromStart(costFromStart);
            pathFindingNodeCostInfo.setCostToEnd(costToEnd);
            pathFindingNodeCostInfo.setCalculatedTotalCost();
        }
        return pathFindingNodeCostInfo;
    }

    public PathFindingNodeCostInfo getInstance(final GeographicMapCellPosition goingToFromGeographicMapCellPosition, final GeographicMapCellPosition geographicMapCellPosition) {
        //return pathFindingNodeCostInfo;
        return this.pathFindingNodeCostInfoAdjacencyList[geographicMapCellPosition.getId()][goingToFromGeographicMapCellPosition.getId()];
    }

    @Override
    public long getTotalCost(final BasicGeographicMap geographicMapInterface, final GeographicMapCellPosition comingFromGeographicMapCellPosition, final GeographicMapCellPosition geographicMapCellPosition) {
        return this.getInstance(comingFromGeographicMapCellPosition, geographicMapCellPosition).@totalCostP;
    }

}


