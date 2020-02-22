package com.kons.request;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final static String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private final static String DEFAULT_CHARTSET = "GBK";
    private final Map<String,String> properties;

    protected String url;

    {
        properties = new HashMap<String, String>();
        properties.put("accept","*/*");
        properties.put("connection", "Keep-Alive");
        properties.put("accept-charset",DEFAULT_CHARTSET);
        properties.put("user-agent",DEFAULT_USER_AGENT);
    }

    public HttpRequest(String url){
        this.url=url;
    }

    public String getUrl(){
        return url;
    }

    public void setPropertie(String key,String value){
        properties.put(key,value);
    }

    public Map getProperties(){
        return properties;
    }

    public String getPropertie(String key){
        return properties.get(key);
    }
}
