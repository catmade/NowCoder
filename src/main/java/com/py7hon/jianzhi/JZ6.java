package com.py7hon.jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 <br>
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 <br>
 * 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。<br>
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。 题解 讨论 通过的代码笔记 纠错 收藏
 *
 * @author Seven
 * @version 1.0
 * @date 2020/8/31 10:24
 */
class JZ6 {
    /**
     * 暴力法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int minNumberInRotateArrayI(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.binarySearch(array, 1);
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return array[i];
            }
        }

        return array[0];
    }

    /**
     * 二分法
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     */
    public int minNumberInRotateArrayII(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            //确认子数组是否是类似1,1,2,4,5,..,7的非递减数组
            if (array[left] < array[right]) return array[left];

            int mid = left + (right - left) / 2;
            //如果左半数组为有序数组
            if (array[left] < array[mid])
                left = mid + 1;
                //如果右半数组为有序数组
            else if (array[mid] < array[right])
                right = mid;
                //否则，array[left] == array[mid] == array[right]
            else {
                ++left;
            }
        }
        return array[left];
    }

    @Test
    public void minNumberInRotateArrayIITest() {
        JZ6 q = new JZ6();
        Assertions.assertEquals(0, q.minNumberInRotateArrayII(null));
        Assertions.assertEquals(0, q.minNumberInRotateArrayII(new int[]{}));
        Assertions.assertEquals(1, q.minNumberInRotateArrayII(new int[]{1}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayII(new int[]{6, 7, 8, 9, 10, 11}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayII(new int[]{7, 8, 9, 10, 11, 6}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayII(new int[]{8, 9, 10, 11, 6, 7}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayII(new int[]{9, 10, 11, 6, 7, 8}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayII(new int[]{10, 11, 6, 7, 8, 9}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayII(new int[]{11, 6, 7, 8, 9, 10}));
    }

    @Test
    public void minNumberInRotateArrayITest() {
        JZ6 q = new JZ6();
        Assertions.assertEquals(0, q.minNumberInRotateArrayI(null));
        Assertions.assertEquals(0, q.minNumberInRotateArrayI(new int[]{}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayI(new int[]{6, 7, 8, 9, 10, 11}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayI(new int[]{7, 8, 9, 10, 11, 6}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayI(new int[]{8, 9, 10, 11, 6, 7}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayI(new int[]{9, 10, 11, 6, 7, 8}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayI(new int[]{10, 11, 6, 7, 8, 9}));
        Assertions.assertEquals(6, q.minNumberInRotateArrayI(new int[]{11, 6, 7, 8, 9, 10}));
    }
}
