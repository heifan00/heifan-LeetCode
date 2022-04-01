package com.heifan.code.service.test2204;

import com.heifan.code.service.LeetCodeApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 *　回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author HiF
 * @date 2022/4/1 16:40
 */
@Slf4j
public class HuiwenshuS9 extends LeetCodeApplicationTest {

    @Test
    void huiwenshu() {
        boolean palindrome = isPalindrome(1221);
        log.info("result: {}", palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
