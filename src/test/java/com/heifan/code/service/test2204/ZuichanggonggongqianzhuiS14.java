package com.heifan.code.service.test2204;

import com.heifan.code.service.LeetCodeApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串""。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HiF
 * @date 2022/4/19 11:12
 */
@Slf4j
public class ZuichanggonggongqianzhuiS14 extends LeetCodeApplicationTest {

    @Test
    void execute() {
        String[] strings = {
                "aaa", "aa", "aaa"
        };
        String s = longestCommonPrefix(strings);
        log.info("res:{}", s);
    }

    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        if (0 == strs.length) return res;
        for (String s : strs) {
            int i = 0;
            for (; i < s.length() && i < res.length(); i++) {
                if (res.charAt(i) != s.charAt(i)) break;
            }
            res = res.substring(0, i);
            if (res.equals("")) return res;
        }
        return res;
    }
}
