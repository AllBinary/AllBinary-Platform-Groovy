/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.content;

import javax.microedition.lcdui.Command;
import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.TsUtil;

@groovy.transform.CompileStatic
public class NotificationUtil {
    private static final NotificationUtil SINGLETON = new NotificationUtil();

    private NotificationManager notificationManager = ((NotificationManager) ResourceUtil.getInstance().getContext().getSystemService(Context.NOTIFICATION_SERVICE));

    public static NotificationUtil getInstance() {
        return NotificationUtil.SINGLETON;
    }

    public void notify(Command command, String resource, String message) {
        Context context = ResourceUtil.getInstance().getContext();
        Intent intent = CommandUriAction.getInstance().getIntent(command);
        /*             intent.putExtra( "data", "test data");        */
        Integer integer = ResourceUtil.getInstance().getResourceId(resource);
        Notification notification = new Notification(integer.intValue(), message, System.currentTimeMillis());
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        notification.setLatestEventInfo(context, command.getLabel(), message, pendingIntent);
        this.notificationManager.notify(TsUtil.getInstance().hashCode(command), notification);
    }

}


