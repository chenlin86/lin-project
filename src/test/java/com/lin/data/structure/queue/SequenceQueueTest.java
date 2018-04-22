package com.lin.data.structure.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SequenceQueueTest {

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        SequenceQueue<String> queue = new SequenceQueue<String>();
        // 依次将4个元素加入到队列中
        queue.add("aaaa");
        queue.add("bbbb");
        queue.add("cccc");
        queue.add("dddd");
        System.out.println(queue);
        System.out.println("访问队列的front端元素：" + queue.element());
        System.out.println("第一次弹出队列的front端元素：" + queue.remove());
        System.out.println("第二次弹出队列的front端元素：" + queue.remove());
        System.out.println("两次remove之后的队列：" + queue);
    }

}
