package com.heifan.code.service.test2301;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author HiF
 * @description 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 * @date 2023/1/2 17:01
 */
@Slf4j
public class ZuihouyigedancidechangduS58 {

    @Test
    void Zuihouyigedancidechangdu() {
        int i = lengthOfLastWord("   fly me   to   the moon  ");
        log.info(String.valueOf(i));
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
