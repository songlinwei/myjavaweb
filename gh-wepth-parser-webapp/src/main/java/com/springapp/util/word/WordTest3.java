package com.springapp.util.word;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Created by songlinwei on 16/10/27.
*/
public class WordTest3 {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/songlinwei/Downloads/44根深蒂固第三方所谓的防守打法水电费.docx");
        try {
            FileInputStream fis = new FileInputStream(file);
            WordExtractor wordExtractor = new WordExtractor(fis);
            System.out.println("【 使用getText()方法提取的Word文件的内容如下所示：】");
            System.out.println(wordExtractor.getText());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        new WordTest3().testWrite();
    }


    public void testWrite() throws Exception {
        String templatePath = "/Users/songlinwei/home/data/testwei/zhaopin02ling.doc";
        InputStream is = new FileInputStream(templatePath);
        HWPFDocument doc = new HWPFDocument(is);
        Range range = doc.getRange();
        //把range范围内的${reportDate}替换为当前的日期
        range.replaceText("18698703860", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        range.replaceText("232103198508260440", "100.00");
        OutputStream os = new FileOutputStream("/Users/songlinwei/Downloads/zhaopin02lingwrite.doc");
        //把doc输出到输出流中
        doc.write(os);
        this.closeStream(os);
        this.closeStream(is);
        System.out.println("okokokokokokok");
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
