package demo.temp;

import demo.beans.User;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-04 5:51 下午
 **/
public class Demo03 {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge(10);
        User user2 = user1;
        System.out.println("user1.age:" + user1.getAge() + ",user2.age:" + user2.getAge());

        user2.setAge(20);
        System.out.println("user1.age:" + user1.getAge() + ",user2.age:" + user2.getAge());
    }
}
