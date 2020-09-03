package com.py7hon.jianzhi.jz01_10;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author Seven
 * @version 1.0
 * @date 2020/8/31 9:26
 */
class JZ5 {

    /**
     * 入队时使用此栈
     */
    Stack<Integer> stack1 = new Stack<Integer>();

    /**
     * 出队时使用此站配合使用
     */
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 判断出队栈是否为空，不为空说明已经被初始化，可以正常出栈
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        // 为空，说明未被初始化，需要将stack1出栈到stack2，调整先后顺序
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // 然后再出队
        return stack2.pop();
    }

    public int popV2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        JZ5 stack = new JZ5();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
