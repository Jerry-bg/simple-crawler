package com.kons;

import com.alibaba.fastjson.JSON;
import com.kons.processor.DbProcessor;
import com.kons.processor.DefaultProcessor;
import com.kons.processor.Processor;
import com.kons.request.HttpGetRequest;
import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
import com.kons.schedule.Schedule;
import com.kons.utils.JsonModel;
import com.kons.utils.Spider;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

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

        for (String key:map.keySet()){
            System.out.println(key + "--->" + map.get(key).get(0));
        }
    }

    private static void fun() throws Exception {
        HttpRequest request=new HttpRequest("https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js");
        Schedule.reqIn(request);

        Thread thread=new Thread(new Spider());
        thread.start();

        HttpResponse response=Schedule.respOut();

        DbProcessor processor=new DbProcessor();
        processor.setaClass(JsonModel.class);
        processor.handler(response);

        JsonModel model=(JsonModel) processor.getModel();
        for (HeroInfo heroInfo:model.getHero())
            System.out.println(heroInfo.toString());
    }
}
