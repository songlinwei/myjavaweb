package com.springapp.util.word;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * Created by songlinwei on 16/10/28.
 */
public class WordDom4jTest1 {
    public static void main(String[] args) {
        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(new File("/Users/songlinwei/Downloads/testwei/dajie6253311.doc"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = bookStore.elementIterator();
            // 遍历迭代器，获取根节点中的信息（书籍）
            while(it.hasNext()){
                System.out.println("==========开始遍历某一本书==========");
                Element book = (Element)it.next();
//                List<Attribute> bookAttrs = book.attributes();
//                for(Attribute attr:bookAttrs){
//                    System.out.println("属性："+attr.getName()+"---值："+attr.getValue());
//                }

                Iterator itt = book.elementIterator();
                while(itt.hasNext()){
                    Element node = (Element)itt.next();
                    System.out.println("节点：" + node.getName() + "---值：" + node.getStringValue());
                }
                System.out.println("==========结束遍历某一本书==========");
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
