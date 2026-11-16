/* Generated Code Do Not Modify */
package org.allbinary.game.input;

import android.view.KeyEvent;
import org.allbinary.android.ActivityFractureUtil;
import org.allbinary.string.CommonPhoneStrings;
import org.allbinary.logic.io.path.AbPathData;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogUtil;

@groovy.transform.CompileStatic
public class AndroidKeyFactory extends ActivityFractureUtil {
    protected final LogUtil logUtil = LogUtil.getInstance();

    public final AndroidGameKey UNKNOWN = new AndroidGameKey(KeyEvent.KEYCODE_UNKNOWN, 'UNKNOWN');

    /*      * API 9 Game Input   */
    public AndroidGameKey KEYCODE_BUTTON_L1 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_R1 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_THUMBR = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_THUMBL = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_START = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_MODE = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_B = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_A = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_X = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_Y = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_L2 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_R2 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_SELECT = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_C = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_Z = this.UNKNOWN;

    /*       * API 12 Game Input   */
    public AndroidGameKey KEYCODE_BUTTON_1 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_10 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_11 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_12 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_13 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_14 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_15 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_16 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_2 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_3 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_4 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_5 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_6 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_7 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_8 = this.UNKNOWN;

    public AndroidGameKey KEYCODE_BUTTON_9 = this.UNKNOWN;

    public final AndroidGameKey SOFT_LEFT = new AndroidGameKey(KeyEvent.KEYCODE_SOFT_LEFT, 'SOFT_LEFT');

    public final AndroidGameKey SOFT_RIGHT = new AndroidGameKey(KeyEvent.KEYCODE_SOFT_RIGHT, 'SOFT_RIGHT');

    public final AndroidGameKey HOME = new AndroidGameKey(KeyEvent.KEYCODE_HOME, 'HOME');

    public final AndroidGameKey BACK = new AndroidGameKey(KeyEvent.KEYCODE_BACK, 'BACK');

    public final AndroidGameKey CALL = new AndroidGameKey(KeyEvent.KEYCODE_CALL, 'CALL');

    public final AndroidGameKey ENDCALL = new AndroidGameKey(KeyEvent.KEYCODE_ENDCALL, 'ENDCALL');

    public final AndroidGameKey ZERO = new AndroidGameKey(KeyEvent.KEYCODE_0, CommonPhoneStrings.getInstance().@ZERO);

    public final AndroidGameKey ONE = new AndroidGameKey(KeyEvent.KEYCODE_1, CommonPhoneStrings.getInstance().@ONE);

    public final AndroidGameKey TWO = new AndroidGameKey(KeyEvent.KEYCODE_2, CommonPhoneStrings.getInstance().@TWO);

    public final AndroidGameKey THREE = new AndroidGameKey(KeyEvent.KEYCODE_3, CommonPhoneStrings.getInstance().@THREE);

    public final AndroidGameKey FOUR = new AndroidGameKey(KeyEvent.KEYCODE_4, CommonPhoneStrings.getInstance().@FOUR);

    public final AndroidGameKey FIVE = new AndroidGameKey(KeyEvent.KEYCODE_5, CommonPhoneStrings.getInstance().@FIVE);

    public final AndroidGameKey SIX = new AndroidGameKey(KeyEvent.KEYCODE_6, CommonPhoneStrings.getInstance().@SIX);

    public final AndroidGameKey SEVEN = new AndroidGameKey(KeyEvent.KEYCODE_7, CommonPhoneStrings.getInstance().@SEVEN);

    public final AndroidGameKey EIGHT = new AndroidGameKey(KeyEvent.KEYCODE_8, CommonPhoneStrings.getInstance().@EIGHT);

    public final AndroidGameKey NINE = new AndroidGameKey(KeyEvent.KEYCODE_9, CommonPhoneStrings.getInstance().@NINE);

    public final AndroidGameKey STAR = new AndroidGameKey(KeyEvent.KEYCODE_STAR, CommonPhoneStrings.getInstance().@STAR);

    public final AndroidGameKey POUND = new AndroidGameKey(KeyEvent.KEYCODE_POUND, CommonPhoneStrings.getInstance().@POUND);

