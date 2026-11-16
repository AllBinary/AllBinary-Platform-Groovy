/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.tracking;

import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.util.event.AllBinaryEventObject;

@groovy.transform.CompileStatic
public class TrackingEvent extends AllBinaryEventObject {
    private AllBinaryLayer layerInterface = AllBinaryLayer.NULL_ALLBINARY_LAYER;

    public TrackingEvent(Object allBinaryLayerInterface) {
        super(allBinaryLayerInterface);
        if (allBinaryLayerInterface !== TrackingEventHandler.getInstance()) {
            this.setLayerInterface(((AllBinaryLayer) allBinaryLayerInterface));
        }
    }

    public void init(Object anyType) {
        this.setSource(anyType);
    }

    public AllBinaryLayer getLayerInterface() {
        return this.layerInterface;
    }

    private void setLayerInterface(AllBinaryLayer layerInterface) {
        this.layerInterface = layerInterface;
    }

    public void setLayerInterfaceForCircularStaticPool(AllBinaryLayer layerInterface) {
        this.layerInterface = layerInterface;
    }

    public String toString() {
        StringMaker stringBuffer = new StringMaker();
        stringBuffer.append('TrackingEvent: \n');
        stringBuffer.append('LayerInterface: ');
        stringBuffer.append(this.layerInterface.toString());
        return stringBuffer.toString();
    }

}


