/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature;

import javax.microedition.lcdui.Canvas;
import org.allbinary.game.commands.GameCommandsFactory;

@groovy.transform.CompileStatic
public class MultiPlayerGameFeatureFactory {
    private static final MultiPlayerGameFeatureFactory instance = new MultiPlayerGameFeatureFactory();

    public static MultiPlayerGameFeatureFactory getInstance() {
        return MultiPlayerGameFeatureFactory.instance;
    }

    private MultiPlayerGameFeatureFactory() {
    }

    //final Canvas canvas
    public void addCommands(final Object anyType) {
        final GameCommandsFactory gameCommandsFactory = GameCommandsFactory.getInstance();
        final Canvas canvas = ((Canvas) anyType);
        canvas.addCommand(gameCommandsFactory.@QUIT_COMMAND);
    }

}


