package com.lin.data.structure.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LinkStackTest {

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        LinkStack<String> stack = new LinkStack<String>();
        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("cccc");
        stack.push("dddd");
        System.out.println(stack);
        System.out.println("访问栈顶元素：" + stack.peek());
        System.out.println("第一次弹出栈顶元素：" + stack.pop());
        System.out.println("第二次弹出栈顶元素：" + stack.pop());
        System.out.println("两次pop之后的栈：" + stack);
    }

}
