package leetcode;

//从二叉搜索树到更大的和树

public class BstToGst {
    public TreeNode bstToGst(TreeNode root) {
        if(root==null){
            return null;
        }
        int[] presum = {0};
        getTreeSum(presum,root);
        //再次中顺遍历二叉树，更新节点值
        update(presum,root);

        return root;
    }

    private void update(int[] presum, TreeNode root) {
        if(root.left!=null){
            update(presum,root.left);
        }
        presum[0] -= root.val;
        root.val += presum[0];
        if(root.right!=null){
            update(presum,root.right);
        }
    }

    private void getTreeSum(int[] presum, TreeNode root) {
        //中序遍历一棵二叉树  记录已遍历过的节点之和
        if(root.left!=null){
            getTreeSum(presum,root.left);
        }
        presum[0] += root.val;
        if(root.right!=null){
            getTreeSum(presum,root.right);
        }
    }


}
