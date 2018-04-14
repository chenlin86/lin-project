package com.lin.data.structure.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SequenceListTest {

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        SequenceList<String> list = new SequenceList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list.length());
        System.out.println(list.toString());
        System.out.println(list.get(1));
        System.out.println(list.toString());
        list.insert("eee", 1);
        System.out.println(list.toString());
        String rm = list.remove();
        System.out.println(rm);
        System.out.println(list.empty());
        list.clear();
        System.out.println(list.toString());

    }

}
