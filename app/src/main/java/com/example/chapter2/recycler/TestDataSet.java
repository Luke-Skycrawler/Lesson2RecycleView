package com.example.chapter2.recycler;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("游戏小助手", "好游戏","刚刚"));
        result.add(new TestData("林丹退役", "433.6w","昨天"));
        result.add(new TestData("投身乡村教育的燃灯者", "333.6w","13:01"));
        result.add(new TestData("暑期嘉年华", "285.6w","13:01"));
        result.add(new TestData("2020年三伏天有40天", "183.2w","13:01"));
        result.add(new TestData("会跟游客合照的老虎", "139.4w","13:01"));
        result.add(new TestData("苏州暴雨", "75.6w","13:01"));
        result.add(new TestData("6月全国菜价上涨", "55w","13:01"));
        result.add(new TestData("猫的第六感有多强", "43w","13:01"));
        result.add(new TestData("IU真好看", "22.2w","13:01"));
        return result;
    }

}
