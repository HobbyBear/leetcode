package com.xch.leetcode.suanfa.p20;

import java.util.Stack;

class Solution {
    //栈的特点 先进后出
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char bracket = s.charAt(i);
            if (bracket == '}' || bracket == ']' || bracket == ')'){
                if (stack.size() <= 0){
                    return false;
                }
                if (bracket == '}'){
                   if (!stack.pop().equals('{'))
                       return false;
                }else if (bracket == ')'){
                    if (!stack.pop().equals('('))
                        return false;
                }else {
                    if (!stack.pop().equals('['))
                        return false;
                }
            }else {
                stack.push(bracket);
            }
        }
        if (stack.size() > 0){
            return false;
        }
        return true;
    }
}