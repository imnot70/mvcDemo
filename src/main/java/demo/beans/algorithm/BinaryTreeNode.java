package demo.beans.algorithm;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-04 7:51 下午
 **/
public class BinaryTreeNode extends Node{

    private BinaryTreeNode parent;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        super.setValue(value);
    }

    public BinaryTreeNode(BinaryTreeNode parent, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode setParent(BinaryTreeNode parent) {
        this.parent = parent;
        return this;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public BinaryTreeNode setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
        return this;
    }
}
