package com.dfliu.patterns.service.interpreter;

import org.apache.commons.lang3.StringUtils;

public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (StringUtils.isNotBlank(context)) {
            return context.contains(this.data);
        }

        return false;
    }
}
