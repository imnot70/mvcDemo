package demo.io.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author imnot
 */
public class InputDemo {

    private static final String END_CHAR = "end";

    public static void main(String[] args) {
        // scannerTest();
        inputStreamTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input some text,enter 'end' to escape");
        while (true) {
            String message = scanner.next();
            if (END_CHAR.equals(message)) {
                break;
            }
            System.out.println("message:" + message);
        }
        System.out.println("finish");
    }

    public static void inputStreamTest() {
        InputStream inputStream = System.in;
        System.out.println("input some text,enter 'end' to escape");
        while (true) {
            byte[] bytes = new byte[1024];
            try {
                int len = inputStream.read(bytes);
                // len-1 解决键盘输入的回车
                String message = new String(bytes, 0, len - 1, StandardCharsets.UTF_8);
                if (END_CHAR.equals(message)) {
                    break;
                }
                System.out.println("message:" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finish");
    }
}
