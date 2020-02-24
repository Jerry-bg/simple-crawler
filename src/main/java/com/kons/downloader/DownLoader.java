package com.kons.downloader;

import com.kons.request.HttpRequest;
import com.kons.response.HttpResponse;
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

        String contentType=connection.getContentType();
        HttpResponse response=new HttpResponse();
        if(contentType.toLowerCase().startsWith("image")){
            response.setData(toByteInputStream(stream));
        }else {
            StringBuilder content=new StringBuilder();
            byte[] buff=new byte[1024];
            int len;
            while ((len=stream.read(buff,0,buff.length))!=-1)
                content.append(new String(buff,0,len));
            response.setContent(content.toString());
        }
        response.setContentType(contentType);
        response.setHeader(connection.getHeaderFields());
        stream.close();
        return response;
    }
}
