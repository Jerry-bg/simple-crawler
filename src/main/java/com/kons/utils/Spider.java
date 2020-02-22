package com.kons.utils;

import com.kons.downloader.DownLoader;
import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
import com.kons.schedule.Schedule;

import java.io.IOException;

public class Spider implements Runnable{

    public void run() {
        try {
            HttpRequest request = Schedule.reqOut();
            DownLoader downLoader=new DownLoader();
            HttpResponse resp=downLoader.download(request);
            Schedule.respIn(resp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
