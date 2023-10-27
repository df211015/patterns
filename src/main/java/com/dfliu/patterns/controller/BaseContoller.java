package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;

public class BaseContoller {
    public <T> Result<T> buildReslt(ResultCode code, T t) {
        Result<T> build = Result.<T>builder()
                .code(code.code())
                .message(code.message())
                .data(t)
                .build();

        return build;
    }
}
