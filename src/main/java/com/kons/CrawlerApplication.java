package com.kons;

import com.kons.processor.DbProcessor;
import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
import com.kons.schedule.Schedule;
import com.kons.utils.HeroInfo;
import com.kons.utils.JsonModel;
import com.kons.spider.Spider;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CrawlerApplication {
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static final String DEFAULT_CHARSET = "GBK";

    public static void main(String[] args) throws Exception {
        fun();
    }

    private static void fun0() throws IOException {
        String host="https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js";

        URL url=new URL(host);
        URLConnection connection=url.openConnection();

        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("accept-charset",DEFAULT_CHARSET);
        connection.setRequestProperty("user-agent",DEFAULT_USER_AGENT);

        Map<String, List<String>> map=connection.getHeaderFields();

        String contentType=connection.getContentType();

        System.out.println(contentType);
        for (String key:map.keySet()){
            System.out.println(key + "--->" + map.get(key).get(0));
        }
    }

    private static void fun() throws Exception {
        HttpRequest request=new HttpRequest("https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js");
        Schedule.reqIn(request);

        Spider spider=new Spider();
        Thread thread=new Thread(spider);
        thread.start();

        HttpResponse response=Schedule.respOut();
        spider.stop();
        DbProcessor processor=new DbProcessor();
        processor.setaClass(JsonModel.class);
        processor.handler(response);

        JsonModel model=(JsonModel) processor.getModel();
        for (HeroInfo heroInfo:model.getHero())
            System.out.println(heroInfo.toString());
    }
}
