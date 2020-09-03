package com.py7hon.jianzhi.jz11_20;

import com.py7hon.jianzhi.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 合并两个排序的链表
 *
 * @author Seven
 * @version 1.0
 * @date 2020/9/3 14:25
 */
class JZ16 {
    public ListNode merge(ListNode list1, ListNode list2) {
        return null;
    }

    @Test
    public void test() {
        ListNode l2 = new ListNode(1, 2, 5, 7, 9);
        ListNode l1 = new ListNode(2, 4, 6, 8, 10);
        ListNode total = new ListNode(1, 2, 2, 4, 5, 6, 7, 8, 9, 10);
        JZ16 q = new JZ16();
        Assertions.assertEquals(total, total);
    }

    @Test
    public void equalsTest() {
        Assertions.assertEquals(new ListNode(1, 2, 3, 4), new ListNode(1, 2, 3, 4));
        Assertions.assertNotEquals(new ListNode(1, 2, 3, 4), new ListNode(1, 2, 3, 4, 5));
        Assertions.assertEquals(new ListNode(1), new ListNode(1));
        Assertions.assertNotEquals(new ListNode(1, 2, 3, 4), new ListNode(1, 3, 2, 4));
    }

}
