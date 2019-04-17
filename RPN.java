package leetcode;

import java.util.Stack;

public class RPN {
    //逆波兰式求值
    //思路：遍历字符串数组，遇到数字入栈   遇到符号出栈两个元素，进行运算操作，将结果入栈  直到遍历结束
    public int evalRPN(String[] tokens) {
        //定义一个栈用来存储数字
        Stack<Integer> stack = new Stack<Integer>();
        int a;
        int b;
        int sum;
        for(int i=0;i<tokens.length;++i){
            if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                //出栈两个数据  就当前运算符进行计算，并将结果压入栈中
                a = stack.pop();
                b = stack.pop();
                //注意栈的先进后出的特性，故在操作时将操作数换序
                sum = operation(b,a,tokens[i]);
                //将结果入栈
                stack.push(sum);
            }
        }
        //返回栈顶元素即可
        return stack.pop();
    }

    private int operation(int a, int b, String token) {
        if(token.equals("+"))
            return a+b;
        else if(token.equals("-"))
            return a-b;
        else if(token.equals("*"))
            return a*b;
        else
            //由于题目给出不存在除数为0的情况，故这里不考虑之
            return a/b;
    }
}
