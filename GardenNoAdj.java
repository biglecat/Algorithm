package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class GardenNoAdj {

    //暴力搜索
    public int[] gardenNoAdj(int N, int[][] paths) {
        //N个花园，每个花园的与邻接边的颜色不能一样  每个花园的邻接边不会超过3个
        int[] res = new int[N];
        //将花园的邻接边 存入 Set中    i表示花园 graden[i]是一个Set,表示花园i的邻接花园
        List<TreeSet<Integer>> garden = new ArrayList<>(N);
        for(int i=0;i<N;++i){
            garden.add(new TreeSet<Integer>());
        }
        //遍历paths  构建花园与其邻接边之间的数据结构  这里把所有花园的编号都-1
        for(int i=0;i<paths.length;i++){
            //paths[i][0]表示一个花园
            //paths[i][1]表示一个花园
            //以上两个花园邻接
            garden.get(paths[i][0]-1).add(paths[i][1]-1);
            garden.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        //遍历花园 为其着色
        //存储邻接花园的颜色
        TreeSet<Integer> adjcolors = new TreeSet<>();
        for(int i=0;i<garden.size();i++){
            //i表示花园i
            adjcolors.clear();  //i花园的邻接花园的 颜色集合
            Iterator<Integer> adjgardens = garden.get(i).iterator();
            //为花园i着色  花园i之前的花园都没有被着色
            while (adjgardens.hasNext()){
                Integer adjgarden = adjgardens.next();
                if(i<adjgarden){
                    //说明 从这个邻接花园花园开始 没有被着色 没有迭代下去的必要了
                    break;
                }else{
                    adjcolors.add(res[adjgarden]);
                }
            }
            for(int color = 1;color <= 4 ;++color){
                if(!adjcolors.contains(color)){
                    res[i] = color;
                    break;
                }
            }
        }
        return res;
    }




//    //暴力枚举 —— 超时
//    public int[] gardenNoAdj(int N, int[][] paths) {
//        //N个花园，每个花园的与邻接边的颜色不能一样  每个花园的邻接边不会超过3个
//        int[] res = new int[N];
//        //直接暴力搜索吧
//        for(int i=1;i<=N;++i){
//            color(res,i,paths);
//        }
//        return res;
//    }
//
//    //给第i个花园赋值
//    private void color(int[] res, int N, int[][] paths) {
//        //先搜索花园N的邻接花园
//        Set<Integer> adjs = new HashSet<>();
//        for(int i=0;i<paths.length;i++){
//            if(paths[i][0]==N){
//                adjs.add(paths[i][1]);
//            }
//            if(paths[i][1]==N){
//                adjs.add(paths[i][0]);
//            }
//        }
//        //获取邻接花园的颜色
//        Set<Integer> cols = new HashSet<>();
//        for (Integer adj : adjs){
//            if(adj<N){
//                cols.add(res[adj-1]);
//            }
//        }
//        int col = 1;
//        while (col<=4){
//            if(!cols.contains(col)){
//                res[N-1] = col;
//                return;
//            }else {
//                col++;
//            }
//        }
//    }
}
