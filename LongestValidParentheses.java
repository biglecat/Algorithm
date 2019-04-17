package leetcode;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int left = oneside('(',chars,0,chars.length,1);
        int right = oneside(')',chars,chars.length-1,-1,-1);
        return left>right?left:right;

    }

    private int oneside(char c, char[] chars, int start, int end, int add) {
        int cnt = 0;
        int max = 0;
        int cur = 0;
        for(int i=start;i!=end;i+=add){
            if(chars[i]==c){
                cnt++;
            }else {
                cnt--;
                if(cnt>0){
                    // ( () 当前有个括号产生 但前面有多余的(
                    cur++;
                }else if(cnt==0){
                    // () () 当前有个括号产生，且前面没有多余的(
                    cur++;
                    max = max>cur?max:cur;  //如果不存在cnt=0的情况怎么办？比如 (()     --那就从右往左遍历匹配')'
                }else{
                    //到这个)为止，前面的最长有效括号统计完毕。。 各计数器需要清0，开始下一轮的计数
                    cnt = 0;
                    cur = 0;
                }
            }
        }
        return max*2;
    }

}
