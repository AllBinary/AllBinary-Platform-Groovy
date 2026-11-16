/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item.validation;

import org.allbinary.logic.java.bool.BooleanFactory;
import org.allbinary.logic.util.visitor.Visitor;

@groovy.transform.CompileStatic
public class TextItemVisitor extends Visitor {
    public TextItemVisitor() {
    }

    @Override
    public Object visit(final Object anyType) {
        final String value = ((String) anyType);
        if (value.length() < 2) {
            return BooleanFactory.getInstance().@TRUE;
        } else {
            return BooleanFactory.getInstance().@FALSE;
        }
    }

}


