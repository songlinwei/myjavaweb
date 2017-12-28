package com.springapp.util.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * itextpdf方式读取pdf
 * Created by songlinwei on 17/12/26.
 */
public class ParserPdfUtil {
    private static Logger logger = LoggerFactory.getLogger(ParserPdfUtil.class);

    /**
     * Main method.
     *
     * @param args no arguments needed
     * @throws com.itextpdf.text.DocumentException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws DocumentException, IOException {
        String string = "/Users/songlinwei/Downloads/testwei/dajiezuowei20161027031554660.pdf";//pdf文件路径
        inspectPrint(string); //调用读取方法
    }


    /**
     * Inspect a PDF file and write the info to a txt file
     *
     * @param filename Path to the PDF file
     * @throws java.io.IOException
     */
    public static void inspectPrint(String filename) throws IOException {
        PdfReader reader = new PdfReader(filename); //读取pdf所使用的输出流
        int num = reader.getNumberOfPages();//获得页数
        //存放读取出的文档内容
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < num; i++) {
            stringBuilder.append(PdfTextExtractor.getTextFromPage(reader, i));//读取第i页的文档内容
        }
        logger.info("{}", stringBuilder.toString());
    }

}
