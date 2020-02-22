package com.kons.downloader;

import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
import com.kons.schedule.Schedule;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class DownLoader extends AbstractDownloader{

    public HttpResponse download(HttpRequest request) throws Exception {
        URL url=new URL(request.getUrl());
        URLConnection connection=url.openConnection();
        Map<String,String> map=request.getProperties();
        for (String key:map.keySet()){
            String value=map.get(key);
            connection.setRequestProperty(key,value);
        }

        InputStream stream=connection.getInputStream();

//        byte[] buff=new byte[1024];
//        int len=0;
//        StringBuilder stringBuilder=new StringBuilder();
//        while ((len=stream.read(buff,0, buff.length))!=-1){
//            stringBuilder.append(new String(buff,0,len));
//        }
        HttpResponse response=new HttpResponse();
//        response.json=stringBuilder.toString();
        response.setData(toByteInputStream(stream));
        response.setHeader(connection.getHeaderFields());
        stream.close();
        return response;
    }
}
