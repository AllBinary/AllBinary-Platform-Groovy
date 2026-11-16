/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas;

import org.allbinary.game.input.GameKeyFactory;
import org.allbinary.game.input.PlayerGameInput;
import org.allbinary.game.input.event.GameKeyEvent;
import org.allbinary.game.input.event.GameKeyEventUtil;
import org.allbinary.game.layer.AllBinaryGameLayerManager;
import org.allbinary.game.layer.special.SpecialGameInputFactory;
import org.allbinary.game.layer.special.SpecialGameInputInterface;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;

@groovy.transform.CompileStatic
public class CheatGameInputProcessor extends PlayerGameInput {
    private final String PROCESS_GAME = 'processGame';

    private final AllBinaryGameCanvas gameCanvas;

    public static SpecialGameInputInterface inputProcessor = SpecialGameInputFactory.NO_SPECIAL_GAME_INPUT;

    public CheatGameInputProcessor(AllBinaryGameCanvas gameCanvas) {
        super(new BasicArrayListD(), new BasicArrayListD(), -1);
        this.gameCanvas = gameCanvas;
    }

    private final GameKeyFactory gameKeyFactory = GameKeyFactory.getInstance();

    //    public static int z;
    @Override
    public synchronized void update() {
        try {
            final AllBinaryGameLayerManager gameLayerManager = this.gameCanvas.getLayerManager();
            final BasicArrayList list = this.getGameKeyEventList();
            final int size = list.size();
            for (int index = 0; index < size; index++) {
                final Object anyType = list.@objectArray[index];
                final int key = GameKeyEventUtil.getKey(anyType);
                if (key == this.gameKeyFactory.@LEVEL_DOWN.getId()) {
                    CheatGameInputProcessor.inputProcessor.strafeLeft();
                    //this.gameCanvas.buildGame(true);
                    break;
                } else if (key == this.gameKeyFactory.@LEVEL_UP.getId()) {
                    CheatGameInputProcessor.inputProcessor.strafeRight();
                    //this.gameCanvas.buildGame(true);
                    break;
                }
                if (key == this.gameKeyFactory.@LEFT.getId()) {
                    CheatGameInputProcessor.inputProcessor.left();
                    //                    this.logUtil.putF(new StringMaker().append("x: ").append(x).toString(), this, PROCESS_GAME);
                    break;
                } else if (key == this.gameKeyFactory.@RIGHT.getId()) {
                    CheatGameInputProcessor.inputProcessor.right();
                    //                    this.logUtil.putF(new StringMaker().append("x: ").append(x).toString(), this, PROCESS_GAME);
                    break;
                } else if (key == this.gameKeyFactory.@UP.getId()) {
                    CheatGameInputProcessor.inputProcessor.up();
                    //                    this.logUtil.putF(new StringMaker().append("y: ").append(y).toString(), this, PROCESS_GAME);   
                    break;
                } else if (key == this.gameKeyFactory.@DOWN.getId()) {
                    CheatGameInputProcessor.inputProcessor.down();
                    //                    this.logUtil.putF(new StringMaker().append("y: ").append(y).toString(), this, PROCESS_GAME);
                    break;
                } else if (key == this.gameKeyFactory.@KEY_NUM1.getId()) {
                    CheatGameInputProcessor.inputProcessor.special1(gameLayerManager, GameKeyEvent.NONE);
                    //                    this.logUtil.putF(new StringMaker().append("z: ").append(z).toString(), this, PROCESS_GAME);
                    break;
                } else if (key == this.gameKeyFactory.@KEY_NUM3.getId()) {
                    CheatGameInputProcessor.inputProcessor.special2(gameLayerManager, GameKeyEvent.NONE);
                    //                    this.logUtil.putF(new StringMaker().append("z: ").append(z).toString(), this, PROCESS_GAME);
                    break;
                }
            }
            list.clear();
        } catch (Exception e) {
            this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.commonStrings.@UPDATE, e);
        }
    }

}


