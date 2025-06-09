package LeetCodeProblems;

public class NodeView {
    int vertical;
    int level;
    TreeNode node;
    public NodeView(TreeNode node){
         this.node = node;
         this.vertical = 0;
         this.level = 0;
    }
    public NodeView(int vertical, int level, TreeNode node){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
