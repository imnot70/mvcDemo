package demo.Utils;

import com.alibaba.fastjson.JSONObject;

public class JSONUtil {
    public static void print(Object obj){

        System.out.println(JSONObject.toJSONString(obj));

    }
}
