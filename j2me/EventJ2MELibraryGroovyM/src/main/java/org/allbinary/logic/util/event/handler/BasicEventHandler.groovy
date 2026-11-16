/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event.handler;

import jsinterop.annotations.JsType;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.util.event.AllBinaryEventObject;
import org.allbinary.logic.util.event.EventListenerInterface;
import org.allbinary.logic.util.event.EventStrings;
import org.allbinary.string.CommonStrings;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;

@JsType
@groovy.transform.CompileStatic
public class BasicEventHandler implements BasicEventHandlerInterface {
    @JsProperty
    protected final LogUtil logUtil = LogUtil.getInstance();

    @JsProperty
    protected final CommonStrings commonStrings = CommonStrings.getInstance();

    private final EventStrings eventStrings = EventStrings.getInstance();

    @JsProperty
    protected BasicArrayList eventListenerInterfaceList;

    // private Condition condition = reentrantLock.newCondition();
    @JsConstructor
    public BasicEventHandler() {
        this.eventListenerInterfaceList = new BasicArrayListD();
    }

    @Override
    @JsMethod
    public void removeAllListeners() {
        this.eventListenerInterfaceList = new BasicArrayListD();
    }

    @Override
    @JsMethod
    public void addListeners(final BasicArrayList vector) {
        EventListenerInterface eventListenerInterface;
        final int size = vector.size();
        for (int index = 0; index < size; index++) {
            eventListenerInterface = ((EventListenerInterface) vector.get(index));
            this.addListenerInterface(eventListenerInterface);
        }
    }

    @JsMethod
    public void removeListeners(final BasicArrayList vector) {
        EventListenerInterface eventListenerInterface;
        final int size = vector.size();
        for (int index = 0; index < size; index++) {
            eventListenerInterface = ((EventListenerInterface) vector.get(index));
            this.removeListener(eventListenerInterface);
        }
    }

    @JsMethod
    public void addListenerSingleThreaded(final EventListenerInterface eventListenerInterface) {
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //this.logUtil.putF(CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface);
        }
    }

    @Override
    @JsMethod
    public void addListenerInterface(final EventListenerInterface eventListenerInterface) {
        // reentrantLock.isHeldByCurrentThread(), this, this.commonStrings.ADD_LISTENER);
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //this.logUtil.putF(CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface);
        }
    }

    @JsMethod
    public void removeListenerSingleThreaded(final EventListenerInterface eventListenerInterface) {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface);
    }

    @Override
    @JsMethod
    public void removeListener(final EventListenerInterface eventListenerInterface) {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface);
    }

    @Override
    @JsMethod
    public void fireEvent(final AllBinaryEventObject eventObject) throws Exception {
        // while(enumeration.hasMoreElements())
        EventListenerInterface eventListenerInterface;
        int index = 0;
        while (index < this.eventListenerInterfaceList.size()) {
            try {
                eventListenerInterface = ((EventListenerInterface) this.eventListenerInterfaceList.get(index));
                this.process(eventObject, eventListenerInterface);
            } catch (Exception e) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.eventStrings.@FIRE_EVENT, e);
            }
            index++;
        }
    }

    @JsMethod
    protected void process(final AllBinaryEventObject eventObject, final EventListenerInterface eventListenerInterface) throws Exception {
        // (BasicEventListenerInterface) eventListenerInterface;
        eventListenerInterface.onEvent(eventObject);
    }

    @JsMethod
    public BasicArrayList getEventListenerInterfaceListP() {
        return this.eventListenerInterfaceList;
    }

    @Override
    @JsMethod
    public String toString() {
        final StringMaker stringBuffer = new StringMaker();
        stringBuffer.append(this.eventStrings.@TOTAL_LISTENERS);
        stringBuffer.appendint(this.eventListenerInterfaceList.size());
        EventListenerInterface eventListenerInterface;
        int index = 0;
        while (index < this.eventListenerInterfaceList.size()) {
            try {
                eventListenerInterface = ((EventListenerInterface) this.eventListenerInterfaceList.get(index));
                stringBuffer.append(this.eventStrings.@LISTENER_LABEL);
                stringBuffer.append(eventListenerInterface.toString());
            } catch (Exception e) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.commonStrings.@TOSTRING, e);
            }
            index++;
        }
        return stringBuffer.toString();
    }

}


