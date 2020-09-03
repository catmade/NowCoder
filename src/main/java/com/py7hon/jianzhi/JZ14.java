package com.py7hon.jianzhi;

import com.py7hon.jianzhi.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author Seven
 * @version 1.0
 * @date 2020/9/3 11:20
 */
class JZ14 {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode p = head;
        // 先走到第 k 个位置
        for (int i = 0; i < k; i++) {
            if (p == null) {
                // 如果走到为 null 时还没走到，说明 k 值比链表长度要长
                return null;
            }
            p = p.next;
        }

        // 同时走到链表结尾
        ListNode q = head;
        while (p != null) {
            q = q.next;
            p = p.next;
        }

        return q;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(8, 7, 6, 5, 4, 3, 2, 1);
        JZ14 q = new JZ14();
        assertEquals(new ListNode(1), q.findKthToTail(listNode, 1));
        assertEquals(new ListNode(2), q.findKthToTail(listNode, 2));
        assertEquals(new ListNode(3), q.findKthToTail(listNode, 3));
        assertEquals(new ListNode(4), q.findKthToTail(listNode, 4));
        assertEquals(new ListNode(5), q.findKthToTail(listNode, 5));
        assertEquals(new ListNode(6), q.findKthToTail(listNode, 6));
        assertEquals(new ListNode(7), q.findKthToTail(listNode, 7));
        assertEquals(new ListNode(8), q.findKthToTail(listNode, 8));
        assertNull(q.findKthToTail(listNode, 0));
        assertNull(q.findKthToTail(listNode, -1));
        assertNull(q.findKthToTail(listNode, 10));
        assertNull(q.findKthToTail(listNode, 9));

        assertEquals(new ListNode(1), q.findKthToTail(new ListNode(1), 1));
        assertEquals(new ListNode(1), q.findKthToTail(new ListNode(2, 1), 1));
        assertEquals(new ListNode(2), q.findKthToTail(new ListNode(2, 1), 2));
    }
}
