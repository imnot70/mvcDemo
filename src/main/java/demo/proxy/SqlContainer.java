package demo.proxy;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author imnot
 */
public class SqlContainer {
    private static final String SEPARATOR_EQUALS = "=";
    private static final ConcurrentHashMap<String,String> SQL_CONTAINER= new ConcurrentHashMap<>();

    private SqlContainer(){}

    public static void addSql(String sqlName,String sqlContent){
        if(SQL_CONTAINER.containsKey(sqlName)){
            throw new IllegalArgumentException("sql:[ "+sqlName+" ] already exists");
        }
        SQL_CONTAINER.put(sqlName, sqlContent);
    }

    public static void addSql(String sqlNameContent){
        if(sqlNameContent != null && sqlNameContent.length() !=0){
            String[] strings = sqlNameContent.split(SEPARATOR_EQUALS);
            addSql(strings[0],strings[1]);
        }
    }

    public static String getSql(String sqlName){
        if(!SQL_CONTAINER.containsKey(sqlName)){
            throw new IllegalArgumentException("sql:[ "+sqlName+" ] not exists");
        }
        return SQL_CONTAINER.get(sqlName);
    }

}
