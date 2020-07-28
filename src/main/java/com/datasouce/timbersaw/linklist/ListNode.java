package com.datasouce.timbersaw.linklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yeyulin
 * @description:
 * @date 2020/7/28 9:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
