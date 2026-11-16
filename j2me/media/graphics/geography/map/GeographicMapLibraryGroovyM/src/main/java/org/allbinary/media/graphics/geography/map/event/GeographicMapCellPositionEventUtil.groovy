/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.event;

import org.allbinary.graphics.CellPositionFactory;
import org.allbinary.media.graphics.geography.map.GeographicMapCellPositionTracking;

@groovy.transform.CompileStatic
public class GeographicMapCellPositionEventUtil {
    private final GeographicMapCellPositionEvent geographicMapCellPositionEvent;

    private final GeographicMapCellPositionEventHandler geographicMapCellPositionEventHandler = GeographicMapCellPositionEventHandler.getInstance();

    public GeographicMapCellPositionEventUtil(Object anyType) {
        this.geographicMapCellPositionEvent = new GeographicMapCellPositionEvent(anyType, CellPositionFactory.getInstance().@NONE);
    }

    public void update(GeographicMapCellPositionTracking geographicMapCellPositionTracking) throws Exception {
        this.geographicMapCellPositionEvent.setGeographicMapCellPosition(geographicMapCellPositionTracking.getCurrentGeographicMapCellPosition());
        this.geographicMapCellPositionEventHandler.fireEvent(this.geographicMapCellPositionEvent);
    }

    public void remove(GeographicMapCellPositionTracking geographicMapCellPositionTracking) throws Exception {
        this.geographicMapCellPositionEvent.setGeographicMapCellPosition(geographicMapCellPositionTracking.getCurrentGeographicMapCellPosition());
        this.geographicMapCellPositionEventHandler.fireRemoveEvent(this.geographicMapCellPositionEvent);
    }

}


