/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.search;

import org.allbinary.logic.util.event.AllBinaryEventObject;

@groovy.transform.CompileStatic
public class ImageComparisonSearchResultsEvent extends AllBinaryEventObject {
    private ImageComparisonSearch imageComparisonSearch;

    public ImageComparisonSearchResultsEvent(Object anyType, ImageComparisonSearch imageComparisonSearch) {
        super(anyType);
        this.setImageComparisonSearch(imageComparisonSearch);
    }

    public ImageComparisonSearch getImageComparisonSearch() {
        return this.imageComparisonSearch;
    }

    private void setImageComparisonSearch(ImageComparisonSearch imageComparisonSearch) {
        this.imageComparisonSearch = imageComparisonSearch;
    }

}


