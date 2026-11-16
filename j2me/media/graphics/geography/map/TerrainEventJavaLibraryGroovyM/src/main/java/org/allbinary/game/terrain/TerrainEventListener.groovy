/* Generated Code Do Not Modify */
package org.allbinary.game.terrain;

import org.allbinary.logic.communication.log.ForcedLogUtil;
import org.allbinary.logic.util.event.AllBinaryEventObject;
import org.allbinary.logic.util.event.EventStrings;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;

@groovy.transform.CompileStatic
public class TerrainEventListener implements TerrainEventListenerInterface {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final BasicArrayList list = new BasicArrayListD();

    @Override
    public void onEvent(AllBinaryEventObject eventObject) {
        ForcedLogUtil.log(EventStrings.getInstance().@PERFORMANCE_MESSAGE, this);
    }

    @Override
    public void onTerrainEvent(TerrainEvent terrainEvent) {
        // terrainEvent.getBasicTerrainInfo().getAngle().getValue(), this, "onTerrainEvent");
        this.list.clear();
        this.list.add(terrainEvent);
    }

    public BasicArrayList getList() {
        return this.list;
    }

}


