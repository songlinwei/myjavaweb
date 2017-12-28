package com.springapp.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.UUID;

/**
 * Created by songlinwei on 17/12/26.
 */
public class ParserExcelUtil {
    private static Logger logger = LoggerFactory.getLogger(ParserExcelUtil.class);

    private static final String COLUMN_SPLIT = ";s;";
    private static final String EXTENSION_XLS = "xls";
    private static final String EXTENSION_XLSX = "xlsx";

    /**
     * 读取excel文件内容
     *
     * @param filePath
     * @throws java.io.FileNotFoundException
     * @throws FileFormatException
     */
    public void readExcel(String filePath) throws FileNotFoundException, FileFormatException {
        String logUuid = UUID.randomUUID().toString();
        logger.info(";sep;1;sep;logUuid;=;{};sep;filePath;=;{}", logUuid, filePath);
        // 检查
        this.preReadCheck(filePath);
        // 获取workbook对象
        Workbook workbook = null;
        try {
            workbook = this.getWorkbook(filePath);
            // 读文件 一个sheet一个sheet地读取
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                logger.info(";sep;2;sep;logUuid;=;{};sep;filePath;=;{};sep;page;=;{};sep;pagename;=;{}", logUuid, filePath, numSheet, sheet.getSheetName());
                int firstRowIndex = sheet.getFirstRowNum();
                int lastRowIndex = sheet.getLastRowNum();

                // 读取首行 即,表头
                Row firstRow = sheet.getRow(firstRowIndex);
                if (firstRow != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int firstColumnIndex = firstRow.getFirstCellNum(); // 首列
                    int lastColumnIndex = firstRow.getLastCellNum();// 最后一列
                    for (int i = firstColumnIndex; i <= lastColumnIndex; i++) {
                        Cell cell = firstRow.getCell(i);
                        String cellValue = this.getCellValue(cell, true);
                        if (i == lastColumnIndex) {
                            stringBuilder.append(cellValue);
                        } else {
                            stringBuilder.append(cellValue).append(COLUMN_SPLIT);
                        }
                    }
                    logger.info(";sep;3;sep;logUuid;=;{};sep;filePath;=;{};sep;page;=;{};sep;pagename;=;{};sep;head1;=;{}", logUuid, filePath, numSheet, sheet.getSheetName(), stringBuilder.toString());
                }

                // 读取数据行
                for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
                    Row currentRow = sheet.getRow(rowIndex);// 当前行
                    if (currentRow != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder stringBuilderNormal = new StringBuilder();
                        int firstColumnIndex = currentRow.getFirstCellNum(); // 首列
                        int lastColumnIndex = currentRow.getLastCellNum();// 最后一列
                        for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) {
                            Cell currentCell = currentRow.getCell(columnIndex);// 当前单元格
                            String currentCellValue = this.getCellValue(currentCell, true);// 当前单元格的值
                            if (columnIndex == lastColumnIndex) {
                                stringBuilder.append(currentCellValue);
                            } else {
                                stringBuilder.append(currentCellValue).append(COLUMN_SPLIT);
                            }
                            stringBuilderNormal.append(currentCellValue);
                        }
                        logger.info(";sep;4;sep;logUuid;=;{};sep;filePath;=;{};sep;page;=;{};sep;pagename;=;{};sep;head1;=;{}", logUuid, filePath, numSheet, sheet.getSheetName(), stringBuilder.toString());

                    }
                }
                logger.info(";sep;5;sep;logUuid;=;{};sep;filePath;=;{};sep;page;=;{};sep;pagename;=;{};sep;end", logUuid, filePath, numSheet, sheet.getSheetName());
            }
        } catch (Exception e) {
            logger.warn(";sep;6;sep;logUuid;=;{};sep;filePath;=;{} {}:{}", logUuid, filePath, e.getClass().getName(), e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    logger.warn(";sep;7;sep;logUuid;=;{};sep;filePath;=;{} {}:{}", logUuid, filePath, e.getClass().getName(), e);
                }
            }
        }

    }

    /**
     * <pre>
     * 取得Workbook对象(xls和xlsx对象不同,不过都是Workbook的实现类)
     *   xls:HSSFWorkbook
     *   xlsx：XSSFWorkbook
     *
     * @param filePath
     * @return
     * @throws IOException </pre>
     */
    private Workbook getWorkbook(String filePath) throws IOException {
        Workbook workbook = null;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(EXTENSION_XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (filePath.endsWith(EXTENSION_XLSX)) {
            workbook = new XSSFWorkbook(is);
        }
        return workbook;
    }

    /**
     * 文件检查
     *
     * @param filePath
     * @throws java.io.FileNotFoundException
     * @throws org.apache.xmlbeans.impl.piccolo.io.FileFormatException
     */
    private void preReadCheck(String filePath) throws FileNotFoundException, FileFormatException {
        // 常规检查
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("传入的文件不存在：" + filePath);
        }

        if (!(filePath.endsWith(EXTENSION_XLS) || filePath.endsWith(EXTENSION_XLSX))) {
            throw new FileFormatException("传入的文件不是excel");
        }
    }

    /**
     * 取单元格的值
     *
     * @param cell       单元格对象
     * @param treatAsStr 为true时，当做文本来取值 (取到的是文本，不会把“1”取成“1.0”)
     * @return
     */
    private String getCellValue(Cell cell, boolean treatAsStr) {
        if (cell == null) {
            return "";
        }
        if (treatAsStr) {
            // 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
            // 加上下面这句，临时把它当做文本来读取
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }


    /**
     * 需要用到和大街字典匹配的字符串使用本方法过滤 用来去除特殊格式空格
     *
     * @param input
     * @return
     */
    private String cleanUnNormalChar(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((c[i] >= '\uFF10' && c[i] <= '\uFF19')//全角数字
                    || (c[i] >= '\uFF21' && c[i] <= '\uFF3A')//全角大写英文字符
                    || (c[i] >= '\uFF41' && c[i] <= '\uFF5A')//全角小写英文字符
                    ) {
                c[i] = (char) (c[i] - '\uFEE0');
            }
            boolean isNormalChar = (c[i] >= '\u4E00' && c[i] <= '\u9f9f') //常用汉字
                    || (c[i] >= '\u0030' && c[i] <= '\u0039') //半角数字
                    || (c[i] >= '\u0041' && c[i] <= '\u005A') //半角大写字母
                    || (c[i] >= '\u0061' && c[i] <= '\u007A');//半角小写字母
            if (!isNormalChar) {
                c[i] = ' ';
            }
        }

        return new String(c).replaceAll("[ ]*", "");
    }


    public static void main(String[] args) {
        System.out.println("hello word1");
        try {
            new ParserExcelUtil().readExcel("/Users/songlinwei/home/build/非工作/职位评级标准58/58赶集 - 行为标准 - 前台开发.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FileFormatException e) {
            e.printStackTrace();
        }
        System.out.println("hello word2");
    }
}
