package demo.proxy;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author imnot
 */
public class SqlFileLoader {

    public static void main(String[] args) {
        read();
        System.out.println(SqlContainer.getSql("getOne"));
    }

    public static void read(){
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Code\\Java\\mvcDemo\\src\\main\\resources\\sql.sql"))){
            String line;
            while((line = reader.readLine()) != null){
                SqlContainer.addSql(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
