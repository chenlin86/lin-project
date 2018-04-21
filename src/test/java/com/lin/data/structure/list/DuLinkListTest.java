package com.lin.data.structure.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DuLinkListTest {

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        DuLinkList<String> list = new DuLinkList<String>();
        list.insert("aaaa", 0);
        list.add("bbbb");
        list.insert("cccc", 0);
        // 在索引为1处插入一个新元素
        list.insert("dddd", 1);
        // 输出顺序线性表的元素
        System.out.println(list);
        // 删除索引为2处的元素
        list.delete(2);
        System.out.println(list);
        System.out.println(list.reverseToString());
        // 获取cccc字符串在线性双向链表中的位置
        System.out.println("cccc在线性双向链表中的位置：" + list.index("cccc"));
        System.out.println("线性双向链表中索引1处的元素：" + list.get(1));
        list.remove();
        System.out.println("调用remove方法后的线性双向链表：" + list);
        list.delete(0);
        System.out.println("调用delete(0)后的线性双向链表：" + list);
    }

}
