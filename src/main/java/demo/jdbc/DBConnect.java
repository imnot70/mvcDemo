package demo.jdbc;

import demo.utils.SSLClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author imnot
 */
public class DBConnect {
	
	private static final String URL = "jdbc:mysql://192.168.88.140/wodpoc?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL";
	private static final String USER_NAME = "roor";
	private static final String PASSWORD = "123456";
	
	public static void main(String[] args) throws Exception {
		
		DBConnect dbc = new DBConnect();
		DBConnect.httpDownloadFile("https://www.thfof.com/?/api/csv/", "/Users/zhangpeng/Downloads/PEPMFundMsg.zip","key=c082edad37b18bcb7084e8963df8a70f0ddb6711");
	}
	
	/**
     * 下载文件
     *
     * @param url
     * @param filePath
     */
    @SuppressWarnings("unused")
	public static void httpDownloadFile(String url, String filePath,
                                        String param) {
        CloseableHttpClient httpclient = null;
        try {
            httpclient = new SSLClient();
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(param, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(entity);
            CloseableHttpResponse response1 = httpclient.execute(httpPost);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity httpEntity = response1.getEntity();
                InputStream is = httpEntity.getContent();
                // 根据InputStream 下载文件
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int r = 0;
                long totalRead = 0;
                while ((r = is.read(buffer)) > 0) {
                    output.write(buffer, 0, r);
                    totalRead += r;
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                output.writeTo(fos);
                output.flush();
                output.close();
                fos.close();
                EntityUtils.consume(httpEntity);
            } finally {
                response1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
