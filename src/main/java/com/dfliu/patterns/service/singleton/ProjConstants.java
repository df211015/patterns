package com.dfliu.patterns.service.singleton;

public class ProjConstants {
    private static ProjConstants projConstants;

    private ProjConstants() {
    }

    public synchronized static ProjConstants getInstance() {
        if (null == projConstants) {
            projConstants = new ProjConstants();
        }

        return projConstants;
    }
}
