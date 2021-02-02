package demo.lambda;

import demo.beans.User;

import java.util.function.Predicate;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-03 9:08 下午
 **/
public class AddressPredicate implements Predicate<User> {
    @Override
    public boolean test(User user) {
        return user.getAddress().contains("A");
    }
}
