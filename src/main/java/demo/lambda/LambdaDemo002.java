package demo.lambda;

import demo.utils.JSONUtil;
import demo.beans.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo002 {

    @Test
    public void test001(){
        Stream stream = Stream.of("a","b","c","d","d");
//        stream.forEach(System.out::println);

        List<String> list = (List<String>) stream.distinct().collect(Collectors.toList());
        JSONUtil.print(list);

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
        JSONUtil.print(users);

        users = users.parallelStream().distinct().collect(Collectors.toList());
        JSONUtil.print(users);
    }

    @Test
    public void test003(){

    }

}
