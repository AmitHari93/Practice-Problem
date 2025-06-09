package LeetCodeProblems;

public class TreeNode {
    int val;
    int hd;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.hd = 0;
    }
    TreeNode(int val, int hd, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.hd = hd;
    }
}