    public final AndroidGameKey DPAD_UP = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_UP, 'UP');

    public final AndroidGameKey DPAD_DOWN = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_DOWN, 'DOWN');

    public final AndroidGameKey DPAD_LEFT = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_LEFT, 'LEFT');

    public final AndroidGameKey DPAD_RIGHT = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_RIGHT, 'RIGHT');

    public final AndroidGameKey DPAD_CENTER = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_CENTER, 'CENTER');

    public final AndroidGameKey VOLUME_UP = new AndroidGameKey(KeyEvent.KEYCODE_VOLUME_UP, 'VOLUME_UP');

    public final AndroidGameKey VOLUME_DOWN = new AndroidGameKey(KeyEvent.KEYCODE_VOLUME_DOWN, 'VOLUME_DOWN');

    public final AndroidGameKey POWER = new AndroidGameKey(KeyEvent.KEYCODE_POWER, 'POWER');

    public final AndroidGameKey CAMERA = new AndroidGameKey(KeyEvent.KEYCODE_CAMERA, 'CAMERA');

    public final AndroidGameKey CLEAR = new AndroidGameKey(KeyEvent.KEYCODE_CLEAR, 'CLEAR');

    public final AndroidGameKey A = new AndroidGameKey(KeyEvent.KEYCODE_A, 'A');

    public final AndroidGameKey B = new AndroidGameKey(KeyEvent.KEYCODE_B, 'B');

    public final AndroidGameKey C = new AndroidGameKey(KeyEvent.KEYCODE_C, 'C');

    public final AndroidGameKey D = new AndroidGameKey(KeyEvent.KEYCODE_D, 'D');

    public final AndroidGameKey E = new AndroidGameKey(KeyEvent.KEYCODE_E, 'E');

    public final AndroidGameKey F = new AndroidGameKey(KeyEvent.KEYCODE_F, 'F');

    public final AndroidGameKey G = new AndroidGameKey(KeyEvent.KEYCODE_G, 'G');

    public final AndroidGameKey H = new AndroidGameKey(KeyEvent.KEYCODE_H, 'H');

    public final AndroidGameKey I = new AndroidGameKey(KeyEvent.KEYCODE_I, 'I');

    public final AndroidGameKey J = new AndroidGameKey(KeyEvent.KEYCODE_J, 'J');

    public final AndroidGameKey K = new AndroidGameKey(KeyEvent.KEYCODE_K, 'K');

    public final AndroidGameKey L = new AndroidGameKey(KeyEvent.KEYCODE_L, 'L');

    public final AndroidGameKey M = new AndroidGameKey(KeyEvent.KEYCODE_M, 'M');

    public final AndroidGameKey N = new AndroidGameKey(KeyEvent.KEYCODE_N, 'N');

    public final AndroidGameKey O = new AndroidGameKey(KeyEvent.KEYCODE_O, 'O');

    public final AndroidGameKey P = new AndroidGameKey(KeyEvent.KEYCODE_P, 'P');

    public final AndroidGameKey Q = new AndroidGameKey(KeyEvent.KEYCODE_Q, 'Q');

    public final AndroidGameKey R = new AndroidGameKey(KeyEvent.KEYCODE_R, 'R');

    public final AndroidGameKey S = new AndroidGameKey(KeyEvent.KEYCODE_S, 'S');

    public final AndroidGameKey T = new AndroidGameKey(KeyEvent.KEYCODE_T, 'T');

    public final AndroidGameKey U = new AndroidGameKey(KeyEvent.KEYCODE_U, 'U');

    public final AndroidGameKey V = new AndroidGameKey(KeyEvent.KEYCODE_V, 'V');

    public final AndroidGameKey W = new AndroidGameKey(KeyEvent.KEYCODE_W, 'W');

    public final AndroidGameKey X = new AndroidGameKey(KeyEvent.KEYCODE_X, 'X');

    public final AndroidGameKey Y = new AndroidGameKey(KeyEvent.KEYCODE_Y, 'Y');

    public final AndroidGameKey Z = new AndroidGameKey(KeyEvent.KEYCODE_Z, 'Z');

    public final AndroidGameKey COMMA = new AndroidGameKey(KeyEvent.KEYCODE_COMMA, 'COMMA');

    public final AndroidGameKey PERIOD = new AndroidGameKey(KeyEvent.KEYCODE_PERIOD, AbPathData.getInstance().@EXTENSION_SEP);

    public final AndroidGameKey ALT_LEFT = new AndroidGameKey(KeyEvent.KEYCODE_ALT_LEFT, 'ALT_LEFT');

    public final AndroidGameKey ALT_RIGHT = new AndroidGameKey(KeyEvent.KEYCODE_ALT_RIGHT, 'ALT_RIGHT');

    public final AndroidGameKey SHIFT_LEFT = new AndroidGameKey(KeyEvent.KEYCODE_SHIFT_LEFT, 'SHIFT_LEFT');

    public final AndroidGameKey SHIFT_RIGHT = new AndroidGameKey(KeyEvent.KEYCODE_SHIFT_RIGHT, 'SHIFT_RIGHT');

    public final AndroidGameKey TAB = new AndroidGameKey(KeyEvent.KEYCODE_TAB, 'TAB');

    public final AndroidGameKey SPACE = new AndroidGameKey(KeyEvent.KEYCODE_SPACE, 'SPACE');

    public final AndroidGameKey SYM = new AndroidGameKey(KeyEvent.KEYCODE_SYM, 'SYM');

    public final AndroidGameKey EXPLORER = new AndroidGameKey(KeyEvent.KEYCODE_EXPLORER, 'EXPLORER');

    public final AndroidGameKey ENVELOPE = new AndroidGameKey(KeyEvent.KEYCODE_ENVELOPE, 'ENVELOPE');

    public final AndroidGameKey ENTER = new AndroidGameKey(KeyEvent.KEYCODE_ENTER, 'ENTER');

    public final AndroidGameKey DEL = new AndroidGameKey(KeyEvent.KEYCODE_DEL, 'DEL');

    public final AndroidGameKey GRAVE = new AndroidGameKey(KeyEvent.KEYCODE_GRAVE, 'GRAVE');

    public final AndroidGameKey MINUS = new AndroidGameKey(KeyEvent.KEYCODE_MINUS, 'MINUS');

    public final AndroidGameKey EQUALS = new AndroidGameKey(KeyEvent.KEYCODE_EQUALS, 'EQUALS');

    public final AndroidGameKey LEFT_BRACKET = new AndroidGameKey(KeyEvent.KEYCODE_LEFT_BRACKET, 'LEFT_BRACKET');

    public final AndroidGameKey RIGHT_BRACKET = new AndroidGameKey(KeyEvent.KEYCODE_RIGHT_BRACKET, 'RIGHT_BRACKET');

    public final AndroidGameKey BACKSLASH = new AndroidGameKey(KeyEvent.KEYCODE_BACKSLASH, 'BACKSLASH');

    public final AndroidGameKey SEMICOLON = new AndroidGameKey(KeyEvent.KEYCODE_SEMICOLON, 'SEMICOLON');

    public final AndroidGameKey APOSTROPHE = new AndroidGameKey(KeyEvent.KEYCODE_APOSTROPHE, 'APOSTROPHE');

    public final AndroidGameKey SLASH = new AndroidGameKey(KeyEvent.KEYCODE_SLASH, 'SLASH');

    public final AndroidGameKey AT = new AndroidGameKey(KeyEvent.KEYCODE_AT, 'AT');

    public final AndroidGameKey NUM = new AndroidGameKey(KeyEvent.KEYCODE_NUM, 'NUM');

    public final AndroidGameKey HEADSETHOOK = new AndroidGameKey(KeyEvent.KEYCODE_HEADSETHOOK, 'HEADSETHOOK');

    public final AndroidGameKey FOCUS = new AndroidGameKey(KeyEvent.KEYCODE_FOCUS, 'FOCUS');

    public final AndroidGameKey PLUS = new AndroidGameKey(KeyEvent.KEYCODE_PLUS, 'PLUS');

    public final AndroidGameKey MENU = new AndroidGameKey(KeyEvent.KEYCODE_MENU, 'MENU');

    public final AndroidGameKey NOTIFICATION = new AndroidGameKey(KeyEvent.KEYCODE_NOTIFICATION, 'NOTIFICATION');

    public final AndroidGameKey SEARCH = new AndroidGameKey(KeyEvent.KEYCODE_SEARCH, 'SEARCH');

    public void init() {
        final CommonStrings commonStrings = CommonStrings.getInstance();
        this.logUtil.putF('Start/End', this, commonStrings.@INIT);
    }

    public boolean isSubmission(Input input) {
        if (input === this.ENTER) {
            return true;
        } else if (input === this.DPAD_CENTER) {
            return true;
        }
        return false;
    }

    public boolean isDelete(Input input) {
        return false;
    }

    //In android delete is backspace
    public boolean isBackSpace(Input input) {
        if (input === this.DEL) {
            return true;
        }
        return false;
    }

    public boolean isLeft(Input input) {
        if (input === this.DPAD_LEFT) {
            return true;
        }
        return false;
    }

    public boolean isRight(Input input) {
        if (input === this.DPAD_RIGHT) {
            return true;
        }
        return false;
    }

    public boolean isUp(Input input) {
        if (input === this.DPAD_UP) {
            return true;
        }
        return false;
    }

    public boolean isDown(Input input) {
        if (input === this.DPAD_DOWN) {
            return true;
        }
        return false;
    }

    public boolean isEnter(Input input) {
        if (input === this.DPAD_CENTER) {
            return true;
        } else if (input === this.ENTER) {
            return true;
        } else if (input === this.CALL) {
            return true;
        }
        return false;
    }

}


