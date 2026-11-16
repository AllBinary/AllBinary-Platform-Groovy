/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement;

import org.allbinary.game.GameAdState;
import org.allbinary.logic.system.SoftwareInformation;

@groovy.transform.CompileStatic
public class GameAdStateFactory implements GameAdStateFactoryInterface {
    private static final GameAdStateFactory instance = new GameAdStateFactory();

    public static GameAdStateFactory getInstance() {
        return GameAdStateFactory.instance;
    }

    private final GameAdState[] gameAdStateArray = new GameAdState[] {new GameAdState(new AppNameLicensingAdConfiguration())};

    private GameAdState gameAdState = this.gameAdStateArray[0];

    public GameAdState getCurrentInstance() {
        return this.gameAdState;
    }

    @Override
    public GameAdStateBase getInstanceForApp(final SoftwareInformation softwareInformation) throws Exception {
        //{
        this.gameAdState = this.gameAdStateArray[0];
        return this.gameAdStateArray[0];
    }

    public boolean isEnabled() {
        return false;
    }

}


