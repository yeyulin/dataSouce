package com.datasouce.leetcode;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author yeyulin 2020-09-11
 */
@Data
@Builder
@ToString
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
