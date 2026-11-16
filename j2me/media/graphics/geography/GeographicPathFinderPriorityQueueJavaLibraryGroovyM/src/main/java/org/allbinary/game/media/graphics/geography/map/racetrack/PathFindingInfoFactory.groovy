/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack;

import org.allbinary.game.layer.AllBinaryTiledLayer;
import org.allbinary.media.graphics.geography.map.BasicGeographicMap;
import org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory;
import org.allbinary.media.graphics.geography.map.GeographicMapCellPosition;
import org.allbinary.media.graphics.geography.map.racetrack.BasePathFindingInfoFactory;
import org.allbinary.media.graphics.geography.map.racetrack.RaceTrackRoadsGeographicMapCellHistoryFactory;
import org.allbinary.media.graphics.geography.pathfinding.PathFinder;
import org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo;
import org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactory;
import org.allbinary.util.BasicArrayListS;

//1.4.2
@groovy.transform.CompileStatic
public class PathFindingInfoFactory extends BasePathFindingInfoFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final PathFindingInfoFactory instance = new PathFindingInfoFactory();

    /**      * @return the instance      */
    public static PathFindingInfoFactory getInstance() {
        return PathFindingInfoFactory.instance;
    }

    private static int MAX = 32768;

    public static void initMax(int max) {
        PathFindingInfoFactory.MAX = max;
    }

    //private final int MAX_DIRECTIONS = 4;
    private final PathFindingInfo pathFindingInfo;

    private final PathFinder pathFinder;

    private PathFindingInfoFactory() {
        //PreLogUtil.put("Using Dynamic Path Finding", this, this.commonStrings.GET_INSTANCE);
        this.pathFindingInfo = new PathFindingInfo(new PathFindingNodeCostInfoFactory(PathFindingInfoFactory.MAX), new BasicArrayListS(1), new BasicArrayListS(1));
        this.pathFinder = new PathFinder();
    }

    @Override
    public PathFindingInfo getInstancePathFindingInfo(final BasicGeographicMap geographicMapInterface, final int[][] mapArray) throws Exception {
        //TWB - find a way to cache this PathFindingInfo.
        final PathFindingInfo pathFindingInfo = new PathFindingInfo(this.pathFindingInfo.getPathFindingNodeCostInfoFactoryInterface(), new BasicArrayListS(1), new BasicArrayListS(1));
        RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance().init();
        this.init(geographicMapInterface, pathFindingInfo, mapArray);
        this.pathFinder.init(geographicMapInterface);
        pathFindingInfo.setPathFinder(this.pathFinder);
        return pathFindingInfo;
    }

    // Set Appropriate Terrain and Map
    @Override
    public void init(final BasicGeographicMap geographicMapInterface, final PathFindingInfo pathFindingInfo, final int[][] mapArray) throws Exception {
        super.init(geographicMapInterface, pathFindingInfo, mapArray);
        //this.logUtil.putF(SpacialStrings + allBinaryTiledLayer.getHeight() + commonStrings.SPACE + SpacialStrings + width, this, this.commonStrings.INIT);
        this.buildPathFindingNodes(geographicMapInterface, pathFindingInfo, mapArray);
    }

    private void buildPathFindingNodesForCellPosition(final BasicGeographicMap geographicMapInterface, final PathFindingInfo pathFindingInfo, final int[][] mapArray, final GeographicMapCellPosition cellPosition) throws Exception {
    }

    private void buildPathFindingNodes(final BasicGeographicMap geographicMapInterface, final PathFindingInfo pathFindingInfo, final int[][] mapArray) throws Exception {
        //this.logUtil.putF(CommonSeps.getInstance().START, this, "buildPathFindingNode");
        final BasicGeographicMapCellPositionFactory geographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory();
        final AllBinaryTiledLayer allBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer();
        final int totalColumns = allBinaryTiledLayer.getColumns();
        final int totalRows = allBinaryTiledLayer.getRows();
        for (int column = 0; column < totalColumns; column++) {
            for (int row = 0; row < totalRows; row++) {
                this.buildPathFindingNodesForCellPosition(geographicMapInterface, pathFindingInfo, mapArray, geographicMapCellPositionFactory.getAt(column, row));
            }
        }
    }

}


