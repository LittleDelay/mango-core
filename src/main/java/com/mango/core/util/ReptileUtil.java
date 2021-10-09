package com.mango.core.util;

import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

/**
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/10/9 14:30
 */
public class ReptileUtil {

    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";

    private static final String regex = "^(?:https?://)?[\\w]{1,}(?:\\.?[\\w]{1,})+[\\w-_/?&=#%:]*$";

    private static final String baseurl = "http://www.netbian.com/";

    private static final String geturl = "http://www.netbian.com/desk/18321.htm";

    private static final String filepath = "D:\\IMG\\";

    public static void main(String[] args) {
        System.out.println("初始下载页面：" + geturl);
        //html页面内容
        String html = getHtml(geturl);
        //图片地址集合
        List<String> srclists = getImgSrcListFromHtml(html);
        //下载图片
        downloadImg(srclists, filepath);
        //获取下一个页面进行下载
        List<String> list = getNextPageUrl(html);
        System.out.println(list.size());
        for (String url : list) {
            System.out.println("下一个下载页面：" + url);
            //html页面内容
            String html2 = getHtml(url);
            //图片地址集合
            List<String> srclists2 = getImgSrcListFromHtml(html2);
            //下载图片
            if (CollectionUtils.isEmpty(srclists2)){
                continue;
            }
            downloadImg(srclists2, filepath);
        }
        System.out.println("下载完毕");
    }

    /**
     * @param url 路径
     * @return String  返回类型
     */
    public static String getHtml(String url) {
        String html = "";
        try {
            html = Jsoup.connect(url).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }

    /**
     * @param html 页面内容
     * @return 图片路径数组
     */
    public static List<String> getImgSrcListFromHtml(String html) {
        List<String> list = new ArrayList<>();
        //解析成html页面
        Document document = Jsoup.parse(html);
        //获取目标
        Elements elements = document.select("div [class=pic]").select("img");
        for (org.jsoup.nodes.Element element : elements) {
            if (StringUtils.hasText(element.attr("src"))){
                list.add(element.attr("src"));
            }
        }
        return list;
    }

    /**
     * @param html 页面内容
     * @return List<String>  返回页面url数组
     */
    public static List<String> getNextPageUrl(String html) {
        List<String> list = new ArrayList<>();
        //解析成html页面
        Document document = Jsoup.parse(html);
        //获取目标
        Elements elements = document.select("div [class=list]").select("a");
        for (int i = 0; i < elements.size(); i++) {
            String href = elements.get(i).attr("href");
            String url = baseurl + href;
            if (href.contains("http")){
                list.add(href);
            }else {
                list.add(url);
            }
        }
        return list;
    }

    /**
     * @param list     图片路径数组
     * @param filepath 保存文件夹位置
     * @Description: 下载图片 -- 通过获取的流转成byte[]数组，再通过FileOutputStream写出
     */
    public static void downloadImg(List<String> list, String filepath) {
        URL newUrl;
        HttpURLConnection hconnection;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] bs;
        try {
            int len = list.size();
            for (int i = 0; i < len; i++) {
                newUrl = new URL(list.get(i));
                //打开连接
                hconnection = (HttpURLConnection) newUrl.openConnection();
                //获取流
                inputStream = hconnection.getInputStream();
                //流转btye[]
                bs = getBytesFromInputStream(inputStream);
                //获取图片名称
                filepath = filepath + list.get(i).substring(list.get(i).lastIndexOf("/") + 1);
                System.out.println("生成图片路径:" + filepath);
                fileOutputStream = new FileOutputStream(filepath);
                //写出
                fileOutputStream.write(bs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param inputStream 流
     * @return  byte[]    返回类型
     * @Description: InputStream流转换byte[]
     */
    public static byte[] getBytesFromInputStream(InputStream inputStream) {
        byte[] bs = null;
        try {
            byte[] buffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                arrayOutputStream.write(buffer, 0, len);
            }
            bs = arrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bs;
    }

}
