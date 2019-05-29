package com.lizhao.practice;

import java.util.ArrayList;
import java.util.List;

/* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：
    [  6 5 4 / 3 2 1
        [-1, 0, 1],
        [-1, -1, 2]
     ]
  */
public class Practice1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(i<length-2){
                int base1 = nums[i];
                for(int j=i+1;j<length-2;j++){
                    int base2 = nums[j];
                    int base3 = 0;
                    for(int k=j+1;k<length;k++){
                        base3 = nums[k];
                        if(base1+base2+base3==0){
                            boolean isExist = isExist(retList,base1,base2,base3);
                            if(!isExist){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(base1);
                                list.add(base2);
                                list.add(base3);
                                retList.add(list);
                            }
                        }
                    }
                }
            }
        }
        return retList;
    }

    public static boolean isExist(List<List<Integer>> retList,int base1,int base2,int base3){
        if(retList==null || retList.size()==0)
            return false;
        for (List<Integer> list : retList) {
            if(list.contains(base1) && list.contains(base2) && list.contains(base3))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
    }
}
