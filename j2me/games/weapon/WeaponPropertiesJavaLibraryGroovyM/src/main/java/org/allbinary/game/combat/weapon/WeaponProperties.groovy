/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.weapon;

import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.logic.math.BasicDecimal;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.string.CommonSeps;
import org.allbinary.string.CommonStrings;

/**  *  * @author user  */
@groovy.transform.CompileStatic
public class WeaponProperties extends SimpleWeaponProperties {
    public static final WeaponProperties NULL_WEAPON_PROPERTIES = new WeaponProperties(0L, 0L, 0L, 0, ((short) 0));

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private long reloadTime;

    private long targetingTime;

    private BasicDecimal speed = BasicDecimal.ZERO_BIGDECIMAL;

    private static boolean messageSent = false;

    private final long MAX = 10240L;

    private final short ZERO = 0;

    public WeaponProperties(long reloadTime, long targetingTime, long speed, int damage, short dissipation) {
        if (speed < this.MAX && speed != 0L && !WeaponProperties.messageSent) {
            final String MESSAGE = 'Danger Danger Danger: Speed probably to slow if using 1 degree calculations as velocity for a single axis could be below 1024: ';
            final CommonStrings commonStrings = CommonStrings.getInstance();
            PreLogUtil.put(new StringMaker().append(MESSAGE).appendlong(speed).toString(), this, commonStrings.@CONSTRUCTOR);
            //throw new Exception(MESSAGE + speed);
            WeaponProperties.messageSent = true;
        }
        this.setReloadTime(reloadTime);
        this.setTargetingTime(targetingTime);
        this.setDamage(damage);
        this.setDissipation(dissipation);
        this.setSpeed(new BasicDecimal(speed));
        if (dissipation != this.ZERO) {
            final long unscaledDamage = this.speed.getUnscaled() * damage;
            final int scaledDissipation = dissipation * this.speed.getScaledFactorValue();
            final long value = (Math.divideExact(unscaledDamage, ((long) scaledDissipation)));
            this.setRange(Math.divideExact(((int) (value * 9)), 10));
        }
    }

    private void setReloadTime(long reloadTime) {
        this.reloadTime = reloadTime;
    }

    public long getReloadTime() {
        return this.reloadTime;
    }

    private void setTargetingTime(long targetingTime) {
        this.targetingTime = targetingTime;
    }

    public long getTargetingTime() {
        return this.targetingTime;
    }

    /**      * @return the speed      */
    public BasicDecimal getSpeed() {
        return this.speed;
    }

    /**      * @param speed the speed to set      */
    public void setSpeed(BasicDecimal speed) {
        this.speed = speed;
    }

    public int getDamageI(int range) {
        return this.getDamage() - (Math.divideExact((this.getDissipation() * range), this.speed.getScaled()));
    }

    private static final String DAMAGE = 'Damage: ';

    private static final String RANGE = 'Range: ';

    private static final String RELOAD = 'Reload: ';

    public String[] toStringArray() {
        int index = 0;
        final String[] stringArray = new String[3];
        final StringMaker stringBuffer = new StringMaker();
        stringArray[index++] = stringBuffer.append(WeaponProperties.DAMAGE).appendint(this.getDamage()).toString();
        stringBuffer.delete(0, stringBuffer.length());
        stringArray[index++] = stringBuffer.append(WeaponProperties.RANGE).appendint(this.getRange()).toString();
        //stringArray[index++] = "Speed: " + this.getSpeed();
        stringBuffer.delete(0, stringBuffer.length());
        stringArray[index++] = stringBuffer.append(WeaponProperties.RELOAD).appendlong(this.getReloadTime()).toString();
        return stringArray;
    }

    public String toString() {
        final StringMaker stringBuffer = new StringMaker();
        stringBuffer.append(WeaponProperties.DAMAGE).appendint(this.getDamage());
        stringBuffer.append(CommonSeps.getInstance().@SPACE);
        stringBuffer.append(WeaponProperties.RANGE).appendint(this.getRange());
        stringBuffer.append(CommonSeps.getInstance().@SPACE);
        stringBuffer.append(WeaponProperties.RELOAD).appendlong(this.getReloadTime());
        return stringBuffer.toString();
    }

}


