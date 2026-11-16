/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.drop;

import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.layer.AllBinaryLayerManager;
import org.allbinary.layer.BasicLayerProcessor;
import org.allbinary.util.BasicArrayList;

@groovy.transform.CompileStatic
public class DropLayerProcessor extends BasicLayerProcessor {
    private static final BasicLayerProcessor LAYER_PROCESSOR = new DropLayerProcessor();

    private DropLayerProcessor() {
    }

    public static BasicLayerProcessor getInstance() {
        return DropLayerProcessor.LAYER_PROCESSOR;
    }

    @Override
    public void process(AllBinaryLayerManager allBinaryLayerManager) throws Exception {
        final BasicArrayList list = this.getList();
        final int size = list.size();
        AllBinaryLayer layerInterface;
        DropLayerInterface dropLayerInterface;
        for (int index = 0; index < size; index++) {
            layerInterface = ((AllBinaryLayer) list.@objectArray[index]);
            dropLayerInterface = ((DropLayerInterface) layerInterface);
            layerInterface = ((AllBinaryLayer) dropLayerInterface.getDroppedLayer());
            allBinaryLayerManager.append(layerInterface);
        }
        list.clear();
    }

}


