package com.springapp.util.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by songlinwei on 17/12/26.
 */
public class ParserHtmlUtil {
    private static Logger logger = LoggerFactory.getLogger(ParserHtmlUtil.class);


    public static void main(String[] args) {
        String html = null;
        File file = new File("/Users/songlinwei/Downloads/GGP/chinahrindex.html");
        try {
            html = FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.toString();
        }
        readHtml("", html);
    }

    public static void readHtml(String seedUrl, String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div");
        int i = 0;
        for (Element element : elements) {
            logger.info("readHtml;sep;2;sep;logUuid;=;{};sep;seedUrl;=;{};sep;element;=;{}", null, seedUrl, element.text());
            if (i > 500) {
                break;
            }
        }
    }
}
