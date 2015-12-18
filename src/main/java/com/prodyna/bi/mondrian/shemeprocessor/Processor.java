package com.prodyna.bi.mondrian.shemeprocessor;

import mondrian.olap.Util;
import mondrian.spi.impl.FilterDynamicSchemaProcessor;
import org.pentaho.platform.api.engine.IPentahoSession;
import org.pentaho.platform.engine.core.system.PentahoSessionHolder;

import java.io.InputStream;

/**
 * TODO: Extend the description of the class
 *
 * @author Leonid Agranovskiy, PRODYNA AG
 * @date 18.12.15.
 */
public class Processor extends FilterDynamicSchemaProcessor {

    @Override
    protected String filter(String schemaUrl, Util.PropertyList connectInfo, InputStream stream) throws Exception {
        String retVal = super.filter(schemaUrl, connectInfo, stream);
        retVal = retVal.replace("%CURRENT_USER%", getUserName());
        return retVal;
    }


    private String getUserName() {
        IPentahoSession session = PentahoSessionHolder.getSession();
        return session.getName().toString();
    }
}
