/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.score;

import org.allbinary.game.score.Scoreable;

@groovy.transform.CompileStatic
public class ScoreableAddOnlyForHud extends Scoreable {
    private final ScoreHudWidget scoreHudWidget;

    public ScoreableAddOnlyForHud(ScoreHudWidget scoreVectorGraphic) {
        super(0);
        this.scoreHudWidget = scoreVectorGraphic;
        this.getScoreHudWidget().set(0);
    }

    @Override
    public void removePoints(int points) {
    }

    @Override
    public void addPoints(int points) {
        super.addPoints(points);
        this.getScoreHudWidget().add(points);
    }

    public ScoreHudWidget getScoreHudWidget() {
        return this.scoreHudWidget;
    }

}


