package com.tove582700730.service;

import com.tove582700730.pojo.Types;

import java.util.ArrayList;

public class TestList {
    public static void main(String[] args) {
        Types types = new Types();
        types.setTname("嘻嘻");
        ArrayList<Types> list1 = new ArrayList<>();
        ArrayList<Types> list2 = new ArrayList<>();
        list1.add(types);
        list2.add(types);
        list1.get(0).setTname("哈哈");
        System.out.println(list1);
        System.out.println(list2);
    }
}
