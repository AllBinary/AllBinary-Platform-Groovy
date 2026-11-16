/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.configuration;

import org.allbinary.input.automation.module.InputAutomationModuleFactoryInterface;
import org.allbinary.input.automation.module.configuration.InputAutomationModuleConfiguration;

@groovy.transform.CompileStatic
public class InputAutomationConfigurationUtil {
    private InputAutomationConfigurationUtil() {
    }

    public static InputAutomationConfigurationModuleChangeEvent getChangeEvent(InputAutomationModuleFactoryInterface inputAutomationModuleInterface) throws Exception {
        InputAutomationModuleConfiguration inputAutomationModuleConfiguration = new InputAutomationModuleConfiguration(inputAutomationModuleInterface);
        InputAutomationConfigurationModuleChangeEvent inputAutomationConfigurationModuleChangeEvent = new InputAutomationConfigurationModuleChangeEvent(inputAutomationModuleConfiguration);
        return inputAutomationConfigurationModuleChangeEvent;
    }

}


