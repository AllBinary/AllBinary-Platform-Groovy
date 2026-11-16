/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics;


@groovy.transform.CompileStatic
public class RendererStateFactory {
    private static final RendererStateFactory instance = new RendererStateFactory();

    public static RendererStateFactory getInstance() {
        return RendererStateFactory.instance;
    }

    private boolean loaded = false;

    private boolean surfaceChanged = false;

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void setSurfaceChanged(boolean initialized) {
        this.surfaceChanged = initialized;
    }

    public boolean isSurfaceChanged() {
        return this.surfaceChanged;
    }

}


