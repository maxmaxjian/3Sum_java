import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1 implements Solution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = twoSum(nums, i);
            for (List<Integer> l : list) {
                if (!result.contains(l)) {
                    result.add(l);
                }
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int idx) {
        int target = -nums[idx];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = idx+1; i < nums.length-1; i++) {
//            if (i != idx) {
//                int start, end;
//                if (target-nums[i] < nums[i]) {
//                    start = 0;
//                    end = i;
//                } else {
//                    start = i;
//                    end = nums.length-1;
//                }
                int found = binFind(nums, target-nums[i], i+1, nums.length-1);
                if (found != -1 && found != i && found != idx) {
//                    List<Integer> tmp = new ArrayList<>();
//                    tmp.add(nums[i]);
//                    tmp.add(nums[found]);
//                    tmp.add(nums[idx]);
                    List<Integer> tmp = Arrays.asList(nums[i], nums[idx], nums[found]);
                    tmp.sort(Comparator.naturalOrder());
                    result.add(tmp);
                }
//            }
        }
        return result;
    }

    private int binFind(int[] nums, int target, int start, int end) {
        int b = start, e = end, mid;
        if (b == e) {
            return nums[b] == target ? b : -1;
        } else {
            while (b < e-1) {
                mid = (b+e)/2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    b = mid;
                } else {
                    e = mid;
                }
            }
            if (nums[b] == target) {
                return b;
            }
            if (nums[e] == target) {
                return e;
            }
            return -1;
        }
    }
}
