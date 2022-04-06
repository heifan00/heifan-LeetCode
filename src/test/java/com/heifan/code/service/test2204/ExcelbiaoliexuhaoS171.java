package com.heifan.code.service.test2204;

import com.heifan.code.service.LeetCodeApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 　Excel表序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HiF
 * @date 2022/4/6 11:19
 */
@Slf4j
public class ExcelbiaoliexuhaoS171 extends LeetCodeApplicationTest {

    @Test
    void Excelbiaoliexuhao() {
        int asz = titleToNumber("ASZ");
        log.info("result: {}", asz);
    }

    public int titleToNumber(String columnTitle) {
        int ans = 0, num = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // ASCII码值相减
            num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }


    @Test
    void charTest() {
        String s = "heifan";
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            log.info("num: {}", num);
        }
    }
}
