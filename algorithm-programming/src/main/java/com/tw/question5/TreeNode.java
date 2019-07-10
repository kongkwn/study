package com.tw.question5;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 18:17 2019/7/4
 */
public class TreeNode {
    private TreeNode leftTree;
    private TreeNode rightTree;
    private Integer value;

    public TreeNode getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(TreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public TreeNode getRightTree() {
        return rightTree;
    }

    public void setRightTree(TreeNode rightTree) {
        this.rightTree = rightTree;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftTree=" + leftTree +
                ", rightTree=" + rightTree +
                ", value=" + value +
                '}';
    }
}
