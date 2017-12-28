package com.springapp.util.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Pdfbox 方式读取pdf
 * Created by songlinwei on 17/12/26.
 */
public class ParserPdfboxUtil {
    private static Logger logger = LoggerFactory.getLogger(ParserPdfboxUtil.class);

    public static void main(String[] args) {
        File pdfFile = new File("/Users/songlinwei/Downloads/testwei/dajiezuowei20161027031554660.pdf");
        PDDocument document = null;
        try {
            // 方式一：
            /**
             InputStream input = null;
             input = new FileInputStream( pdfFile );
             //加载 pdf 文档
             PDFParser parser = new PDFParser(new RandomAccessBuffer(input));
             parser.parse();
             document = parser.getPDDocument();
             **/

            // 方式二：
            document = PDDocument.load(pdfFile);
            // 获取页码
            int pages = document.getNumberOfPages();
            // 读文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            String content = stripper.getText(document);
            logger.info("{}", content);
        } catch (Exception e) {
            logger.info("{}:{}", e.getClass().getName(), e);
        }

    }

}
