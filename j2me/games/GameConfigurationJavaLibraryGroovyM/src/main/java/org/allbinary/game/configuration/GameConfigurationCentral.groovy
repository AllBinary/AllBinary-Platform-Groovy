/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration;

import org.allbinary.game.configuration.persistance.GameConfigurationPersistanceSingleton;
import org.allbinary.game.configuration.persistance.KeyValuePersistance;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.math.SmallIntegerSingletonFactory;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.string.CommonSeps;
import org.allbinary.string.CommonStrings;
import org.allbinary.util.ABHashtable;
import org.allbinary.util.BasicArrayList;

@groovy.transform.CompileStatic
public class GameConfigurationCentral {
    private static Object SINGLETON = NullUtil.getInstance().@NULL_OBJECT;

    public static GameConfigurationCentral getInstance() {
        if (GameConfigurationCentral.SINGLETON === NullUtil.getInstance().@NULL_OBJECT) {
            GameConfigurationCentral.SINGLETON = new GameConfigurationCentral();
        }
        return ((GameConfigurationCentral) GameConfigurationCentral.SINGLETON);
    }

    protected final LogUtil logUtil = LogUtil.getInstance();

    //private static String[] ORIENTATIONS = {"Vertical", CommonPhoneStrings.getInstance().UP, CommonPhoneStrings.getInstance().DOWN, CommonPhoneStrings.getInstance().LEFT, CommonPhoneStrings.getInstance().RIGHT};
    public final GameConfiguration SCALE;

    public final GameConfiguration ORIENTATION;

    public final GameConfiguration SENSOR_UPDATE_RATE;

    public final GameConfiguration VIBRATION;

    public final GameConfiguration CHALLENGE_LEVEL;

    public final GameConfiguration COLLIDE_DAMAGE;

    public final GameConfiguration DURABILITY_CHALLENGE_LEVEL;

    public final GameConfiguration SPEED_CHALLENGE_LEVEL;

    public final GameConfiguration ATTACK_CHALLENGE_LEVEL;

    public final GameConfiguration CONTROL_LEVEL;

    public final GameConfiguration PLAYER_INPUT_WAIT;

    // enemy activity level
    public final GameConfiguration SPEED;

    // GameConfiguration(SmallIntegerSingletonFactory.getInstance(0));
    public final GameConfiguration SOUND_VOLUME;

    public final GameConfiguration MAX_GAME_OBJECTS;

    public final GameConfiguration MAX_LAYERS;

    //angle increment                    30 12 10 9  6  4  2   1  
    private int gameControlFidelity = 36;

    private GameConfigurationCentral() {
        final SmallIntegerSingletonFactory smallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance();
        this.SCALE = new GameConfiguration('Scale', smallIntegerSingletonFactory.getAt(2), smallIntegerSingletonFactory.getAt(2), smallIntegerSingletonFactory.getAt(3));
        this.ORIENTATION = new GameConfiguration('Orientation', smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(8));
        this.SENSOR_UPDATE_RATE = new GameConfiguration('Sensor Update Rate', smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(3));
        this.VIBRATION = new GameConfiguration('Vibration', smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(3));
        this.CHALLENGE_LEVEL = new GameConfiguration('Global Challenge Level', smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        this.COLLIDE_DAMAGE = new GameConfiguration('Collide Damage Challenge Level', smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        this.DURABILITY_CHALLENGE_LEVEL = new GameConfiguration('Enemy Durability Challenge Level', smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        this.SPEED_CHALLENGE_LEVEL = new GameConfiguration('Enemy Speed Challenge Level', smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        this.ATTACK_CHALLENGE_LEVEL = new GameConfiguration('Enemy Attack Challenge Level', smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        this.CONTROL_LEVEL = new GameConfiguration('Control Fidelity', smallIntegerSingletonFactory.getAt(5), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        this.PLAYER_INPUT_WAIT = new GameConfiguration('Input Wait', smallIntegerSingletonFactory.getAt(5), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        // enemy activity level
        this.SPEED = new GameConfiguration('Game Speed (Device Specific)', smallIntegerSingletonFactory.getAt(5), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10));
        // GameConfiguration(smallIntegerSingletonFactory.getInstance(0));
        this.SOUND_VOLUME = new GameConfiguration('Sound Volume', smallIntegerSingletonFactory.getAt(6), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(10));
        this.MAX_GAME_OBJECTS = new GameConfiguration('Max Game Objects', smallIntegerSingletonFactory.getAt(20), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(50));
        this.MAX_LAYERS = new GameConfiguration('Max Layers', smallIntegerSingletonFactory.getAt(20), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(50));
    }

    public void load(final AbeClientInformationInterface abeClientInformation) {
        final CommonStrings commonStrings = CommonStrings.getInstance();
        try {
            final SmallIntegerSingletonFactory smallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance();
            final KeyValuePersistance keyValuePersistance = GameConfigurationPersistanceSingleton.getInstance();
            keyValuePersistance.clear();
            keyValuePersistance.loadAll(abeClientInformation);
            final BasicArrayList list = keyValuePersistance.getIds();
            if (list.size() > 0) {
                final ABHashtable<Object, Object> hashtable = keyValuePersistance.get(0);
                final Object anyType = ((Object) this.SCALE.getName());
                final String value = ((String) hashtable.get(anyType));
                this.SCALE.setValue(smallIntegerSingletonFactory.getAt(Integer.valueOf(value).intValue()));
            } else {
                this.logUtil.putF('No Game Configuration To Load', this, commonStrings.@LOAD);
            }
        } catch (Exception e) {
            this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@LOAD, e);
        }
    }

    public void setGameControlFidelity(final int gameControlFidelity) {
        this.gameControlFidelity = gameControlFidelity;
    }

    public int getGameControlFidelity() {
        //(FIDELITY[fidelity + 1]);
        return this.gameControlFidelity;
    }

    public String toString() {
        final StringMaker stringBuffer = new StringMaker();
        final CommonSeps commonStrings = CommonSeps.getInstance();
        // stringBuffer.append(this.INPUT_WAIT.getValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.SCALE.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.SCALE.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.ORIENTATION.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.ORIENTATION.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.SENSOR_UPDATE_RATE.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.SENSOR_UPDATE_RATE.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.VIBRATION.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.VIBRATION.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.CHALLENGE_LEVEL.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.CHALLENGE_LEVEL.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.COLLIDE_DAMAGE.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.COLLIDE_DAMAGE.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.DURABILITY_CHALLENGE_LEVEL.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.DURABILITY_CHALLENGE_LEVEL.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.SPEED_CHALLENGE_LEVEL.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.SPEED_CHALLENGE_LEVEL.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.ATTACK_CHALLENGE_LEVEL.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.ATTACK_CHALLENGE_LEVEL.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.CONTROL_LEVEL.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.CONTROL_LEVEL.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.SPEED.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.SPEED.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.MAX_GAME_OBJECTS.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.MAX_GAME_OBJECTS.getValue().intValue());
        stringBuffer.append(commonStrings.@COMMA_SEP);
        stringBuffer.append(this.MAX_LAYERS.getName());
        stringBuffer.append(commonStrings.@EQUALS);
        stringBuffer.appendint(this.MAX_LAYERS.getValue().intValue());
        // stringBuffer.append(this.SOUND_VOLUME.getValue());
        return stringBuffer.toString();
    }

}


