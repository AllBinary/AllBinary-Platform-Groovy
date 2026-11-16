/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio;


@groovy.transform.CompileStatic
public class CompositeSound extends Sound {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    protected CompositeSound(String resource) {
        super(resource);
    }

    @Override
    public void init() throws Exception {
        //player = AllBinaryMediaManager.createPlayer(this.getResource());
        this.setPlayerP(new PlayerComposite(AllBinaryMediaManager.createPlayer(this.getResource()), 570));
    }

}


