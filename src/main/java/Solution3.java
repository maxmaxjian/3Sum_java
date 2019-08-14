import java.util.*;

public class Solution3 implements Solution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1, end = nums.length-1;
            while (start < end) {
                if (nums[i]+nums[start]+nums[end] == 0) {
                    List<Integer> tmp = Arrays.asList(nums[i], nums[start], nums[end]);
                    result.add(tmp);
                    start++;
                } else if (nums[i]+nums[start]+nums[end] > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
