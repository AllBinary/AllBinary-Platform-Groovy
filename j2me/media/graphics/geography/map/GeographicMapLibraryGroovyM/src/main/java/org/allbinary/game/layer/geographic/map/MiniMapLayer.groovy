/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geographic.map;

import javax.microedition.lcdui.Graphics;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.logic.communication.log.ForcedLogUtil;
import org.allbinary.animation.vector.CircleFilledAnimation;
import org.allbinary.game.layer.AllBinaryTiledLayer;
import org.allbinary.graphics.GPoint;
import org.allbinary.graphics.PointFactory;
import org.allbinary.graphics.Rectangle;
import org.allbinary.graphics.color.BasicColor;
import org.allbinary.graphics.color.BasicColorFactory;
import org.allbinary.graphics.color.ColorCompositeInterface;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.logic.util.event.AllBinaryEventObject;
import org.allbinary.logic.util.event.EventStrings;
import org.allbinary.media.graphics.geography.map.BasicGeographicMap;
import org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory;
import org.allbinary.media.graphics.geography.map.GeographicMapCellPosition;
import org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEvent;
import org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEventHandler;
import org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEventListenerInterface;
import org.allbinary.view.ViewPositionBase;

@groovy.transform.CompileStatic
public class MiniMapLayer extends AllBinaryLayer implements GeographicMapCellPositionEventListenerInterface {
    //private final SimpleGeographicMap simpleGeographicMap;
    protected final AllBinaryTiledLayer allBinaryTiledLayer;

    private final BasicGeographicMapCellPositionFactory geographicMapCellPositionFactory;

    private final BasicArrayList list;

    private final BasicArrayList basicColorList;

    private final BasicArrayList positionList;

    private CircleFilledAnimation animationInterface;

    public MiniMapLayer(BasicGeographicMap geographicMapInterface, ViewPositionBase viewPosition) throws Exception {
        super(StringUtil.getInstance().@EMPTY_STRING, new Rectangle(PointFactory.getInstance().createXY(0, viewPosition.getY()), geographicMapInterface.getAllBinaryTiledLayer().getWidth(), geographicMapInterface.getAllBinaryTiledLayer().getHeight()), viewPosition);
        //this.simpleGeographicMap = simpleGeographicMap;
        this.allBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer();
        this.geographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory();
        this.animationInterface = new CircleFilledAnimation(this.allBinaryTiledLayer.getCellWidth(), this.allBinaryTiledLayer.getCellHeight(), BasicColorFactory.getInstance().@WHITE);
        //this.logUtil.put("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Alpha: " + this.bufferedImage.getBitmap().getPixel(0,0), this, "updateBufferedImage");
        this.list = new BasicArrayListD();
        this.basicColorList = new BasicArrayListD();
        this.positionList = new BasicArrayListD();
        // geographicMapInterface.getGeographicMapCellPositionFactory();
        GeographicMapCellPositionEventHandler.getInstance().addListener(this);
        this.init();
    }

    protected void init() throws Exception {
        this.allBinaryTiledLayer.setPosition(this.x, this.y, this.z);
    }

    @Override
    public void onEvent(final AllBinaryEventObject eventObject) {
        ForcedLogUtil.log(EventStrings.getInstance().@PERFORMANCE_MESSAGE, this);
    }

    @Override
    public synchronized void onRemoveGeographicMapCellPositionEvent(final GeographicMapCellPositionEvent geographicMapCellPositionEvent) throws Exception {
        final ColorCompositeInterface colorCompositeInterface = ((ColorCompositeInterface) geographicMapCellPositionEvent.getSource());
        final int index = this.list.indexOf(colorCompositeInterface);
        if (index >= 0) {
            this.list.removeAt(index);
            this.basicColorList.removeAt(index);
            this.positionList.removeAt(index);
        }
    }

    @Override
    public synchronized void onGeographicMapCellPositionEvent(final GeographicMapCellPositionEvent geographicMapCellPositionEvent) throws Exception {
        //this.logUtil.putF(this.commonStrings.START, this, "onEvent");
        final ColorCompositeInterface colorCompositeInterface = ((ColorCompositeInterface) geographicMapCellPositionEvent.getSource());
        int layerIndex = -1;
        int size = this.list.size();
        ColorCompositeInterface nextColorCompositeInterface;
        for (int index = 0; index < size; index++) {
            nextColorCompositeInterface = ((ColorCompositeInterface) this.list.get(index));
            if (nextColorCompositeInterface === colorCompositeInterface) {
                layerIndex = index;
                break;
            }
        }
        final GeographicMapCellPosition geographicMapCellPosition = this.geographicMapCellPositionFactory.getInstance(geographicMapCellPositionEvent.getGeographicMapCellPosition());
        GPoint point = geographicMapCellPosition.getPoint();
        if (layerIndex == -1) {
            this.list.add(colorCompositeInterface);
            BasicColor basicColor = colorCompositeInterface.getBasicColorP();
            this.basicColorList.add(basicColor);
            this.positionList.add(point);
            layerIndex = this.basicColorList.size() - 1;
        } else {
            //update
            this.positionList.set(layerIndex, point);
        }
    }

    //private final int clearColor = BasicColor.CLEAR_COLOR.intValue();
    public void paintDots(Graphics graphics) {
        final BasicArrayList localPositionList = this.positionList;
        final BasicArrayList localBasicColorList = this.basicColorList;
        final int length = localPositionList.size();
        //int localY;
        GPoint point;
        BasicColor basicColor;
        for (int index = length; --index >= 0; ) {
            point = ((GPoint) localPositionList.get(index));
            basicColor = ((BasicColor) localBasicColorList.get(index));
            graphics.setColor(basicColor.intValue());
            //localY = point.getYP();
            this.animationInterface.setBasicColorP(basicColor);
            this.animationInterface.paintXY(graphics, point.getX() + this.x, point.getY() + this.y);
        }
    }

    @Override
    public void paint(final Graphics graphics) {
        this.allBinaryTiledLayer.paint(graphics);
        this.paintDots(graphics);
    }

}


