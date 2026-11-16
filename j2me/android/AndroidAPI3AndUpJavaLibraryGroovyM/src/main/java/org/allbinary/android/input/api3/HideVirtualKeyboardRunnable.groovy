/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.api3;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import org.allbinary.android.activity.ViewCompositeInterface;
import org.allbinary.logic.communication.log.ForcedLogUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class HideVirtualKeyboardRunnable implements Runnable {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private final Activity activity;

    public HideVirtualKeyboardRunnable(final Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        final CommonStrings commonStrings = CommonStrings.getInstance();
        try {
            final InputMethodManager inputMethodManager = ((InputMethodManager) this.activity.getSystemService(Context.INPUT_METHOD_SERVICE));
            final ViewCompositeInterface viewCompositeInterface = ((ViewCompositeInterface) this.activity);
            if (viewCompositeInterface == null) {
                ForcedLogUtil.log('Activity Null', this);
            }
            final View view = viewCompositeInterface.getView();
            if (view.getWindowToken() == null) {
                this.logUtil.putF('Unable to hide virtual keyboard as window token is null - This usually happens during loading when the view is not attached to a window', this, commonStrings.@RUN);
                return;
            }
            final IBinder token = view.getWindowToken();
            //InputMethodManager.HIDE_NOT_ALWAYS does not hide when SHOW_FORCED is used
            inputMethodManager.hideSoftInputFromWindow(token, 0);
        } catch (Exception e) {
            this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@RUN, e);
        }
    }

}


