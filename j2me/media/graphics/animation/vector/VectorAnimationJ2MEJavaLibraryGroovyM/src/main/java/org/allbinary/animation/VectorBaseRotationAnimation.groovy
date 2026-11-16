/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation;

import javax.microedition.lcdui.Graphics;
import org.allbinary.graphics.color.BasicColor;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.math.PrimitiveIntUtil;
import org.allbinary.math.AngleInfo;
import org.allbinary.util.CircularIndexUtil;

@groovy.transform.CompileStatic
public class VectorBaseRotationAnimation extends RotationAnimation implements VectorAnimationInterface {
    private int[][][] currentPoints = NullUtil.getInstance().@NULL_INT_ARRAY_ARRAY_ARRAY;

    public VectorBaseRotationAnimation(final AngleInfo angleInfo, final int[][][] currentPoints, final BasicColor basicColor, final AnimationBehavior animationBehavior) {
        super(angleInfo, CircularIndexUtil.createInstance(Math.divideExact(360, ((int) angleInfo.getAngleIncrementInfo().getAngleIncrement()))), animationBehavior);
        this.setPoints(currentPoints);
        this.setBasicColorP(basicColor);
    }

    //    }
    @Override
    public int getAnimationSize() throws Exception {
        return this.getSize();
    }

    @Override
    public int getFrame() {
        return this.circularIndexUtil.getIndex();
    }

    @Override
    public void setFrame(int index) {
        this.circularIndexUtil.setIndex(index);
    }

    @Override
    public void nextFrame() {
        this.circularIndexUtil.next();
    }

    @Override
    public void previousFrame() {
        this.circularIndexUtil.previous();
    }

    @Override
    public int getSize() {
        return this.currentPoints.length;
    }

    @Override
    public void setSequence(final int[] sequence) {
    }

    @Override
    public int[] getSequence() {
        return PrimitiveIntUtil.getArrayInstance();
    }

    @Override
    public void paintXY(final Graphics graphics, final int x, final int y) {
        this.basicSetColorUtil.setBasicColorP(graphics, this.basicColor);
        try {
            /*              * if (this.currentFrame >= this.currentPoints.length) {              * this.currentFrame = 0; }              */
            int nextPointX = 0;
            int nextPointY = 0;
            int[] nextPoint;
            int[] point;
            final int[][] currentPointsFrame = this.currentPoints[this.circularIndexUtil.getIndex()];
            final int size = currentPointsFrame.length;
            //3;
            int index = size - 2;
            while (--index >= 0) {
                nextPoint = currentPointsFrame[index];
                point = currentPointsFrame[index + 1];
                nextPointX = nextPoint[0];
                nextPointY = nextPoint[1];
                if (nextPointX != 1000) {
                    // + this.currentPoints[this.currentFrame][index][1] + y, // this, // canvasStrings.PAINT);
                    graphics.drawLine(point[0] + x, point[1] + y, nextPointX + x, nextPointY + y);
                } else {
                    index--;
                }
            }
        } catch (Exception e) {
            this.logUtil.put(this.commonStrings.@EXCEPTION, this, 'paintVectors', e);
        }
    }

    @Override
    public int[][] getPoints(final int frame) {
        return this.currentPoints[frame];
    }

    public void setPoints(final int[][][] currentPoints) {
        this.currentPoints = currentPoints;
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.currentPoints.length);
    }

    //Needed for polyglot do not remove
    @Override
    public BasicColor getBasicColorP() {
        return super.getBasicColorP();
    }

    //Needed for polyglot do not remove
    @Override
    public void setBasicColorP(final BasicColor basicColor) {
        super.setBasicColorP(basicColor);
    }

}


