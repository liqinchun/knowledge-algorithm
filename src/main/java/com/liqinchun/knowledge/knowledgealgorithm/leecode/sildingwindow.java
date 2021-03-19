package com.liqinchun.knowledge.knowledgealgorithm.leecode;

import java.util.Hashtable;

/**
 * 滑动窗口
 */
public class sildingwindow {

    /**
     * leecode 题3
     * 给定一个字符串，请你找出不含重复字母的最长字符串的长度
     * 滑动窗口
     * 1.找到子串
     * 2.记录长度
     * 3.更新长度
     */

    public static int repetitiveStr(String str) {
        Hashtable<Character, Integer> hashtable = new Hashtable();
        int start=0;
        int mark = 0;
        int maxLength = 0;
        for (char c:str.toCharArray()) {
            mark ++;

            if (hashtable.containsKey(c)) {
                start = Math.max(hashtable.get(c), start);
//                start = hashtable.get(c);
            }
            hashtable.put(c,mark);
            maxLength = Math.max(maxLength,mark - start);

        }
        return maxLength;

    }
    /**
     * 30串联所有单词的字串
     */
    /**
     *
     */

    /**
     * leecode 76 最小覆盖字串
     */

    /**
     * leecode 159 至多包含两个不同字符的最长子串
     */
    /**
     * 209 长度最小的子数组
     */
    /**
     * 239 滑动窗口最大值
     */
    /**
     * leecode 340 至多包含k个不用字符的最长字串
     */
    /**
     * 567 字符串的排列
     */

    /**
     * 632 最小区间
     */
    /**
     * 727 最小窗口子序列
     */



}
