package com.datasouce.timbersaw.febonacheer;

/**
 * @author yeyulin
 * @description:
 * @date 2020/8/11 14:14
 * 递归和非递归方式实现斐波那契函数
 **/
public class Febonacheer {
    public Integer febonacheer(int num) {
        //边界值条件判断
        if (num <= 0) {
            throw new RuntimeException();
        }
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return febonacheer(num - 1) + febonacheer(num - 2);
        }
    }

    public Integer febonacheer2(Integer num) {
        //边界值条件判断
        if (num <= 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        int result = 0;
        int pre = 1;
        int ppre = 0;
        for (int i = 2; i <= num; i++) {
            result = pre + ppre;
            ppre = pre;
            pre = result;

        }
        return result;
    }

    public static void main(String[] args) {
        Febonacheer febonacheer = new Febonacheer();
        System.out.println(febonacheer.febonacheer(40));
        System.out.println(febonacheer.febonacheer2(40));
    }
}
