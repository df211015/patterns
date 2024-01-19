package com.dfliu.patterns.service.servant;

/**
 * 雇工模式,命令模式的简化版本
 */
public class Servant {
    public void service(IServiced serviced) {
        serviced.serviced();
    }
}