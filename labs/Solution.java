import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        boolean contain = false;
        int[] sum = new int[2];
        List<Integer> newList = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++){
            newList.add(nums[i]);
        }

        for (int i=0; i<nums.length; i++){
            int current = nums[i];
            int need = target-current;
            if (newList.subList(i+1, nums.length).contains(need)){
                sum[0] = i;
                System.out.println(sum[0]);
                System.out.println(need);
                contain = true;
                break;
            }
        }
        System.out.println(contain);
        System.out.println(sum[0]);
        System.out.println(sum[1]);
        if (contain){
            for (int i=sum[0]+1; i<nums.length; i++){
                if (nums[i] == target-nums[sum[0]]){
                    sum[1] = i;
                    return sum;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
    	System.out.println(twoSum(new int[] {3, 2, 4}, 6));
    }
}