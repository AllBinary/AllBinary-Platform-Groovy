/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.queue;

import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;

@groovy.transform.CompileStatic
public class BasicQueue {
    protected final BasicArrayList queueVector = new BasicArrayListD();

    protected BasicQueue() {
    }

    protected synchronized boolean offer(Object anyType) throws Exception {
        this.queueVector.add(anyType);
        return true;
    }

    protected synchronized void remove(Object anyType) {
        this.queueVector.remove(anyType);
    }

    protected synchronized Object removeLast() {
        Object anyType = this.queueVector.get(this.queueVector.size() - 1);
        this.queueVector.remove(anyType);
        return anyType;
    }

}


