import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intmap = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (intmap.containsKey(target - nums[i]) && i != intmap.get(target - nums[i])) {
                result[0] = i;
                result[1] = intmap.get(target - nums[i]);
                return result;
            }
            intmap.put(nums[i], i);
        }

        return result;
    }
}
