/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader;


/**  *  * @author User  */
@groovy.transform.CompileStatic
public class LoadedShaderManager {
    private static final ShaderManager instance = new ShaderManager(-1, -1);

    /**      * @return the instance      */
    public static ShaderManager getInstance() {
        return LoadedShaderManager.instance;
    }

}


