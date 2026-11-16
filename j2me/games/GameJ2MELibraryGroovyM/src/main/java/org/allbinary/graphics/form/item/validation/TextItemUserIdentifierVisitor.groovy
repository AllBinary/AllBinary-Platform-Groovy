/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item.validation;

import org.allbinary.game.input.TextNotificationUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.java.bool.BooleanFactory;
import org.allbinary.logic.string.StringValidationUtil;
import org.allbinary.logic.util.visitor.Visitor;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class TextItemUserIdentifierVisitor extends Visitor {
    protected final LogUtil logUtil = LogUtil.getInstance();

    public TextItemUserIdentifierVisitor() {
    }

    @Override
    public Object visit(Object anyType) {
        String value = ((String) anyType);
        if (value.length() < 2) {
            char charValue = value.charAt(0);
            final StringValidationUtil stringValidationUtil = StringValidationUtil.getInstance();
            if (stringValidationUtil.isNumber(value)) {
                return BooleanFactory.getInstance().@TRUE;
            } else if (this.isLetter(charValue)) {
                return BooleanFactory.getInstance().@TRUE;
            } else {
                try {
                    TextNotificationUtil.getInstance().fireError('Only Letters & Numbers Allowed');
                } catch (Exception e) {
                    final CommonStrings commonStrings = CommonStrings.getInstance();
                    this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@VISIT, e);
                }
                return BooleanFactory.getInstance().@FALSE;
            }
        } else {
            return BooleanFactory.getInstance().@FALSE;
        }
    }

    public boolean isLetter(char charValue) {
        final int value = ((int) charValue);
        return (value > 64 && value < 91) || (value > 96 && value < 123);
    }

}


