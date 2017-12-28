package com.springapp.util.txt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by songlinwei on 17/12/26.
 */
public class ParserFileUtil {
    private static Logger logger = LoggerFactory.getLogger(ParserFileUtil.class);

    public static void writerTxtFile(String filePath, String str) {
        try {
            File file = new File(filePath);
            if (!file.exists())
                file.createNewFile();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            FileOutputStream out = new FileOutputStream(file, false); //如果追加方式用true
            StringBuffer sb = new StringBuffer();
            sb.append("------------").append(sdf.format(new Date())).append("------------\n").append(str).append("\n");
            out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
            out.close();
        } catch (IOException e) {
            logger.info(";sep;1;sep;filePath;=;{}", e.getClass().getName());
        }
    }


    /*
     * 通过递归得到某一路径下所有的目录及其文件
     */
    public static void getFiles(String filePath) {
        File root = new File(filePath);
        File[] files = root.listFiles();
        int i = 0;
        for (File file : files) {
            String filePathAb = file.getAbsolutePath();
            logger.info(";sep;1;sep;filePath;=;{};sep;i;=;{}", filePathAb, i++);
            if (file.isDirectory()) {
                logger.info(";sep;2;sep;filePath;=;{};sep;i;=;{}", filePathAb, i);
                getFiles(filePathAb);
            } else {
                logger.info(";sep;3;sep;filePath;=;{};sep;i;=;{}", filePathAb, i);
                readTxtFile(file);
            }
        }
    }

    public static List<String> readTxtFile(File file) {
        List<String> txtStrList = new ArrayList<String>();
        try {
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    logger.info(";sep;1;sep;lineTxt;=;{}", lineTxt);
                    txtStrList.add(lineTxt);
                }
                read.close();
            } else {
                logger.info(";sep;1;sep;filePath;=;{}", "找不到指定的文件");
            }
        } catch (Exception e) {
            logger.info(";sep;1;sep;filePath;=;{}", "读取文件内容出错");
        }
        return txtStrList;
    }

    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     *
     * @param filePath
     */
    public static List<String> readTxtFile(String filePath) {
        File file = new File(filePath);
        return readTxtFile(file);
    }

    public static void main(String[] args) {
        String string = "/Users/songlinwei/home/build/工作/解析ewp需求拉新简历库运营组贺涛产品正义组负责页面/导入格式目录模版给贺涛让他按这个目录格式真理源文件rpo";
        getFiles(string); //调用读取方法
    }

}
