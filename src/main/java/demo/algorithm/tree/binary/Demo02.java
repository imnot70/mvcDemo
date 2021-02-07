package demo.algorithm.tree.binary;

import demo.beans.algorithm.BinaryTreeNode;
import demo.utils.JsonUtil;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-05 7:15 下午
 **/
public class Demo02 {

    private static int[] arr = {5, 3, 4, 1, 6, 8, 7};

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        for (int i = 1; i < arr.length; i++) {
            createTree(root, new BinaryTreeNode(arr[i]));
        }

        JsonUtil.jackPrint(root);
    }

    private static void createTree(BinaryTreeNode root, BinaryTreeNode node) {
        if (root != null) {
            if (root.getValue() > node.getValue()) {
                if (root.getLeftChild() != null) {
                    createTree(root.getLeftChild(), node);
                } else {
                    root.setLeftChild(node);
                }
            }
            if (root.getValue() < node.getValue()) {
                if (root.getRightChild() != null) {
                    createTree(root.getRightChild(), node);
                } else {
                    root.setRightChild(node);
                }
            }
        }
    }
}
