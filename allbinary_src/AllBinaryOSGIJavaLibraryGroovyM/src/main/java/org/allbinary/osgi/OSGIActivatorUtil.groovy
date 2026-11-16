/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.osgi;

import org.allbinary.logic.StdUtil;
import org.allbinary.util.ABHashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.NullServiceReferenceFactory;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

@groovy.transform.CompileStatic
public class OSGIActivatorUtil {
    private OSGIActivatorUtil() {
    }

    public static void registerAsService(final BundleContext bundleContext, final Object anyType, final String serviceName) throws Exception {
        OSGIActivatorUtil.registerAsService(bundleContext, anyType, serviceName, StdUtil.getInstance().createHashtable());
    }

    public static void registerAsService(final BundleContext bundleContext, final Object anyType, final String serviceName, final ABHashtable<Object, Object> properties) throws Exception {
        final ServiceRegistration serviceRegistration = bundleContext.registerService(serviceName, anyType, properties);
        ServiceReference serviceReference = serviceRegistration.getReference();
        serviceReference = bundleContext.getServiceReference(serviceName);
        if (serviceReference === NullServiceReferenceFactory.getInstance().@NULL_SERVICE_REFERENCE) {
            throw new Exception('No Such Service Reference');
        }
    }

}


