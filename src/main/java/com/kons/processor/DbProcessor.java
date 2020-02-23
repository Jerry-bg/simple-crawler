package com.kons.processor;

import com.alibaba.fastjson.JSON;
import com.kons.response.HttpResponse;
import java.io.IOException;

public class DbProcessor extends Processor{

    private Object model;
    private Class aClass;

    public void handler(HttpResponse resp) throws IOException {
        if(resp.getContentType().toLowerCase().startsWith("image")){
            return;
        }
        StringBuilder stringBuilder=new StringBuilder(resp.getContent());
        model = JSON.parseObject(stringBuilder.toString(), aClass);
    }


    public Object getModel() {
        return model;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
