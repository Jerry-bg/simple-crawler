package com.kons.processor;

import com.kons.response.HttpResponse;

public class DefaultProcessor extends Processor{
    public void handler(HttpResponse resp) {
        System.out.println("Default Processor");
    }
}
