import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//TC=O(n^2)
//SC=O(1)
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums ==null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n;i++){
            if(nums[i]>0)
                break;
            if(i >0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = n-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;

                    while (l <r && nums[l] ==nums[l-1]){
                        l++;
                    }
                    while (l <r && nums[r] ==nums[r+1]){
                        r--;
                    }
                }
                else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return result;
    }
}
