/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.part.weapon;

import org.allbinary.animation.Animation;
import org.allbinary.game.combat.weapon.WeaponProperties;
import org.allbinary.game.layer.weapon.WeaponLayer;
import org.allbinary.game.layer.weapon.WeaponLayerCircularPool;
import org.allbinary.game.score.NoScoreable;
import org.allbinary.game.score.ScoreableInterface;
import org.allbinary.graphics.RelativeRelationship;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.layer.AllBinaryLayerManager;
import org.allbinary.math.NoDecimalTrigTable;

@groovy.transform.CompileStatic
public class StraightMultiProjectileWeaponPart extends BasicWeaponPart {
    public static StraightMultiProjectileWeaponPart createStraightMultiProjectileWeaponPart(final Animation animationInterface, final WeaponLayerCircularPool weaponLayerCircularStaticPool) {
        return new StraightMultiProjectileWeaponPart(animationInterface, AllBinaryLayer.NULL_ALLBINARY_LAYER, weaponLayerCircularStaticPool, 2, WeaponProperties.NULL_WEAPON_PROPERTIES, NoScoreable.getInstance(), RelativeRelationship.NULL_RELATIVE_RELATIONSHIP);
    }

    private final WeaponLayerCircularPool weaponLayerCircularStaticPool;

    private final int total;

    public StraightMultiProjectileWeaponPart(final Animation animationInterface, final AllBinaryLayer sourceLayerInterface, final WeaponLayerCircularPool weaponLayerCircularStaticPool, final int total, final WeaponProperties weaponProperties, final ScoreableInterface scoreableInterface, final RelativeRelationship relativeRelationship) {
        super(animationInterface, sourceLayerInterface, weaponProperties, scoreableInterface, relativeRelationship);
        this.total = total;
        this.weaponLayerCircularStaticPool = weaponLayerCircularStaticPool;
    }

    private final NoDecimalTrigTable noDecimalTrigTable = NoDecimalTrigTable.getInstance();

    @Override
    public void processScore(final AllBinaryLayerManager allbinaryLayerManager, final short angle, final short otherAngle, final WeaponProperties weaponProperties, final ScoreableInterface scoreableInterface) throws Exception {
        final AllBinaryLayer sourceLayerInterface = this.getOwnerLayerInterface();
        final int reducedWidth = (Math.divideExact(sourceLayerInterface.getWidth() * 8, 10));
        final int halfWidth = (reducedWidth >> 1);
        //int halfHeight = sourceLayerInterface.getHalfHeight();
        final int x = this.relativeRelationship.getX();
        final int y = this.relativeRelationship.getY();
        //WeaponLayer[] weaponLayerArray = WeaponLayerArrayLayerCircularStaticPool.getInstance(total);
        long sine;
        int beamX;
        long cosine;
        int beamY;
        WeaponLayer weaponLayer;
        final int increment = Math.divideExact(reducedWidth, (this.total - 1));
        int next = -halfWidth;
        for (int index = 0; index < this.total; index++) {
            sine = ((long) (next * this.noDecimalTrigTable.sin(((int) angle))));
            beamX = ((int) (Math.divideExact(sine, ((long) this.noDecimalTrigTable.@SCALE))));
            cosine = ((long) (next * this.noDecimalTrigTable.cos(((int) angle))));
            beamY = -((int) (Math.divideExact(cosine, ((long) this.noDecimalTrigTable.@SCALE))));
            weaponLayer = this.weaponLayerCircularStaticPool.getInstanceWeaponLayer(sourceLayerInterface, x + beamX, y + beamY, 0, ((int) angle), ((int) otherAngle), weaponProperties, scoreableInterface);
            allbinaryLayerManager.append(weaponLayer);
            next += increment;
        }
    }

}


