package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Pair;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.binaryTree.BinaryTreeOfArr;
import com.dfliu.patterns.service.binaryTree.BinaryTreeOfLink;
import com.dfliu.patterns.service.hash.ArrayHashMap;
import com.dfliu.patterns.service.queue.ArrayDequeue;
import com.dfliu.patterns.service.queue.ArrayQueue;
import com.dfliu.patterns.service.queue.LinkDequeue;
import com.dfliu.patterns.service.queue.LinkQueue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/dataStruct")
public class DataStructController extends BaseContoller {

    /**
     * 数组模拟队列示例
     *
     * @return
     */
    @RequestMapping(value = "/getArrQueue")
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
    @RequestMapping(value = "/getLinkQueue")
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

    /**
     * 链表模拟双向队列示例
     *
     * @return
     */
    @RequestMapping(value = "/getLinkDequeue")
    public Result<String> getLinkDequeue() {
        LinkDequeue linkDequeue = new LinkDequeue();
        linkDequeue.push(1, true);
        linkDequeue.push(2, true);
        linkDequeue.push(3, true);
        linkDequeue.push(4, true);
        linkDequeue.push(5, true);

        Integer pop = linkDequeue.pop(true);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "链表模拟双向队列示例");
        return build;
    }

    /**
     * 数组模拟双向队列示例
     *
     * @return
     */
    @RequestMapping(value = "/getArrDequeue")
    public Result<String> getArrDequeue() {
        ArrayDequeue arrayDequeue = new ArrayDequeue(5);
        arrayDequeue.pushFirst(1);
        arrayDequeue.pushFirst(2);
        arrayDequeue.pushFirst(3);
        arrayDequeue.pushFirst(4);
        arrayDequeue.pushFirst(5);
        arrayDequeue.pushFirst(6);

        Integer v = arrayDequeue.popLast();
        arrayDequeue.pushFirst(6);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "数组模拟双向队列示例");
        return build;
    }

    /**
     * 数据模拟hashMap
     *
     * @return
     */
    @RequestMapping(value = "/getArrHashMap")
    public Result getArrHashMap() {
        ArrayHashMap arrHashMap = new ArrayHashMap(100);
        arrHashMap.put(new Pair(1, "aaa"));
        arrHashMap.put(new Pair(2, "bbb"));
        arrHashMap.put(new Pair(3, "ccc"));
        arrHashMap.put(new Pair(4, "ddd"));
        arrHashMap.put(new Pair(5, "eee"));

        Integer key = 4;
        String val = arrHashMap.get(key);
        System.out.println(String.format("key:%s,val:%s", key, val));

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "数组模拟双向队列示例");
        return build;
    }

    /**
     * 链表表示的二叉树
     *
     * @return
     */
    @RequestMapping(value = "showBinaryTreeOfLink")
    public Result<String> showBinaryTreeOfLink() {
        BinaryTreeOfLink binaryTreeOfLink = new BinaryTreeOfLink();
        binaryTreeOfLink.initTree();
        //二叉树的广度遍历
        binaryTreeOfLink.levelOrderTraversal(binaryTreeOfLink.getHead());

        //二叉树的深度遍历.前序
        binaryTreeOfLink.preOrderTraversal(binaryTreeOfLink.getHead());
        //二叉树的深度遍历.中序
        binaryTreeOfLink.midOrderTraversal(binaryTreeOfLink.getHead());
        //二叉树的深度遍历.后序
        binaryTreeOfLink.postOrderTraversal(binaryTreeOfLink.getHead());

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "链表表示的二叉树");
        return build;
    }

    /**
     * 数组表示的二叉树
     *
     * @return
     */
    @RequestMapping(value = "showBinaryTreeOfArr")
    public Result<String> showBinaryTreeOfArr() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1); //1,2
        arr.add(2); //3,4
        arr.add(3); //5,6
        arr.add(4); //7,8
        arr.add(5); //9,10
        arr.add(6); //11,12
        arr.add(7); //13,14
        arr.add(8); //15,16
        BinaryTreeOfArr<Integer> binaryTreeOfArr = new BinaryTreeOfArr<>(arr);
        //前序遍历
        binaryTreeOfArr.preOrderTraversal(0);
        System.out.println("---前序遍历结束-----------");
        //中序遍历
        binaryTreeOfArr.midOrderTraversal(0);
        System.out.println("---中序遍历结束-----------");
        //后序遍历
        binaryTreeOfArr.postOrderTraversal(0);
        System.out.println("---后序遍历结束-----------");

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "数组表示的二叉树");
        return build;
    }
}