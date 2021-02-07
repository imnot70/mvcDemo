package demo.temp;

import demo.beans.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpeng
 * @description
 * @date 2021-02-04 6:25 下午
 **/
public class Demo04 {

    public static void main(String[] args) throws InterruptedException {
        List<User> users = new ArrayList<>();
        while(true){
            users.add(new User());
            Thread.sleep(50);
        }
    }
}
