package demo.reflect;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Enumeration;

public class LoadClass {
    private static final String URL = "jdbc:mysql://localhost:3306/mybatis";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public static void main(String[] args) throws Exception {
        LoadClass loadClass = new LoadClass();
//        loadClass.loadClass("mvc.controller");
        loadClass.testPreparedStatement();
    }

    public void testPreparedStatement() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_NAME);
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        String sql = "select * from items where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "1 or 1=1");
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery();
            System.out.println(resultSet);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            statement.close();
            connection.close();
        }
    }

    public void loadClass(String basePath) throws IOException, URISyntaxException, ClassNotFoundException {
        String baseFilePath = basePath.replace(".", "/");
        System.out.println("baseFilePath:" + baseFilePath);
        ClassLoader loader = this.getClass().getClassLoader();
        Enumeration<URL> classes = loader.getResources(baseFilePath);
        System.out.println("classes:" + classes);
        if (classes != null) {
            while (classes.hasMoreElements()) {
                URL classUrl = classes.nextElement();
                System.out.println(classUrl.toString());
                File classFile = new File(classUrl.toURI());
                String[] fileList = classFile.list((dir, name) -> name.endsWith("class"));
                if (fileList != null) {
                    for (String fileName : fileList) {
                        String classFullName = basePath + "." + fileName;
                        System.out.println(classFullName);
                        Class c = Class.forName(classFullName);
                        System.out.println(c);
                    }
                }
            }
        }
    }
}
