package com.heifan.code.service.test2204;

import com.heifan.code.service.LeetCodeApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 　阶乘后的0
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HiF
 * @date 2022/4/6 14:05
 */
@Slf4j
public class JiechenghoudelingS172 extends LeetCodeApplicationTest {

    @Test
    void Jiechenghoudeling() {
        int asz = trailingZeroes(6);
        log.info("result: {}", asz);
    }

    public int trailingZeroes(int n) {
        int asz = 0;
        int divisor = 5;
        while (divisor <= n) {
            asz += n / divisor;
            divisor *= 5;
        }
        return asz;
    }
}
