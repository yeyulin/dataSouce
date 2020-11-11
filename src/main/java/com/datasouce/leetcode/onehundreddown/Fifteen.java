package com.datasouce.leetcode.onehundreddown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yeyulin 2020-11-10
 *         15 三数之和
 */
public class Fifteen {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return Collections.emptyList();
        }
        Map<String, String> dins = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int tempi = nums[i];
            for (int j = i + 1; j < length; j++) {
                int tempj = nums[j];
                for (int k = i + 2; k < length; k++) {
                    int tempk = nums[k];
                    if (tempi + tempj + tempk == 0) {
                        //i !=j !=k
                        boolean equals = isEquals(i, j, k);
                        if (equals) {
                            continue;
                        }
                        //排序
                        List<Integer> sortList = new ArrayList<>();
                        sortList.add(tempi);
                        sortList.add(tempj);
                        sortList.add(tempk);
                        sortList.sort(Integer::compareTo);
                        builder.delete(0, builder.length());
                        String string = builder.append(sortList.get(0)).append(sortList.get(1)).append(sortList.get(2))
                                .toString();
                        String value = dins.get(string);
                        if (Objects.isNull(value)) {
                            dins.put(string, string);
                            result.add(sortList);
                        }
                    }
                }
            }
        }
        return result;
    }


    private boolean isEquals(int i, int j, int k) {
        if (i == j) {
            return true;
        }
        if (j == k) {
            return true;
        }
        return i == k;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            //因为nums义接排好序
            if (nums[i] > 0) {
                break;
            }
            //去掉重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int temp = curr + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //去除重复
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                } else if (temp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //
        Fifteen fifteen = new Fifteen();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = fifteen.threeSum(nums);
        System.out.println(lists);

        System.out.println(fifteen.threeSum2(nums));
    }

}
