package L2022211830_4_Test;

import Lab2_2022211830_solution4.Solution4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @description: 测试Solution4类的maximumGap方法
 *
 * 测试用例设计原则：
 * 1. 等价类划分原则：将输入划分为有效和无效类，确保每个类都有代表性的测试用例。
 * 2. 边界值分析：在边界附近选择测试用例，确保极端情况得到正确处理。
 * 3. 特殊情况：处理特殊输入，例如空数组和数组长度为1的情况。
 */
public class L2022211830_4_Test {

    /**
     * 测试目的：测试正常情况下的最大差值
     * 用例：输入数组 [3, 6, 9, 1]
     * 期望输出：返回 3
     */
    @Test
    public void testNormalCase() {
        Solution4 solution = new Solution4();
        int[] nums = {3, 6, 9, 1};
        assertEquals(3, solution.maximumGap(nums));
    }

    /**
     * 测试目的：测试数组元素个数小于2的情况
     * 用例：输入数组 [10]
     * 期望输出：返回 0
     */
    @Test
    public void testSingleElement() {
        Solution4 solution = new Solution4();
        int[] nums = {10};
        assertEquals(0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：测试空数组的情况
     * 用例：输入数组 []
     * 期望输出：返回 0
     */
    @Test
    public void testEmptyArray() {
        Solution4 solution = new Solution4();
        int[] nums = {};
        assertEquals(0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：测试包含负数的数组
     * 用例：输入数组 {-10, -5, -1, 0, 5}
     * 期望输出：返回 5
     */
    @Test
    public void testNegativeNumbers() {
        Solution4 solution = new Solution4();
        int[] nums = {-10, -5, -1, 0, 5};
        assertEquals(5, solution.maximumGap(nums)); // 5 - (-10) = 15
    }

    /**
     * 测试目的：测试包含重复元素的情况
     * 用例：输入数组 [1, 1, 1, 1]
     * 期望输出：返回 0
     */
    @Test
    public void testRepeatedElements() {
        Solution4 solution = new Solution4();
        int[] nums = {1, 1, 1, 1};
        assertEquals(0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：测试大范围数值的情况
     * 用例：输入数组 [1, 1000000000]
     * 期望输出：返回 999999999
     */
    @Test
    public void testLargeRange() {
        Solution4 solution = new Solution4();
        int[] nums = {1, 1000000000};
        assertEquals(999999999, solution.maximumGap(nums));
    }

    /**
     * 测试目的：测试有序数组的情况
     * 用例：输入数组 [1, 2, 3, 4, 5]
     * 期望输出：返回 1
     */
    @Test
    public void testSortedArray() {
        Solution4 solution = new Solution4();
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(1, solution.maximumGap(nums));
    }
}
