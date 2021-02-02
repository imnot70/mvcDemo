package demo.utils;

import java.io.File;

/**
 * @author imnot
 */
public class FileUtil {

    public static void main(String[] args) {
        String sourcePath = "G:\\Doc\\Files\\real_guro\\seppuku\\";
        String prefix = "real_";
        String subName = "Seppuku";
//        String targetDir = sourcePath + "\\" + subName +"\\";
        File file = new File(sourcePath);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i=1;i<=files.length;i++) {
                File f = files[i-1];
                if (f.isDirectory()) {
                    continue;
                }
//                System.out.println(f.getName());
//                System.out.println();
                // TODO 没有扩展名
//                File newFile = new File(sourcePath + prefix + subName + "_" + f.getName());
                File newFile = new File(sourcePath + subName + "_" + f.getName());
                boolean result = f.renameTo(newFile);
                System.out.println(result);
            }
        } else {
            System.out.println("files is null");
        }
    }

}
