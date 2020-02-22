package com.kons.processor;

import com.kons.response.HttpResponse;

import java.io.IOException;

public abstract class Processor {

    abstract public void handler(HttpResponse resp) throws IOException;
}
