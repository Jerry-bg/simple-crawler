package com.kons.processor;

import com.alibaba.fastjson.JSON;
import com.kons.response.HttpResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DbProcessor extends Processor{

    private Object model;
    private Class aClass;

    public void handler(HttpResponse resp) throws IOException {
        ByteArrayInputStream stream=resp.getData();
        StringBuilder stringBuilder=new StringBuilder();
        byte[] buff=new byte[1024];
        int len=-1;
        while ((len=stream.read(buff,0,buff.length))!=-1)
            stringBuilder.append(new String(buff,0,len));
        model = JSON.parseObject(stringBuilder.toString(), aClass);
    }


    public Object getModel() {
        return model;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
