package com.kons.downloader;

import java.io.*;
import java.net.SocketTimeoutException;

public abstract class AbstractDownloader {

    protected ByteArrayInputStream toByteInputStream(InputStream in) throws IOException {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[1024];
            for (int c = 0; (c = in.read(b)) != -1;) {
                bos.write(b, 0, c);
            }
            b = null;
            bis = new ByteArrayInputStream(bos.toByteArray());
        } catch(EOFException eof){
            bis = new ByteArrayInputStream(bos.toByteArray());
        }
        // 读取 org.apache.http.client.entity.LazyDecompressingInputStream 流时会抛出超时异常
        catch( SocketTimeoutException e) {
            throw e;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                in.close();
                bos.close();
            } catch (IOException e) {
                bos = null;
                in = null;
            }
        }
        return bis;
    }
}
