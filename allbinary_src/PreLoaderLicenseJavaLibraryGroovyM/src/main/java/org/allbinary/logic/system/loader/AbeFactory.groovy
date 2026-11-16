/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.loader;

import java.lang.reflect.Constructor;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.java.anyType.ConstructorUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.system.security.AbKeys;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.logic.system.security.licensing.LicensingException;
import org.allbinary.string.CommonSeps;

@groovy.transform.CompileStatic
public class AbeFactory {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final AbeFactory instance = new AbeFactory();

    public static AbeFactory getInstance() {
        return AbeFactory.instance;
    }

    private boolean useCustomLoader = false;

    private AbeFactory() {
    }

    public synchronized Object getInstance(final AbeClientInformationInterface abeClientInformation, final String className) throws LicensingException {
        try {
            /*          AbKeysInterface abKeysInterface =              AbeFactory.getInstance().getNoLicenseInstance(SECURITYKEYSCLASSPATH);          String key = abKeysInterface.getKey(className);          */
            return this.getClass(abeClientInformation, className).newInstance();
        } catch (LicensingException e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@LOADERERROR)) {
                this.logUtil.put('Failure for: ' + className, this, 'getInstance(classname)', e);
            }
            throw e;
        } catch (Exception e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@LOADERERROR)) {
                this.logUtil.put('Failure for: ' + className, this, 'getInstance(classname)', e);
            }
            return null;
        }
    }

    public synchronized Object getInstance(final AbeClientInformationInterface abeClientInformation, String className, Class[] classes, Object[] params) throws LicensingException {
        Constructor constructor = null;
        try {
            /*          AbKeysInterface abKeysInterface =              AbeFactory.getInstance().getNoLicenseInstance(SECURITYKEYSCLASSPATH);          String key = abKeysInterface.getKey(className);          */
            ClassLoader parent = WebappClassLoaderInfo.getLoader();
            //ClassLoader parent = new Object().getClass().getClassLoader();
            if (this.useCustomLoader) {
                ClassLoader loader = new AbeClassLoader(parent, AbKeys.getInstance().getKey(abeClientInformation, className));
                Class myClass = loader.loadClass(className);
                constructor = myClass.getConstructor(classes);
                return constructor.newInstance(params);
            } else {
                Class myClass = parent.loadClass(className);
                constructor = myClass.getConstructor(classes);
                return constructor.newInstance(params);
            }
        } catch (LicensingException e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@LOADERERROR)) {
                StringMaker stringBuffer = new StringMaker();
                stringBuffer.append('Failure for: ');
                stringBuffer.append(className);
                stringBuffer.append(CommonSeps.getInstance().@SPACE);
                stringBuffer.append(ConstructorUtil.view(constructor, CommonSeps.getInstance().@NEW_LINE));
                this.logUtil.put(stringBuffer.toString(), this, 'getInstance(className,params)', e);
            }
            throw e;
        } catch (Exception e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@LOADERERROR)) {
                StringMaker stringBuffer = new StringMaker();
                stringBuffer.append('Failure for: ');
                stringBuffer.append(className);
                stringBuffer.append(CommonSeps.getInstance().@SPACE);
                stringBuffer.append(ConstructorUtil.view(constructor, CommonSeps.getInstance().@NEW_LINE));
                this.logUtil.put(stringBuffer.toString(), this, 'getInstance(className,params)', e);
            }
            return null;
        }
    }

    /*    public synchronized static Class loadClassesFromJar(JarFile jarFile)        throws LicensingException    {       try       {          ClassLoader parent = WebappClassLoaderInfo.getLoader();          //ClassLoader parent = new Object().getClass().getClassLoader();                    if(useCustomLoader)          {             AbeClassLoader abeClassLoader =                 new AbeClassLoader(parent, AbKeys.getKey(className));             Class c = loaderloadClass(className);             return c;          }          else          {             Class c = parent.loadClass(className);             return c;          }       }       catch (LicensingException e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADERERROR))          {             this.logUtil.put("Failure for: " + className, this,"getClass(className)", e);          }          throw e;       }       catch (Exception e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADERERROR))          {             this.logUtil.put("Failure for: " + className, this,"getClass(className)", e);          }          return null;       }    }      */
    public synchronized Class getClass(final AbeClientInformationInterface abeClientInformation, final String className) throws LicensingException {
        try {
            ClassLoader parent = WebappClassLoaderInfo.getLoader();
            //ClassLoader parent = new Object().getClass().getClassLoader();
            if (this.useCustomLoader) {
                ClassLoader loader = new AbeClassLoader(parent, AbKeys.getInstance().getKey(abeClientInformation, className));
                Class c = loader.loadClass(className);
                return c;
            } else {
                Class c = parent.loadClass(className);
                return c;
            }
        } catch (LicensingException e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@LOADERERROR)) {
                this.logUtil.put('Failure for: ' + className, this, 'getClass(className)', e);
            }
            throw e;
        } catch (Exception e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@LOADERERROR)) {
                this.logUtil.put('Failure for: ' + className, this, 'getClass(className)', e);
            }
            return null;
        }
    }

}


