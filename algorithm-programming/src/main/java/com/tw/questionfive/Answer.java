package com.tw.questionfive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tanwei
 * @Description:说明生活中遇到的二叉树，用java实现二叉树
 * @Date: Create in 18:15 2019/7/4
 * 知识点
 *      方法的递归
 *      二叉树：
 *          完全二叉树 对一颗具有n个结点的二叉树按层编号，如果编号为i(1<=i<=n)的结点与同样深度的满二叉树中编号为i的结点在二叉树中位置完全相同，则这棵二叉树称为完全二叉树。
 *          平衡二叉树 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *          满二叉树    在一棵二叉树中。如果所有分支结点都存在左子树和右子树，并且所有叶子都在同一层上，这样的二叉树称为满二叉树。
 *              注：可以理解为满二叉树是个完全的三角形，完全二叉树为一个不完整的三角形
 *          先序遍历：根--左--又
 *          中序遍历：左--根--右
 *          后序遍历：左--右--根
 */
public class Answer {
    public static void main(String[] args) {
        //根据数组创建二叉树 根节点为数组的第一个元素
        int[] arr=new int[]{32,53,14,25,26,5,20,1,21,13};
        TreeNode rootTree=new TreeNode();
        List<TreeNode> treeList =new ArrayList<TreeNode>();
        treeList.add(rootTree);
        rootTree.setValue(arr[0]);
        for (int i=1;i<arr.length;i++) {
            boolean b = setLeftTree(rootTree, arr[i], treeList,false);
            if(!b){
                setRightTree(rootTree,arr[i],treeList,false);
            }
        }

        for (TreeNode treeNode : treeList) {
            System.out.println(treeNode.toString());
        }
    }

    private static boolean setLeftTree(TreeNode tree,int val,List<TreeNode> treeNodeList,boolean b){
        if(b){
           return b;
        }
        TreeNode leftTree = tree.getLeftTree();
        if(leftTree==null){
            if(val<tree.getValue().intValue()){
                leftTree=new TreeNode();
                leftTree.setValue(val);
                tree.setLeftTree(leftTree);
                treeNodeList.add(leftTree);
                b=true;
            }else if(val>tree.getValue().intValue()){
                b=setRightTree(tree,val,treeNodeList,b);
            }
        }else{
            b=setLeftTree(leftTree,val,treeNodeList,b);
        }
        return b;
    }

    private static boolean setRightTree(TreeNode tree,int val,List<TreeNode> treeNodeList,boolean b){
        if(b){
            return b;
        }
        TreeNode rightTree = tree.getRightTree();
        if(rightTree==null){
            if(val>tree.getValue().intValue()){
                rightTree=new TreeNode();
                rightTree.setValue(val);
                tree.setRightTree(rightTree);
                treeNodeList.add(rightTree);
                b=true;
            }else if(val<tree.getValue().intValue()) {
                b=setLeftTree(tree,val,treeNodeList,b);
            }
        }else{
            b=setRightTree(rightTree,val,treeNodeList,b);
        }
        return b;
    }
}
