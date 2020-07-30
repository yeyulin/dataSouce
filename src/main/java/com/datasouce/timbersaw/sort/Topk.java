package com.datasouce.timbersaw.sort;

import java.util.*;

/**
 * @author yeyulin
 * @description: 8
 * 1.输入数组的元素是输入数组中出现频率大于k次的元素
 * 2.输出数组需要按照元素出现频率的高低进行排序
 * @date 2020/7/29 17:26
 **/
public class Topk {
    public List<Integer> topKFrequent(int[] souces, int k) {
        //先统计出每个元素出现的频率
        HashMap<Integer, Integer> echoMap = new HashMap<>();
        int one = 1;
        for (int data : souces) {
            Integer num = echoMap.get(data);
            if (Objects.isNull(num)) {
                echoMap.put(data, one);
            } else {
                echoMap.put(data, num + one);
            }
        }
        //将次数当成下标构建成一个数组
        List[] frequenceList = new ArrayList[souces.length];
        for (Map.Entry<Integer, Integer> entry : echoMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            frequenceList[value] = new ArrayList();
            frequenceList[value].add(key);
        }
        //将已经按照次数存放的arryList倒序遍历，取出前K个里面包含的arryList
        List<Integer> result = new ArrayList<>();
        for (int i = frequenceList.length - 1; i > k; i--) {
            if (frequenceList[i] == null) {
                continue;
            }
            result.addAll(frequenceList[i]);

        }
        return result;
    }

    public List<Integer> topKFrequent2(int[] source, int k) {
        Map<Integer, Integer> echoMap = new HashMap<>();
        int one = 1;
        for (int i = 0; i < source.length; i++) {
            Integer integer = echoMap.get(source[i]);
            if (integer == null) {
                echoMap.put(source[i], one);
                continue;
            }
            echoMap.put(source[i], integer + one);
        }
        Set<Map.Entry<Integer,Integer>>set=echoMap.entrySet();
        List[]souList=new ArrayList[source.length];
        for (Map.Entry<Integer, Integer> entry : set) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            souList[value]=new ArrayList<>();
            souList[value].add(key);
        }
        List<Integer>resut=new ArrayList<>();
        for(int i=souList.length-1;i>k;i--){
            if(souList[i]==null){
                continue;
            }
            resut.addAll(souList[i]);
        }
        return resut;
    }

    public static void main(String[] args) {
        Topk topk = new Topk();
        List<Integer> integers = topk.topKFrequent2(new int[]{8, 8, 8, 8, 7, 7, 7, 2, 2}, 2);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
