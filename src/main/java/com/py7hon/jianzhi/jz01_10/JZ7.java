package com.py7hon.jianzhi.jz01_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。 n<=39  题解 讨论 通过的代码笔记 纠错 收藏
 *
 * @author Seven
 * @version 1.0
 * @date 2020/8/31 10:29
 */
class JZ7 {

    /**
     * 用来存之前计算过的值
     */
    private static int[] temp = new int[39];

    static {
        Arrays.fill(temp, -1);
        temp[0] = 0;
        temp[1] = 1;
    }

    public int fibonacci(int n) {
        if (temp[n] != -1) {
            return temp[n];
        }

        temp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return temp[n];
    }

    @Test
    public void test() {
        JZ7 solution = new JZ7();
        Assertions.assertEquals(5, solution.fibonacci(5));
        Assertions.assertEquals(8, solution.fibonacci(6));
        Assertions.assertEquals(13, solution.fibonacci(7));
        Assertions.assertEquals(21, solution.fibonacci(8));
    }
}
