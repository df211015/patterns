package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.arrayQueue.ArrayQueue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dataStruct")
public class DataStructController extends BaseContoller {

    /**
     * 队列示例
     *
     * @return
     */
    @RequestMapping(value = "getQueue")
    public Result<String> getQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        //队列容量初始化
        arrayQueue.init(5);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(4);
        arrayQueue.push(5);
        //验证队列是否已满
        arrayQueue.push(6);
        Integer v = arrayQueue.pop();
        arrayQueue.push(8);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "队列示例");
        return build;
    }
}