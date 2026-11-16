/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.gyro;

import org.allbinary.canvas.Processor;

@groovy.transform.CompileStatic
public class SingleSensorGameUpdateProcessor extends SensorGameUpdateProcessor {
    private final Processor accelerometerSensorUpdateProcessor = new AccelerometerSensorUpdateProcessor();

    private final Processor gyroSensorUpdateProcessor = new GyroSensorUpdateProcessor();

    public void process(Object anyType) throws Exception {
        /*         GameType gameType = layerManager.getGameInfo().getGameType();          AllBinarySensorManager sensorManager =              AllBinarySensorManager.getInstance();          SensorFeatureFactory sensorFeatureFactory =              SensorFeatureFactory.getInstance();          sensorManager.shutdown();          //At some point I will probably want sensor input for the main menu and or demo screen         if (gameType == GameType.BOT)         {             this.setNoSensors();         }         else              if (Features.getInstance().isFeature(sensorFeatureFactory.NO_ORIENTATION))             {                 this.setNoSensors();             }             else          {                 AllBinarySensorManager.getInstance().init();                  /*                 BasicArrayList list =                      sensorManager.getRegisteredSensorNamesList();                  if (list.contains(sensorManager.SENSOR_ACCELEROMETER))                 {                     this.accelerometerSensorUpdateProcessor.process();                      GyroSensorFactory.getInstance().setListener(                             NoCompleteMotionGestureInputEventListener.getInstance());                      this.setInputSensor(AccelerometerSensorFactory.getInstance());                 }                 else if (list.contains(sensorManager.SENSOR_ORIENTATION))                 {                 this.gyroSensorUpdateProcessor.process();                  AccelerometerSensorFactory.getInstance().setListener(                         NoCompleteMotionGestureInputEventListener.getInstance());                  this.setInputSensor(GyroSensorFactory.getInstance());             }             else             {                 // Could not find appropriate sensor                 this.setNoSensors();             }                  */
        this.setNoSensors();
    }

    public void sendNotifications(Object anyType) throws Exception {
    }

}


