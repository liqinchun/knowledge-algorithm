package com.liqinchun.knowledge.knowledgealgorithm;

public class BaseClass {


    public static void main(String[] args) {
        dispAsicii('A');
        transCharToInt('3');
    }


    public static int dispAsicii(char ch){

        int iTemp = (int)ch;
        System.out.println(iTemp);
        return iTemp;
    }


    public static int transCharToInt(char c){
        System.out.println(c-'0');
        return c-'0';
    }
}
