import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 implements Solution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums_set = IntStream.of(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> nums_copy = new ArrayList<>(nums_set);
            nums_copy.remove((Integer)nums[i]);
            List<List<Integer>> tmp = twoSum(nums_copy, -nums[i]);
            for (List<Integer> list : tmp) {
                list.add(nums[i]);
                list.sort(Comparator.naturalOrder());
                if (!result.contains(list)) {
                    result.add(list);
                }
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(List<Integer> nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n : nums) {
            List<Integer> copy = new ArrayList<>(nums);
            copy.remove((Integer)n);
            if (copy.contains(target-n)) {
                List<Integer> tmp = new ArrayList<>(Arrays.asList(n, target-n));
                tmp.sort(Comparator.naturalOrder());
                result.add(tmp);
            }
        }
        return result;
    }
}
