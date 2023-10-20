package com.dfliu.patterns.service.factory.simpleFactory;

import com.dfliu.patterns.domain.dto.CheesePizza;
import com.dfliu.patterns.domain.dto.GreekPizza;
import com.dfliu.patterns.domain.dto.PepperPizza;
import com.dfliu.patterns.domain.dto.Pizza;
import org.apache.commons.lang3.StringUtils;

public class SimplePizzaFactory {
    public static Pizza getInstanceOfPizza(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }

        switch (type) {
            case "cheese":
                return new CheesePizza("cheese");
            case "greek":
                return new GreekPizza("greek");
            case "pepper":
                return new PepperPizza("pepper");
        }

        return null;
    }
}
