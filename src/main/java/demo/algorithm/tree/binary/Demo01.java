package demo.algorithm.tree.binary;

import demo.beans.algorithm.BinaryTreeNode;
import demo.utils.JsonUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-04 7:54 下午
 **/
public class Demo01 {

    private static final List<BinaryTreeNode> TREE = new LinkedList<>();

    public static void main(String[] args) {

        int[] arr = {5,3,4,1,6,8,7};
        for(int v:arr){
            createTree(v);
        }
        JsonUtil.jackPrint(TREE);
    }

    public static void createTree(int value) {
        addNode(TREE.size() == 0 ? null : TREE.get(0), new BinaryTreeNode(value));
    }

    private static void addNode(BinaryTreeNode root, BinaryTreeNode node) {
        if (root == null) {
            // 仅在第一次添加数据时生效
            TREE.add(node);
        } else {
            // 判断root的值和node的值
            if (root.getValue() > node.getValue()) {
                // 左侧赋值逻辑
                // 判断root的左孩子是否为null，不为null递归调用addNode
                if (root.getLeftChild() != null) {
                    addNode(root.getLeftChild(), node);
                } else {
                    // 左孩子
                    root.setLeftChild(node);
                }
            }
            if (root.getValue() < node.getValue()) {
                // 右侧赋值逻辑同左侧
                if (root.getRightChild() != null) {
                    addNode(root.getRightChild(), node);
                } else {
                    root.setRightChild(node);
                }
            }

        }
    }

}
