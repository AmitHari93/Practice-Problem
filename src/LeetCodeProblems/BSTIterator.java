package LeetCodeProblems;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }

    public int next() {
        TreeNode node = s.pop();
        if(node.right!=null){
            pushAllLeft(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
    public void pushAllLeft(TreeNode node){
        while(node!=null){
            s.push(node);
            node = node.left;
        }
    }
    public void pushAllRight(TreeNode node){
        while(node!=null){
            s.push(node);
            node = node.right;
        }
    }
}
