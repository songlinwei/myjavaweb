package com.springapp.util.word;

import com.itextpdf.text.io.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Created by songlinwei on 16/10/28.
 */
public class Test1 {

    public static void main(String[] args) {
        String filename = "/Users/songlinwei/Downloads/testwei/51job我的简历1.doc";
//        File file = new File(filename);
//        if(!file.canRead()) {
//            return !filename.startsWith("file:/") && !filename.startsWith("http://") && !filename.startsWith("https://") && !filename.startsWith("jar:") && !filename.startsWith("wsjar:") && !filename.startsWith("wsjar:") && !filename.startsWith("vfszip:")?this.createByReadingToMemory((String)filename):this.createSource((URL)(new URL(filename)));
//        } else {
//
//        }
        Test1.readFileByRandomAccess(filename);
    }

    /**
     * 随机读取文件内容
     *
     * @param fileName 文件名
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }


    private boolean createByReadingToMemory(InputStream is) {

        try {
            if (StreamUtil.inputStreamToArray(is) != null) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
