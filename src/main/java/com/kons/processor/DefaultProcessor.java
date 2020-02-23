package com.kons.processor;

import com.kons.response.HttpResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DefaultProcessor extends Processor{
    private String content;
    private String path;

    public void handler(HttpResponse resp) throws IOException {
        if(resp.getContentType().toLowerCase().startsWith("image")){
            ByteArrayInputStream inputStream=resp.getData();
            File file=new File(path);
            if(!file.exists())
                file.createNewFile();
            FileOutputStream out=new FileOutputStream(file);
            byte[] buff=new byte[1024];
            int len=0;
            while ((len=inputStream.read(buff,0,buff.length))!=-1){
                out.write(buff,0,len);
            }
            out.close();
        }else {
            content = resp.getContent();
        }
    }

    public String getContent() {
        return content;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
