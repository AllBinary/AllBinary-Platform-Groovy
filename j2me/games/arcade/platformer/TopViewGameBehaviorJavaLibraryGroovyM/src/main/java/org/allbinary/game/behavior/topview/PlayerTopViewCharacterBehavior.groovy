/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview;

import org.allbinary.direction.Direction;
import org.allbinary.game.layer.AllBinaryTiledLayer;
import org.allbinary.game.tracking.TrackingEventCircularStaticPool;
import org.allbinary.game.tracking.TrackingEventHandler;
import org.allbinary.graphics.displayable.DisplayInfoSingleton;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.media.graphics.geography.map.BasicGeographicMap;
import org.allbinary.media.graphics.geography.map.BasicGeographicMapUtil;
import org.allbinary.media.graphics.geography.map.GeographicMapCellPosition;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class PlayerTopViewCharacterBehavior extends TopViewCharacterBehavior {
    protected final LogUtil logUtil = LogUtil.getInstance();

    @Override
    public void terrainEvent(final AllBinaryLayer layer, final Direction direction, final int x, final int y, final BasicGeographicMap[] geographicMapInterfaceArray, final GeographicMapCellPosition geographicMapCellPosition) throws Exception {
        TrackingEventHandler.getInstance().fireEvent(TrackingEventCircularStaticPool.getInstance().getNextInstance(layer));
    }

    @Override
    public void terrainMove(final AllBinaryLayer layer, final BasicGeographicMap[] geographicMapInterfaceArray, final int x, final int y) {
        //final DisplayInfoSingleton displayInfo = DisplayInfoSingleton.getInstance();
        final BasicGeographicMapUtil basicGeographicMapUtil = BasicGeographicMapUtil.getInstance();
        //basicGeographicMapUtil.move(geographicMapInterfaceArray, -x, -y);
        basicGeographicMapUtil.setPosition(geographicMapInterfaceArray, x, y);
    }

    private void moveIfOnScreen(final AllBinaryLayer layer, final int ax, final int ay) {
    }

    private boolean isTiledLayerMoveable(final AllBinaryTiledLayer terrainTiledLayer, final int x, final int y) {
        return (terrainTiledLayer.getXP() + DisplayInfoSingleton.getInstance().getLastWidth() < terrainTiledLayer.getWidth() || x < 0) && (terrainTiledLayer.getXP() > 0 || x > 0);
    }

}


