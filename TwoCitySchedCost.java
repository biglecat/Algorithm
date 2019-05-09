package leetcode;

import java.util.Arrays;

public class TwoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        //前一半取去A市，后一半取去B市
        // 前一半是去A市最合适 后一半市去B市最合适。
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
    }

//    //两地调度
//    public int twoCitySchedCost(int[][] costs) {
//        int sum = 0; //总花销
//        int cnt = costs.length;
//        //感觉应该 看两市之间的  票价差额。
//        // 根据票价差额从大到小排序。先选票价差额大的   再选票价差额小的
//        HashMap<Integer,Integer> map = new HashMap<>();
//        //以A[i][] i为key,abs(costs[i][0]-costs[i][1])为value,对value从小到大进行排序
//        for(int i=0;i<cnt;i++){
//            map.put(i,Math.abs(costs[i][0]-costs[i][1]));
//        }
//        //将HashMap中的键值对 按照value从大到小排序
//        List<HashMap.Entry<Integer,Integer>> list = new ArrayList<HashMap.Entry<Integer,Integer>>(map.entrySet());
//        list.sort(new Comparator<HashMap.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        int cntA = 0;//A超过半数则不选
//        int cntB = 0; //B超过半数则不选
//        //根据list中的排序，先选择相应的key并计数
//        for(int i = 0;i<list.size();i++){
//            int pos = list.get(i).getKey();
//            if(costs[pos][0]-costs[pos][1] < 0){  //说明城市A花费比较少
//                if(cntA<cnt/2){ //说明城市A还没满
//                    sum += costs[pos][0];
//                    cntA++;
//                }else {
//                    //城市A已满  那么就算B的花销比较少也只能选B了
//                    sum += costs[pos][1];
//                    cntB++;
//                }
//            }else {  //城市Ｂ的花费比较少
//                //如果城市B还没满
//                if(cntB<cnt/2){
//                    sum += costs[pos][1];
//                    cntB++;
//                }else {
//                    //城市B已满  那么就算B的花销比较少也只能选A了
//                    sum += costs[pos][0];
//                    cntA++;
//                }
//            }
//        }
//        return sum;
//    }
//

}
