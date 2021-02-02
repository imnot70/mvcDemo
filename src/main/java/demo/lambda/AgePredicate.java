package demo.lambda;



import demo.beans.User;

import java.util.Calendar;
import java.util.function.Predicate;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-03 9:09 下午
 **/
public class AgePredicate implements Predicate<User> {
    @Override
    public boolean test(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-10);
        return user.getBirthday().after(calendar.getTime());
    }
}
