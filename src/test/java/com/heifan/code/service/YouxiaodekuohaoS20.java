package com.heifan.code.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 　有效的括号 S20 simple-20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HiF
 * @date 2022/4/1 15:09
 */
@Slf4j
public class YouxiaodekuohaoS20 extends LeetCodeApplicationTest {

    private static final Map<Character, Character> characterCharacterHashMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
            put('?', '?');
        }
    };

    @Test
    void validParentheses() {
        boolean valid = isValid("(][)");
        log.info("result: {}", valid);
    }

    public boolean isValid(String s) {
        if (s.length() < 0 && !characterCharacterHashMap.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (characterCharacterHashMap.containsKey(c)) {
                stack.add(c);
            } else if (characterCharacterHashMap.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
