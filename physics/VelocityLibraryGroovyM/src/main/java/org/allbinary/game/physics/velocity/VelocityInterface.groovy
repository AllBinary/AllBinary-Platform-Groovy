/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.velocity;


@groovy.transform.CompileStatic
public interface VelocityInterface extends BasicVelocityInterface {
    //void setMaxYVelocity(int multiply);
    int getMaxForwardVelocity();

    int getMaxReverseVelocity();

    void limitMaxXYForwardVelocity();

    void limitMaxXYReverseVelocity();

    void limitXYToForwardAndReverseMaxVelocity();

    void limitMaxXYVelocity(int maxVelocity);

    void setMaxForwardVelocity(int maxForwardVelocity);

    void setMaxReverseVelocity(int maxReverseVelocity);

}


