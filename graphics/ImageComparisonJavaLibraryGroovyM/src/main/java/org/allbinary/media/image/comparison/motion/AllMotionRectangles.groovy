/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion;

import java.awt.*;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.media.image.comparison.ImageComparisonResult;
import org.allbinary.media.image.comparison.pixel.PixelDelta;

@groovy.transform.CompileStatic
public class AllMotionRectangles extends MotionRectangles {
    private static final String NAME = 'allMotionRectangles_';

    //GenerateImageWithBoundingBoxesAroundMovingArtifacts
    public AllMotionRectangles(ImageComparisonResult imageComparisonResult) throws Exception {
        super(NAME, imageComparisonResult);
        this.createMotionRectangles(imageComparisonResult);
    }

    private void createMotionRectangles(ImageComparisonResult imageComparisonInfo) throws Exception {
        final BasicArrayList vector = imageComparisonInfo.getNonMatchingPixelVector();
        final int size = vector.size();
        /*         if(iterator.hasNext())         {             PixelDelta pixelDelta = (PixelDelta) iterator.next();                       Rectangle newRectangle =                 new Rectangle(pixelDelta.getPoint().x, pixelDelta.getPoint().y, 1, 1);                       MotionRectangle motionRectangle = new MotionRectangle(newRectangle);             motionRectangle.getPixelDeltaVector().add(pixelDelta);                       this.getVector().add(motionRectangle);         }*/
        for (int index = 0; index < size; index++) {
            PixelDelta pixelDelta = ((PixelDelta) vector.get(index));
            this.addPixelDeltaToAMotionRectangle(pixelDelta);
        }
    }

    private boolean addPixelDeltaToExistingMotionRectangle(PixelDelta pixelDelta) throws Exception {
        final BasicArrayList vector = this.getVector();
        final int size = vector.size();
        for (int index = 0; index < size; index++) {
            MotionRectangle motionRectangle = ((MotionRectangle) vector.get(index));
            //Should this area be added to the rectangle
            if (shouldPixelDeltaPartOfMotionRectangle(motionRectangle, pixelDelta)) {
                //ModifyRectangle - extend it to the lower and/or right
                int newWidth = pixelDelta.getPoint().getX() - motionRectangle.getRectangle().@x;
                int newHeight = pixelDelta.getPoint().getY() - motionRectangle.getRectangle().@y;
                if (newWidth < motionRectangle.getRectangle().@width) {
                    newWidth = motionRectangle.getRectangle().@width;
                }
                if (newHeight < motionRectangle.getRectangle().@height) {
                    newHeight = motionRectangle.getRectangle().@height;
                }
                motionRectangle.getRectangle().setSize(newWidth, newHeight);
                /*                 if(pixelDelta.getPoint().x > 560 && pixelDelta.getPoint().y > 330 &&                     pixelDelta.getPoint().x < 600 && pixelDelta.getPoint().y < 365)                     this.logUtil.putF(new StringMaker().append("Adjusted existing motionRectangle: \n" +                         motionRectangle.getRectangle() + " for: " + pixelDelta.getPoint(), this, "addPixelDeltaToExistingMotionRectangle");                                  */
                return true;
            }
        }
        return false;
    }

    //Returns a new rectangle or modifies one
    private void addPixelDeltaToAMotionRectangle(PixelDelta pixelDelta) throws Exception {
        if (!addPixelDeltaToExistingMotionRectangle(pixelDelta)) {
            Rectangle newRectangle = new Rectangle(pixelDelta.getPoint().getX(), pixelDelta.getPoint().getY(), 1, 1);
            MotionRectangle motionRectangle = new MotionRectangle(newRectangle);
            motionRectangle.getPixelDeltaVector().add(pixelDelta);
            /*             if(pixelDelta.getPoint().x > 560 && pixelDelta.getPoint().y > 330 &&                 pixelDelta.getPoint().x < 600 && pixelDelta.getPoint().y < 365)             {                 StringMaker stringBuffer = new StringMaker();                 iterator = this.getVector();                 while(iterator.hasNext())                 {                     MotionRectangle nextMotionRectangle = (MotionRectangle) iterator.next();                                          if(nextMotionRectangle.getRectangle().x > 560 && nextMotionRectangle.getRectangle().y > 330 &&                         nextMotionRectangle.getRectangle().x < 600 && nextMotionRectangle.getRectangle().y < 365)                     {                         stringBuffer.append(nextMotionRectangle.getRectangle());                         stringBuffer.append(CommonSeps.getInstance().NEW_LINE);                     }                 }                 this.logUtil.putF(new StringMaker().append("Adding motionRectangle: " +                     motionRectangle.getRectangle() + " since it could not be added to: " +                     stringBuffer.toString(), this, "addPixelDeltaToAMotionRectangle");             }             */
            this.getVector().add(motionRectangle);
        }
    }

    private boolean shouldPixelDeltaPartOfMotionRectangle(MotionRectangle motionRectangle, PixelDelta pixelDelta) throws Exception {
        boolean isPixelLeftOfTheRectangle = false;
        if (motionRectangle.getRectangle().@y > pixelDelta.getPoint().getY()) {
            throw new Exception('PixelAboveTheRectangle');
        }
        if (motionRectangle.getRectangle().@x > pixelDelta.getPoint().getX()) {
            isPixelLeftOfTheRectangle = true;
        }
        /*          boolean isPixelInRectangle =             PixelDeltaInRectangleCollisionUtil.isCollision(rectangle, pixelDelta);            if(!isPixelInRectangle)          {          }          else          {             //ignore it is in a rectangle already             break;          }  */
        if (!isPixelLeftOfTheRectangle) {
            //Does PixelDelta seem to be part of rectangle
            return this.isPixelDeltaLikelyPartOfMotionRectangle(motionRectangle, pixelDelta);
        }
        return false;
    }

    private boolean isPixelDeltaLikelyPartOfMotionRectangle(MotionRectangle motionRectangle, PixelDelta pixelDelta) throws Exception {
        /*         BasicArrayList pixelDeltasInTheSameRow = new BasicArrayListD();                   iterator = motionRectangle.getPixelDeltaVector();                   while(iterator.hasNext())         {             PixelDelta pixelDeltaInMotionRectangle =                 (PixelDelta) iterator.next();                       if(pixelDeltaInMotionRectangle.getPoint().getY() ==                pixelDelta.getPoint().getY())             {                pixelDeltasInTheSameRow.add(pixelDeltaInMotionRectangle);             }         }          */
        int maxX = motionRectangle.getRectangle().@x + motionRectangle.getRectangle().@width;
        int maxY = motionRectangle.getRectangle().@y + motionRectangle.getRectangle().@height;
        int horizontalDistance = pixelDelta.getPoint().getX() - maxX;
        int verticalDistance = pixelDelta.getPoint().getY() - maxY;
        /*         this.logUtil.putF(             "MaxX: " + maxX +             " horizontalDistance: " + horizontalDistance +             " pixelDeltasInTheSameRow.size(): " + pixelDeltasInTheSameRow.size(), this, "isPixelDeltaLikelyPartOfMotionRectangle");          */
        if (horizontalDistance < this.MAX_PIXEL_DISTANCE_THRESHOLD && verticalDistance < this.MAX_PIXEL_DISTANCE_THRESHOLD) {
            return true;
        }
        return false;
    }

}


