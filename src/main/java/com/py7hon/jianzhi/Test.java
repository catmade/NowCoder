package com.py7hon.jianzhi;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Seven
 * @version 1.0
 * @date 2020/9/1 9:07
 */
@Data
@NoArgsConstructor
class Test {

    public static void random(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        Random random = new Random();
        for (int i = 0, length = array.length; i < length; i++) {
            int j = random.nextInt(length - i);
            swap(array, j, length - i - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Arrays.toString(array));
        random(array);
        System.out.println(Arrays.toString(array));
    }
}
