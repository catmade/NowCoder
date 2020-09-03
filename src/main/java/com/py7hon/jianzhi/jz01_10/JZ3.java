package com.py7hon.jianzhi.jz01_10;

import com.py7hon.jianzhi.common.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @author Seven
 * @version 1.0
 * @date 2020/8/31 20:55
 */
class JZ3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        notifyAll();
        while (listNode != null) {
            result.add(0, listNode.val);
            listNode = listNode.next;
        }

        return result;
    }

    public static void main(String[] args) {
        JZ3 solution = new JZ3();
        ListNode listNode = new ListNode(67, 0, 24, 58);
        ArrayList<Integer> integers = solution.printListFromTailToHead(listNode);
    }
}

