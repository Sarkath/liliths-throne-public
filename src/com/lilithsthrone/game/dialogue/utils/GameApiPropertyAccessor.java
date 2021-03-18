package com.lilithsthrone.game.dialogue.utils;

import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypedValue;

public class GameApiPropertyAccessor implements PropertyAccessor {
    @Override
    public Class<?>[] getSpecificTargetClasses() {
        return new Class[0];
    }

    @Override
    public boolean canRead(EvaluationContext evaluationContext, Object target, String name) throws AccessException {
        return evaluationContext.lookupVariable(name) != null;
    }

    @Override
    public TypedValue read(EvaluationContext evaluationContext, Object target, String name) throws AccessException {
        return new TypedValue(evaluationContext.lookupVariable(name));
    }

    @Override
    public boolean canWrite(EvaluationContext evaluationContext, Object target, String name) throws AccessException {
        return true;
    }

    @Override
    public void write(EvaluationContext evaluationContext, Object target, String name, Object newValue) throws AccessException {
        evaluationContext.setVariable(name, newValue);
    }
}
