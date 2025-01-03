// Day 4 
import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    public static int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Integer[] arr = set.toArray(new Integer[0]);

        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = map.get(arr[0]) * arr[0];

        for (int i = 1; i < n; i++) {
            int current = map.get(arr[i]) * arr[i];
            if (arr[i] == arr[i - 1] + 1) {
                dp[i] = Math.max(dp[i - 1], (i - 2 >= 0 ? dp[i - 2] : 0) + current);
            } else {
                dp[i] = dp[i - 1] + current;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(deleteAndEarn(arr));
    }
}
