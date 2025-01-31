public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        List<HashMap<Long, Integer>> mp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mp.add(new HashMap<>());
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int count_at_j = mp.get(j).getOrDefault(diff, 0);

                result += count_at_j;
                
               
                mp.get(i).put(diff, mp.get(i).getOrDefault(diff, 0) + count_at_j + 1);
            }
        }
        return result;
    }
}
