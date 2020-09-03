package com.py7hon.jianzhi.jz11_20;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 顺时针打印矩阵
 *
 * @author Seven
 * @version 1.0
 * @date 2020/9/3 14:50
 */
class JZ19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 将矩阵第一行插入进来
        for (int column = 0; column < matrix[0].length; column++) {
            result.add(matrix[0][column]);
        }

        if (matrix.length == 1) {
            return result;
        }

        // 删除数组的第一行，并将矩阵逆时针旋转
        int[][] ints = trimAndInverse(matrix);

        // 重复执行上述操作
        result.addAll(printMatrix(ints));
        return result;
    }

    /**
     * 删除数组的第一行，并将矩阵逆时针旋转返回结果
     *
     * @param matrix 原始矩阵
     * @return 结果
     */
    private int[][] trimAndInverse(int[][] matrix) {
        int[][] ints = new int[matrix[0].length][matrix.length - 1];
        for (int row = 0; row < ints.length; row++) {
            for (int column = 0; column < ints[0].length; column++) {
                ints[row][column] = matrix[column + 1][matrix[0].length - 1 - row];
            }
        }
        return ints;
    }

    @Test
    public void trimAndInverseTest() {
        int[][] before = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        System.out.println(Arrays.deepToString(trimAndInverse(before)));
        // Assertions.assertArrayEquals(new int[][]{
        //         {12, 13, 14, 5},
        //         {11, 16, 15, 6},
        //         {10, 9, 8, 7}
        // }, trimAndInverse(before));
    }

    @Test
    public void printMatrixTest() {
        int[][] before = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        ArrayList<Integer> actual = this.printMatrix(before);
        actual.forEach(System.out::println);
        assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i));
        }
    }
}
