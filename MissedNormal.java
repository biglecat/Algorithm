package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissedNormal {

    //缺失的第一个正整数
    // if (min>1)||(max<1) return 1
    // if  min<1<max return (min,max)
    public int firstMissingPositive(int[] nums) {
        int min = 1000000000;
        int max = -1000000000;
        int[] cnt = new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            //确定nums中的最小值和最大值
            if(nums[i]>max)
                max = nums[i];
            if(nums[i]<min)
                min = nums[i];
            //将原数组nums中在[0,nums.length+1]这个范围内的数据存入数组cnt中
            if(nums[i]>0&&nums[i]<=nums.length){
                cnt[nums[i]] = nums[i];
            }
        }

        if(min>1||max<1)
            return 1;
        else{
            for(int i=1;i<cnt.length;i++)
                if(cnt[i]==0)
                    return i;
            if(cnt[cnt.length-1]!=0)
                return cnt.length;
            else
                return -1;
        }
    }


    //另一种解法 ： 不另外申请数组  在原数组上操作
    public int firstMisIIsingPositiveII(int[] nums) {
        int i=0;
        for (i=0;  i < nums.length; ) {
            if (nums[i] == i+1) {
                i++;
            }
            else if (nums[i] <=0 || nums[i] > nums.length) {
                i++;
            }
            else {
                // 交换两个数
                int temp = nums[i];
                nums[i] = nums[(nums[i]-1)];
                nums[temp-1] = temp;
                // 若交换的是左边的或是相同的数，则继续往后遍历
                if ((temp-1) < i || temp == nums[i]) {
                    i++;
                }
            }
        }
        for (i=0;  i < nums.length;i++ ) {
            if (nums[i] != (i+1)) {
                break;
            }
        }
        return (i+1);
    }


}
