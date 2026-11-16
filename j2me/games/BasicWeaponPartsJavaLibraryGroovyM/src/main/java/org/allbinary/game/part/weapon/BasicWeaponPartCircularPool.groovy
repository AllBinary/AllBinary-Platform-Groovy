/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part.weapon;

import org.allbinary.game.combat.weapon.WeaponProperties;
import org.allbinary.game.score.ScoreableInterface;
import org.allbinary.graphics.RelativeRelationship;
import org.allbinary.layer.AllBinaryLayer;

@groovy.transform.CompileStatic
public class BasicWeaponPartCircularPool {
    public static final BasicWeaponPartCircularPool NULL_BASIC_WEAPON_PART_CIRCULAR_POOL = new BasicWeaponPartCircularPool();

    //private BasicWeaponPart[] VECTOR_GRAPHIC_ARRAY = new BasicWeaponPart[MAX];
    private BasicWeaponPart basicWeaponPart = BasicWeaponPart.NULL_BASIC_WEAPON_PART;

    public void init(final BasicWeaponPartFactoryInterface basicWeaponPartFactoryInterface) throws Exception {
        this.basicWeaponPart = basicWeaponPartFactoryInterface.getInstance();
    }

    public synchronized BasicWeaponPart getInstance(final AllBinaryLayer sourceLayerInterface, final WeaponProperties weaponProperties, final ScoreableInterface scoreableInterface, final RelativeRelationship relativeRelationship) throws Exception {
        //BasicWeaponPart basicWeaponPart = (BasicWeaponPart) VECTOR_GRAPHIC_ARRAY[this.circularIndexUtil.getIndex()];
        this.basicWeaponPart.init(sourceLayerInterface, weaponProperties, scoreableInterface, relativeRelationship);
        //this.circularIndexUtil.next();
        return this.basicWeaponPart;
    }

}


