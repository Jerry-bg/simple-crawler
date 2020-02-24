package com.kons;

import com.kons.processor.DbProcessor;
import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
import com.kons.schedule.Schedule;
import com.kons.utils.HeroInfo;
import com.kons.utils.JsonModel;
import com.kons.spider.Spider;

public class CrawlerApplication {

    public static void main(String[] args) throws Exception {

    }

    private static void test() throws Exception {
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
