package com.springapp.util.word;


import org.apache.poi.POIXMLProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
* Created by songlinwei on 16/10/27.
*/
public class WordTest2 {
    public static void main(String[] args){
        System.out.println("--------wwwww");
        try {
            new WordTest2().testReadByExtractor();
        } catch (Exception e) {
            System.out.println("---------erere");
            e.printStackTrace();
        }
    }

    /**
     * 通过XWPFWordExtractor访问XWPFDocument的内容
     * @throws Exception
     */
    public void testReadByExtractor() throws Exception {
        InputStream is = new FileInputStream("/Users/songlinwei/Downloads/testwei/zhaopin02.docx");
        XWPFDocument doc = new XWPFDocument(is);
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text = extractor.getText();
        System.out.println(text);
//        POIXMLProperties.CoreProperties coreProps = extractor.getCoreProperties();
//        this.printCoreProperties(coreProps);
        this.close(is);
    }

    /**
     * 输出CoreProperties信息
     * @param coreProps
     */
    private void printCoreProperties(POIXMLProperties.CoreProperties coreProps) {
        System.out.println(coreProps.getCategory());   //分类
        System.out.println(coreProps.getCreator()); //创建者
        System.out.println(coreProps.getCreated()); //创建时间
        System.out.println(coreProps.getTitle());   //标题
    }

    /**
     * 关闭输入流
     * @param is
     */
    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
