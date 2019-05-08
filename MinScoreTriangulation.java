package leetcode;

public class MinScoreTriangulation {
    //多边三角形剖分的最低得分：思路——>也许动态规划可以解决  超時！ 开辟一个数组避免重复计算
    public int minScoreTriangulation(int[] A) {
        //开辟一个数组记录中间值   避免重复计算
        int[][] record = new int[50][50];
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                record[i][j] = -1;
            }
        }
        int n = A.length;
        //以A[0] A[n-1]为底边,   分别计算以A[1]。。。A[n-2]为顶点的三块多边形的最小得分
        mST(0,n-1,A,record);
        return record[0][n-1];
    }

    private void mST(int start, int end, int[] A, int[][] rcd) {
        int min = 0x7fffffff;
        //如果只剩两个点，则值为0
        if(end-start == 1){
            rcd[start][end] = 0;
            return ;
        }
        //剩三个点，直接相乘
        if(end-start == 2){
            rcd[start][end] = A[start]*A[start+1]*A[end];
            return ;
        }
        //开始以A[start] A[end]为底边分割
        for(int top = start+1;top<end;++top){
            if(rcd[start][top] == -1){
                mST(start,top,A,rcd);
            }
            int mid = A[start]*A[top]*A[end];
            if(rcd[top][end] == -1){
                mST(top,end,A,rcd);
            }
            min = min<(rcd[start][top]+mid+rcd[top][end])?min:(rcd[start][top]+mid+rcd[top][end]);
        }
        rcd[start][end] = min;
    }
}
