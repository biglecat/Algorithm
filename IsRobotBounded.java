package leetcode;

public class IsRobotBounded {

    //困住机器人
    public boolean isRobotBounded(String instructions) {
        char[] ins = instructions.toCharArray();
        //表示方向
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x=0,y=0,z=0;
        for(int i=0;i<ins.length;i++){
            switch (ins[i]){
                case 'G':{
                    x += dx[z];
                    y += dy[z];
                    break;
                }
                case 'L':{
                    z = (z+3)&3;
                    break;
                }
                case 'R':{
                    z = (z+1)&3;
                    break;
                }
            }

        }
        //如果回到原點 則返回true
        //如果沒回到原點 且與初始方向不一樣  則返回true
        if(x==0&&y==0||z!=0){
            return true;
        }else{
            //返回false
            return false;
        }
    }
}
