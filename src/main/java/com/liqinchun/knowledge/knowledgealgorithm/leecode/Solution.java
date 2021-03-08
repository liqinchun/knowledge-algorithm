package com.liqinchun.knowledge.knowledgealgorithm.leecode;

public class Solution {

    /**
     * 验证回文字符串
     */
    public static boolean validPalindrome1(String str) {
        int low = 0;
        int high = str.length()-1;
        while (low<high) {
            char c1 = str.charAt(low);
            char c2 = str.charAt(high);
            if (c1!=c2)
                return false;
            low++;
            high--;
        }
        return true;

    }

    /**
     *
     * leecode 643
     * 给定一个字符串，最多删除一个字符。判断是否能成为回文字符串
     * 注意字符串只包含a-z的小写字母，字符串最大长度为50000
     * 贪心算法：不从整体最优上加以考虑，总是做出当前看来是最好的选择
     */

    public static boolean validPalindrome2(String str) {
        int low = 0;
        int high = str.length()-1;
        while (low<high) {
            if (str.charAt(low) !=str.charAt(high))
                return validPalindrome(str,low,high-1)||validPalindrome(str,low+1,high);
            else {
                low++;
                high--;
            }
        }
        return true;
    }
    public static boolean validPalindrome(String str,int low,int high) {
        for (int i = low, j = high;i<j;++i,--j) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);
            if (c1!=c2) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println(validPalindrome1("asddsaa"));
        System.out.println(validPalindrome2("asddsssa"));
    }
}
