package com.py7hon.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author Seven
 * @version 1.0
 * @date 2020/8/31 11:49
 */
class JZ8 {
    /**
     * dp[n] = dp[n - 1] + dp[n - 2]
     * dp[0] = 0
     * dp[1] = 1
     * dp[2] = 2
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    // region ============= 空间换时间 =============

    private static Map<Integer, Integer> dp = new HashMap<>();

    static {
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 2);
    }

    public int jumpFloor(int target) {
        if (dp.get(target) != null) {
            return dp.get(target);
        }

        int result = jumpFloor(target - 1) + jumpFloor(target - 2);
        dp.put(target, result);

        return result;
    }

    // endregion
}
