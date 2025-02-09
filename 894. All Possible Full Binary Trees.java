import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    
    private List<TreeNode> solve(int n) {
        if (n % 2 == 0) return new ArrayList<>(); // Even nodes can't form a full binary tree
        
        if (n == 1) {
            List<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }
        
        if (memo.containsKey(n)) return memo.get(n);
        
        List<TreeNode> result = new ArrayList<>();
        
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftAllFBT = allPossibleFBT(i);
            List<TreeNode> rightAllFBT = allPossibleFBT(n - i - 1);
            
            for (TreeNode left : leftAllFBT) {
                for (TreeNode right : rightAllFBT) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        memo.put(n, result);
        return result;
    }
    
    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
}
