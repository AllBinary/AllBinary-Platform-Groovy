/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison;

import org.allbinary.logic.util.event.AllBinaryEventObject;

@groovy.transform.CompileStatic
public class ImageComparisonResultsEvent extends AllBinaryEventObject {
    private ImageComparisonResult imageComparisonResult;

    public ImageComparisonResultsEvent(Object anyType, ImageComparisonResult imageComparisonInfo) {
        super(anyType);
        this.setImageComparisonResult(imageComparisonInfo);
    }

    public ImageComparisonResult getImageComparisonResult() {
        return this.imageComparisonResult;
    }

    public void setImageComparisonResult(ImageComparisonResult imageComparisonResult) {
        this.imageComparisonResult = imageComparisonResult;
    }

}


