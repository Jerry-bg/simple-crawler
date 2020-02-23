package com.kons.spider;

import com.kons.downloader.DownLoader;
import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
import com.kons.schedule.Schedule;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Spider implements Runnable{

    private volatile boolean stop;
    private long timeOut = -1;
    private TimeUnit unit;

    public Spider(){
        this.stop=false;
    }

    public Spider(long timeOut,TimeUnit unit){
        this.timeOut=timeOut;
        this.unit=unit;
        this.stop=false;
    }

    public void run() {
        while(true) {
            if(stop)
                break;
            try {
                HttpRequest request = Schedule.reqOut();
                DownLoader downLoader = new DownLoader();
                HttpResponse resp = downLoader.download(request);
                Schedule.respIn(resp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                await();
            }
        }
    }

    public void stop(){
        this.stop = true;
    }

    private void await() {
        if(timeOut > 0) {
            long end = System.nanoTime() + unit.toNanos(timeOut);
            for (; ; ) {
                if (System.nanoTime() == end) {
                    this.stop = true;
                    break;
                }
            }
        }
    }
}
