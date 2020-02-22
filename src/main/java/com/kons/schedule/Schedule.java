package com.kons.schedule;

import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Schedule {
    public static LinkedBlockingQueue<HttpRequest> requestQueue=new LinkedBlockingQueue<HttpRequest>();
    public static LinkedBlockingQueue<HttpResponse> responsesQueue= new LinkedBlockingQueue<HttpResponse>();

    public static HttpRequest reqOut() throws InterruptedException {
        return requestQueue.take();
    }

    public static void reqIn(HttpRequest request) throws InterruptedException {
        requestQueue.put(request);
    }

    public static HttpResponse respOut() throws InterruptedException {
        return responsesQueue.take();
    }

    public static void respIn(HttpResponse response) throws InterruptedException{
        responsesQueue.put(response);
    }
}
