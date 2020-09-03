package com.py7hon.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Seven
 * @version 1.0
 * @date 2020/8/31 13:54
 */
class JZ9 {
    private static final Map<Integer, Integer> dp;

    static {
        dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 2);
        dp.put(3, 4);
        dp.put(4, 8);
    }

    /**
     * dp[n] = dp[n-1] + dp[n - 2] + ... + dp[1] + 1
     * 这里的 +1 是因为从起点直接跳到终点的这种情况没有被包括进去，相当于替换了 dp[0] 的情况
     * dp[0] = 0
     * dp[1] = 1
     * dp[2] = 2
     * dp[3] = 4
     * dp[4] = 8
     */
    public int JumpFloorII(int target) {
        if (dp.get(target) != null) {
            return dp.get(target);
        }
        int result = 1;
        for (int i = 1; i < target; i++) {
            result += dp.get(i);
        }
        dp.put(target, result);

        return result;
    }

    /**
     * 找规律，除了最后一个台阶，任何一个台阶都可能被作为跳板跳出，最后一个台阶已到达，所以包含在内
     * return 2^(target - 1)
     * @param target
     * @return
     */
    public int JumpFloorIII(int target) {
        ///return Math.pow(2, target - 1);
        return 1 << (target - 1);
    }

    /**
     * 假如 target = 5
     * 可能1次跳完、2次、3、4、5
     * 1 1 1 1 1
     * 如果是 3 次跳完，可以看作是将上面的 5 个数分成 3 份
     * 1 次跳完，有一种跳法
     * 2 次跳完：c41
     * 3 次跳完：c42
     * 4 次跳完：c43
     * 5 次跳完：c44
     * 总结：n个台阶 = c(n-1)(n-1) + c(n-1)(n-2) + ... + c(n - 1)0
     */
    public int JumpFloorIIII(int target) {
        return -1;
    }
}
