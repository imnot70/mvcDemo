package demo.Utils;

import demo.beans.BasicBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * create Object with random id
 */
public class RandomIdUtil {

    public static <T extends BasicBean> List<T> createRandomIdObjectList(Class<T> tClass, int count,int maxId){

        List<T> objList = new ArrayList<>();

        if(count<=0){
            return objList;
        }

        Random random = new Random();

        for(int i= 0;i<count;i++){
            try {
                T obj = tClass.newInstance();
                int id = random.nextInt(maxId);
                obj.setId(id);
                objList.add(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return objList;
    }

}
