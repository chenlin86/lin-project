package com.lin.data.structure.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LinkQueueTest {

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        LinkQueue<String> queue = new LinkQueue<String>("aaaa");
        // 依次将4个元素加入到队列中
        queue.add("bbbb");
        queue.add("cccc");
        queue.add("dddd");
        System.out.println(queue);
        // 删除一个元素后
        queue.remove();
        System.out.println("删除一个元素后的队列：" + queue);
        // 再添加一个元素
        queue.add("eeee");
        System.out.println("再次添加元素后的队列：" + queue);
    }

}
