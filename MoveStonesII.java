package leetcode;

import java.util.Arrays;

public class MoveStonesII {
    //移動石子至連續
    public int[] numMovesStonesII(int[] stones) {
        int[] res = new int[2];
        int len = stones.length;
        //先將石子們排個序
        Arrays.sort(stones);
        //最大的石子移動次數: 排除掉某端點的最小間隔后，按最大間隔數計算
        int maxstep = Math.max(stones[len-2]-stones[0],stones[len-1]-stones[1])-1 -(len-3);
        res[1] = maxstep;
        //最小的石子移動次數： 怕是只能暴力搜索最合適的位置了
        int minstep = 0x7fffffff;
        //遍歷石頭可占據的連續範圍，想象需要占據 start 至 end 這個空間範圍的數組
        //以每個石子爲起點吧
        int pos = 0;
        while(pos<len){
            //拿一個起始點為stones[pos],長度為len的尺子  來衡量落在尺子上的石子有多少  這個就只用衡量len次
            int start = stones[pos];
            int end = stones[pos]+len-1;
            int cnt = 0; //記錄落在尺子上的點
            int first = 0; //記錄落在尺子上的第一個點
            int last = -1; //記錄落在尺子上的最後一個點
            while(stones[first]<start){
                first++;
            }
            for(int i=first;i<len;i++){
                if(stones[i]<=end){
                    cnt++;
                }else{
                    last = i-1;
                    break;
                }
            }
            if(last==-1){
                last = len-1;
            }
            //以上循環結束后，有cnt個石頭落在start到end這個範圍内   有len-cnt個石頭需要移動到這個範圍内
            int min = len-cnt;

            //如果一顆石頭散落在外，且留給他的空位只有端點位置，則要額外搬動一次
            if(min==1){
                //説明兩端無空位
                if(stones[first]!=start||stones[last]!=end){
                    min++;
                }
            }
            minstep = minstep<min?minstep:min;
            pos++;
        }
        res[0] = minstep;
        return res;
    }


//    //移動石子至連續  超時
//    public int[] numMovesStonesII(int[] stones) {
//        int len = stones.length;
//        //先將石子們排個序
//        Arrays.sort(stones);
//        //最大的石子移動次數: 排除掉某端點的最小間隔后，按最大間隔數計算
//        int maxstep = Math.max(stones[len-2]-stones[0],stones[len-1]-stones[1])-1 -(len-3);
//        //最小的石子移動次數： 怕是只能暴力搜索最合適的位置了
//        int minstep = 0x7fffffff;
//        //遍歷石頭可占據的連續範圍，想象需要占據 start 至 end 這個空間範圍的數組    如果石子的範圍太大  會超時
//        for(int start = stones[0], end = start+len-1; end<=stones[len-1] ; ++start,++end){
//            // 遍歷石頭們計算從 start到end 這個範圍内的 石頭個數
//            int cnt = 0;
//            int pre = 0;
//            int j = 0;
//            int stone = stones[j];
//            while(stone < start && j<len-1){
//                stone = stones[++j];
//            }
//            pre = j;
//            while(stone <= end && j<len-1){
//                cnt++;
//                stone = stones[++j];
//            }
//            if(j == len-1&&stones[j]==end){
//                cnt++;
//            }
//            //以上循環結束后，有cnt個石頭落在start到end這個範圍内   有len-cnt個石頭需要移動到這個範圍内
//            //把散落在外的石頭搬進來
//            int min = len-cnt;
//            //如果一顆石頭散落在外，且留給他的空位只有端點位置，則要額外搬動一次
//            if(min==1){
//                //説明兩端無空位
//                if(stones[pre]!=start||stones[j--]!=end){
//                   min++;
//                }
//            }
//            minstep = minstep<min?minstep:min;
//        }
//
//        int[]res = {minstep,maxstep};
//        return res;
//    }
}
