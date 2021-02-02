package demo.lambda;

import com.alibaba.fastjson.JSONObject;
import demo.beans.BasicBean;
import demo.utils.EmailUtils;
import demo.utils.JsonUtil;
import demo.utils.RandomIdUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author imnot
 */
public class LambdaDemo001 {

    private List<BasicBean> idList = null;

    @Before
    public void prepared(){
        idList = RandomIdUtil.createRandomIdObjectList(BasicBean.class,10,100);
        JsonUtil.fastJsonPrint(idList);
        System.out.println("============================");
    }

    @After
    public void finished(){
        System.out.println("============================");
        JsonUtil.fastJsonPrint(idList);
    }

    @Test
    public void test001(){

        System.out.println(JSONObject.toJSONString(idList));

        // 排序
        List<BasicBean> sortedList = idList.parallelStream().sorted(Comparator.comparing(BasicBean::getId)).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(sortedList));

        // 反转
        List<BasicBean> reverseList = idList.parallelStream().sorted(Comparator.comparing(BasicBean::getId).reversed()).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(reverseList));
    }

    @Test
    public void test002(){

        JsonUtil.fastJsonPrint(idList);
        idList = idList.parallelStream().sorted(Comparator.comparing(BasicBean::getId)).collect(Collectors.toList());
        JsonUtil.fastJsonPrint(idList);

    }

    @Test
    public void test003(){

        idList = idList.parallelStream().filter(b -> b.getId() > 10).collect(Collectors.toList());
    }

    @Test
    public void test004(){
        int sum = idList.parallelStream().filter(b -> b.getId() > 10).mapToInt(b->b.getId()).sum();
        System.out.println(sum);
    }

    @Test
    public void test005(){
        try {
            EmailUtils.sendEmail("longlongniu@ireadyit.com",",这是测试内容");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test006(){
        idList.parallelStream().filter(i -> i.getId() % 2 == 1).forEach(i -> System.out.println(i.getId()));
    }

    @Test
    public void test007(){
        idList = idList.parallelStream().skip(3).collect(Collectors.toList());
    }

    @Test
    public void test008(){

    }

}
