import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int num : nums) {
            Set<Integer> newDp = new HashSet<>(dp);
            for (int t : dp) {
                int newSum = t + num;
                if (newSum == target) return true;
                newDp.add(newSum);
            }
            dp = newDp;
        }
        
        return dp.contains(target);
    }
}
