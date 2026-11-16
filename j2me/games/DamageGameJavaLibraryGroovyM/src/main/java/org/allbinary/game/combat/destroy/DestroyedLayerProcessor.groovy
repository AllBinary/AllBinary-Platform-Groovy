/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy;

import org.allbinary.game.combat.destroy.event.DestroyEventCircularStaticPool;
import org.allbinary.game.combat.destroy.event.DestroyedEvent;
import org.allbinary.game.combat.destroy.event.DestroyedEventHandler;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.layer.AllBinaryLayerManager;
import org.allbinary.layer.BasicLayerProcessor;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.string.CommonStrings;
import org.allbinary.util.BasicArrayList;

@groovy.transform.CompileStatic
public class DestroyedLayerProcessor extends BasicLayerProcessor {
    private static BasicLayerProcessor DESTROYED_LAYER_PROCESSOR = BasicLayerProcessor.NULL_LAYER_PROCESSOR;

    private DestroyedLayerProcessor() {
    }

    public static void init() {
        DestroyedLayerProcessor.DESTROYED_LAYER_PROCESSOR = new DestroyedLayerProcessor();
    }

    public static BasicLayerProcessor getInstance() {
        return DestroyedLayerProcessor.DESTROYED_LAYER_PROCESSOR;
    }

    //    private final String LAYER_LABEL = "layerInterface: ";    
    @Override
    public void process(AllBinaryLayerManager allBinaryLayerManager) throws Exception {
        BasicArrayList list = this.getList();
        int size = list.size();
        final DestroyedEventHandler destroyedEventHandler = DestroyedEventHandler.getInstance();
        final DestroyEventCircularStaticPool destroyEventCircularStaticPool = DestroyEventCircularStaticPool.getInstance();
        //GroupLayerManagerListener.getInstance().log();
        DestroyedEvent destroyedEvent;
        AllBinaryLayer layerInterface;
        for (int index = 0; index < size; index++) {
            // no physics here - just destroy them
            Object layerInterfaceCanBeNull = list.@objectArray[index];
            if (layerInterfaceCanBeNull != null) {
                layerInterface = ((AllBinaryLayer) layerInterfaceCanBeNull);
                //                this.logUtil.putF(stringBuilder.append("Processing: ").appendint(allBinaryLayerManager.getSize()).toString(), this, this.commonStrings.PROCESS);
                allBinaryLayerManager.remove(layerInterface);
                //                this.logUtil.putF(stringBuilder.append("After: ").appendint(allBinaryLayerManager.getSize()).toString(), this, this.commonStrings.PROCESS);
                destroyedEvent = destroyEventCircularStaticPool.getInstanceForLayer(layerInterface);
                // Notify Listeners of Destroyed Layer
                destroyedEventHandler.fireEvent(destroyedEvent);
            } else {
                final CommonStrings commonStrings = CommonStrings.getInstance();
            }
        }
        list.clear();
    }

}


