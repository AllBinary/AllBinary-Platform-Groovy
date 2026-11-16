/* Generated Code Do Not Modify */
package org.allbinary.game.input;

import org.allbinary.logic.string.StringUtil;

@groovy.transform.CompileStatic
public class AndroidGameKey extends Input {
    AndroidGameKey(int keyCode, String name) {
        super(keyCode, name);
        final InputFactory inputFactory = InputFactory.getInstance();
        inputFactory.@inputIntegerArray[this.getId()] = this;
    }

    public String toString() {
        return 'AndroidGameKey: ' + super.toString();
    }

    public static String getString(int keyCode) {
        Input input = InputFactory.getInstance().getInstanceById(keyCode);
        if (input != null) {
            return input.getName();
        } else {
            return StringUtil.getInstance().@EMPTY_STRING;
        }
    }

}


