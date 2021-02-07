package demo.beans.algorithm;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-04 7:49 下午
 **/
public abstract class Node {

    private int value;

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }
}
