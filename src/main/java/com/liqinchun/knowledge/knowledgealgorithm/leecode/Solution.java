package com.liqinchun.knowledge.knowledgealgorithm.leecode;

import java.util.*;

public class Solution {

    /** 题 1 给定一个整数数组nums和一个整数目标值target，请你在数组中找出和为目标值的两个数，并返回他们的下标 两数之和 */
    public static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            //            if (map.get(arr[i]) == (target - arr[i]))
            if (map.containsKey(target - arr[i])) return new int[] {i, map.get(target - arr[i])};
            map.put(arr[i], i);
        }

        return new int[0];
    }
    /**
     * 题2 两数相加 给你两个非空的链表，表示两个非负的整数。他们每位数字都是按照逆序的方式存储的， 并且每个节点只能存储一位数字。 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除数字0以外，其他数字都不会以0开头
     */
    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || carry != 0) {
            int n1 = l1 != null ? l1.number : 0;
            int n2 = l2 != null ? l2.number : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(null, null, sum % 10);
            } else {
                tail.nextNode = new ListNode(null, null, sum % 10);
                tail = tail.nextNode;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.nextNode;
            }
            if (l2 != null) {
                l2 = l2.nextNode;
            }
        }
        return head;
    }

    private static class ListNode {
        ListNode preNode;
        Integer number;
        ListNode nextNode;

        public ListNode(ListNode preNode, ListNode nextNode, Integer number) {
            this.preNode = preNode;
            this.nextNode = nextNode;
            this.number = number;
        }
    }

    /** 题3 给定一个字符串，请你找出不含重复字母的最长字符串的长度 滑动窗口 1.找到子串 2.记录长度 3.更新长度 */
    public static int repetitiveStr(String str) {
        Hashtable<Character, Integer> hashtable = new Hashtable();
        int start = 0;
        int mark = 0;
        int maxLength = 0;
        for (char c : str.toCharArray()) {
            mark++;

            if (hashtable.containsKey(c)) {
                start = Math.max(hashtable.get(c), start);
                //                start = hashtable.get(c);
            }
            hashtable.put(c, mark);
            maxLength = Math.max(maxLength, mark - start);
        }
        return maxLength;
    }

    /** 验证回文字符串 */
    public static boolean validPalindrome1(String str) {
        int low = 0;
        int high = str.length() - 1;
        while (low < high) {
            char c1 = str.charAt(low);
            char c2 = str.charAt(high);
            if (c1 != c2) return false;
            low++;
            high--;
        }
        return true;
    }

    /**
     * leecode 643 给定一个字符串，最多删除一个字符。判断是否能成为回文字符串 注意字符串只包含a-z的小写字母，字符串最大长度为50000
     * 贪心算法：不从整体最优上加以考虑，总是做出当前看来是最好的选择
     */
    public static boolean validPalindrome2(String str) {
        int low = 0;
        int high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return validPalindrome(str, low, high - 1) || validPalindrome(str, low + 1, high);
            else {
                low++;
                high--;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String str, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    /**
     * leecode第七题： 给定一个32位的有符号整数x，返回将x中的数字部分反转后的结果。 如果反转后的数字超过32位的符号整数范围[-2^31~2^31-1]，就返回0
     *
     * @see <a href="https://leetcode-cn.com/problems/reverse-integer">第7题</a>
     * @return
     */
    public int numberReverse(int x) {
        int finalNumber = 0;
        while (x != 0) {
            //判断溢出
            if ((finalNumber * 10) / 10 != finalNumber) {
                finalNumber = 0;
                break;
            }
            finalNumber = finalNumber * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(finalNumber);
        return finalNumber;
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println(validPalindrome1("asddsaa"));
        System.out.println(validPalindrome2("asddsssa"));
        int array[] = new int[] {3, 2, 5, 1};
        int target = 5;
        int[] arrSum = twoSum(array, target);
        for (int a : arrSum) {
            System.out.println(a);
        }

        // 题2
        ListNode listNode10 = new ListNode(null, null, 2);
        ListNode listNode11 = new ListNode(null, null, 4);
        ListNode listNode12 = new ListNode(null, null, 5);
        ListNode listNode20 = new ListNode(null, null, 5);
        ListNode listNode21 = new ListNode(null, null, 6);
        ListNode listNode22 = new ListNode(null, null, 4);
        listNode10.nextNode = listNode11;
        listNode11.nextNode = listNode12;
        listNode20.nextNode = listNode21;
        listNode21.nextNode = listNode22;
        ListNode node = addTwoNumber(listNode10, listNode20);
        System.out.println(".............题2");
        while (node != null) {
            System.out.println(node.number);
            node = node.nextNode;
        }
        System.out.println("..........题3");
        System.out.println(repetitiveStr("abba"));
    }
}
