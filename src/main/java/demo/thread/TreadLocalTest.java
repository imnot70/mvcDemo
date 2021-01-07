package demo.thread;

import demo.beans.User;

public class TreadLocalTest {
    public static void main(String[] args) {
        User userA = new User().setName("A");
        User userB = new User().setName("B");

        ThreadLocal<User> userHolder = new ThreadLocal<>();
        userHolder.set(userA);
        userHolder.set(userB);
        User user1 = userHolder.get();
        System.out.println(user1.getName());
        userHolder.remove();
    }
}
