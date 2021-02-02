package demo.lambda;

import demo.beans.User;
import demo.utils.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author imnot
 */
public class LambdaDemo002 {

    @Test
    public void test001(){
        Stream stream = Stream.of("a","b","c","d","d");
//        stream.forEach(System.out::println);

        List<String> list = (List<String>) stream.distinct().collect(Collectors.toList());
        JsonUtil.fastJsonPrint(list);

    }

    @Test
    public void test002(){
        User user = new User("A",10,5000.0);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);
        users.add(user);
        User user1 = new User("B",11,6000.0);
        users.add(user1);
        JsonUtil.fastJsonPrint(users);

        users = users.parallelStream().distinct().collect(Collectors.toList());
        JsonUtil.fastJsonPrint(users);
    }

    @Test
    public void test003(){

    }

}
