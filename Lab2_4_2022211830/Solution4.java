package Lab2_2022211830_solution4;

import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 *
 */
public class Solution4 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();

        // 特殊情况处理
        if (maxVal == minVal) {
            return 0;
        }

        // 计算桶的大小和数量
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        // 创建桶
        int[][] buckets = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i][0] = Integer.MAX_VALUE; // 桶的最小值
            buckets[i][1] = Integer.MIN_VALUE; // 桶的最大值
        }

        // 将每个数字放入相应的桶中
        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize;
            buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
            buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
        }

        // 计算相邻桶之间的最大差值
        int ret = 0; // 使用 ret 作为最大差值的变量
        int previousMax = buckets[0][1];

        for (int i = 1; i < bucketCount; i++) {
            if (buckets[i][0] == Integer.MAX_VALUE) continue; // 该桶是空桶
            ret = Math.max(ret, buckets[i][0] - previousMax);
            previousMax = buckets[i][1];
        }

        return ret;
    }
}