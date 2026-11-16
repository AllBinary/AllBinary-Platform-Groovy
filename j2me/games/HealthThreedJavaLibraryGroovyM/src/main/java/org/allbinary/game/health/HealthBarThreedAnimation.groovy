/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.lcdui.Graphics;
import min3d.core.ColorBufferList;
import min3d.core.Number3dBufferList;
import min3d.objectPrimitives.Rectangle;
import min3d.vos.Number3d;
import org.allbinary.device.OpenGLESGraphics;
import org.allbinary.graphics.threed.min3d.renderer.Object3dProcessor;
import org.allbinary.graphics.threed.min3d.renderer.Object3dProcessorUtil;
import org.allbinary.graphics.color.BasicColorFactory;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.view.ViewPositionBase;

@groovy.transform.CompileStatic
public class HealthBarThreedAnimation extends HealthBarAnimation {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private Rectangle rectangle;

    private final BasicColorFactory basicColorFactory = BasicColorFactory.getInstance();

    public HealthBarThreedAnimation(AllBinaryLayer layerInterface, int location) throws Exception {
        super(layerInterface, location);
        this.basicColor = this.basicColorFactory.@GREEN;
        this.colorP = this.basicColor.intValue();
        this.rectangle = new Rectangle(0, 0, 1, 1, this.basicColor);
        this.rectangle.setDoubleSidedEnabled(true);
        this.rectangle.setNormalsEnabled(false);
        this.rectangle.setTexturesEnabled(false);
    }

    private void updateColor() {
        ColorBufferList colorBufferList = this.rectangle.getVertices().getColor4BufferList();
        int size = colorBufferList.size();
        for (int index = size; --index >= 0; ) {
            colorBufferList.set(index, this.basicColor);
        }
    }

    private void updateSize() {
        final Number3dBufferList number3dBufferList = this.rectangle.getVertices().getPointsOnFacesNumber3dBufferList();
        int width = this.x2;
        int height = this.thickness * 2;
        int segsH = 1;
        int segsW = 1;
        int row;
        int col;
        float w = Math.divideExact(width, segsW);
        float h = Math.divideExact(height, segsH);
        float width5 = ((float) (width / 2f));
        float height5 = ((float) (height / 2f));
        int index = 0;
        for (row = 0; row <= segsH; row++) {
            for (col = 0; col <= segsW; col++) {
                number3dBufferList.set(index++, ((float) (((float) (((float) col) * w)) - width5)), ((float) (((float) (((float) row) * h)) - height5)), 0f);
            }
        }
    }

    public void onHealthChange(final int newX2) {
        super.onHealthChange(newX2);
        this.updateColor();
        this.updateSize();
    }

    private final Object3dProcessor object3dProcessor = Object3dProcessorUtil.getInstance().getInstanceObject3dProcessor();

    public void paintThreedXYZ(final Graphics graphics, final int x, final int y, final int z) {
        final OpenGLESGraphics openGLESGraphics = ((OpenGLESGraphics) graphics);
        final GL10 gl = openGLESGraphics.getGl10();
        final ViewPositionBase viewPosition = this.allbinaryLayer.getViewPosition();
        final Number3d positionNumber3d = this.rectangle.getPosition();
        //positionNumber3d.y = viewPosition.getZ() + 12;
        positionNumber3d.@x = -(((float) viewPosition.getX()));
        positionNumber3d.@z = -(((float) viewPosition.getY()));
        positionNumber3d.@y = viewPosition.getZ() + this.allbinaryLayer.getHeight();
        this.object3dProcessor.drawObject(gl, this.rectangle);
    }

}


