package demo.Utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static void main(String[] args) {
        List<String> map = readXls("C:\\Users\\imnot\\Desktop\\importTest.xls");
        System.out.println(JSONObject.toJSONString(map));
    }

    public static List<String> readXls(String fileName) {
        List<String> list = new ArrayList<String>();
        try {
            InputStream is = new FileInputStream(fileName);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                List<String> singleRow = new ArrayList<String>();
                for(int column=0;column<1;column++){
                    Cell cell = hssfRow.getCell(column);
                    singleRow.add(cell.getStringCellValue().trim());
                }
                list.add(singleRow.get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
