public class Solution {
    public boolean hasCommon(String s1, String s2) {
        int[] arr = new int[26];
        for (char ch : s1.toCharArray()) {
            if (arr[ch - 'a'] > 0)
                return true;
            arr[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            if (arr[ch - 'a'] > 0)
                return true;
        }
        return false;
    }

    private Map<StringBuilder, Integer> mp = new HashMap<>();

    public int solve(int idx, List<String> arr, StringBuilder temp, int n) {
        if (idx >= n)
            return temp.length();
        if (mp.containsKey(temp))
            return mp.get(temp);
        int include = 0;
        int exclude = 0;
        if (hasCommon(arr.get(idx), temp.toString())) {
            exclude = solve(idx + 1, arr, temp, n);
        } else {
            exclude = solve(idx + 1, arr, temp, n);
            StringBuilder newTemp = new StringBuilder(temp);
            include = solve(idx + 1, arr, newTemp.append(arr.get(idx)), n);
        }
        mp.put(temp, Math.max(include, exclude));
        return mp.get(temp);
    }

    public int maxLength(List<String> arr) {
        return solve(0, arr, new StringBuilder(), arr.size());
    }

}
