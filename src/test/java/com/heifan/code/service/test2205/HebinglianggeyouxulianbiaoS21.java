package com.heifan.code.service.test2205;

import com.heifan.code.utils.JsonTool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 　合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author HiF
 * @date 2022/5/6 16:06
 */
@Slf4j
public class HebinglianggeyouxulianbiaoS21 {

    @Test
    void Hebinglianggeyouxulianbiao() {
        ListNode listNode3 = new ListNode(4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode list1 = new ListNode(1, listNode2);

        ListNode listNode23 = new ListNode(4);
        ListNode listNode22 = new ListNode(3, listNode23);
        ListNode list2 = new ListNode(1, listNode22);
        ListNode listNode = mergeTwoLists(list1, list2);
        log.info("result ==>{}", JsonTool.beanToJson(listNode));

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
