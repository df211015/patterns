package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.queue.ArrayQueue;
import com.dfliu.patterns.service.queue.LinkQueue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dataStruct")
public class DataStructController extends BaseContoller {

    /**
     * 数组模拟队列示例
     *
     * @return
     */
    @RequestMapping(value = "getArrQueue")
    public Result<String> getArrQueue() {
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

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "数组模拟队列示例");
        return build;
    }

    /**
     * 链表模拟队列示例
     *
     * @return
     */
    @RequestMapping(value = "getLinkQueue")
    public Result<String> getLinkQueue() {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.push(1);
        linkQueue.push(2);
        linkQueue.push(3);
        linkQueue.push(4);
        linkQueue.push(5);

        Integer pop0 = linkQueue.pop();
        Integer pop1 = linkQueue.pop();
        Integer pop2 = linkQueue.pop();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "链表模拟队列示例");
        return build;
    }
}