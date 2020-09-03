package com.py7hon.jianzhi.common;

import java.util.Arrays;

/**
 * 链表节点
 *
 * @author Seven
 * @version 1.0
 * @date 2020/9/3 11:28
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int... vals) {
        if (vals == null) {
            return;
        }

        this.val = vals[0];

        if (vals.length == 1) {
            return;
        }

        this.next = new ListNode(Arrays.copyOfRange(vals, 1, vals.length));
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode that = (ListNode) o;
        if (this.val != that.val) {
            return false;
        }

        if (this.next == null && that.next == null) {
            return true;
        }

        // 如果都有后续
        if (this.next != null && that.next != null) {
            return this.next.equals(that.next);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return val;
    }
}
