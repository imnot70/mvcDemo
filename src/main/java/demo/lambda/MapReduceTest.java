package demo.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.beans.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-03 8:37 下午
 **/
public class MapReduceTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<>();
        for(int i=1;i<=20;i++){
            User user = new User();
            if(i<10){
                user.setName("user_0"+i);
            }else{
                user.setName("user_"+i);
            }
            user.setAddress(randomString()).setBirthday(getDate(i));
            userList.add(user);
        }
        System.out.println(mapper.writeValueAsString(userList));
        List<User> result1 = userList.stream().filter(user -> user.getName().contains("0")).collect(Collectors.toList());
        System.out.println(mapper.writeValueAsString(result1));

        // 过滤器链
        List<Predicate<User>> predicates = new ArrayList<>();

        // 加条件判断添加
        predicates.add(new AddressPredicate());
        predicates.add(new AgePredicate());

    }

    private static String randomString(){
        String[] chars = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++){
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString();
    }

    private static Date getDate(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,-num);
        return calendar.getTime();
    }

}

