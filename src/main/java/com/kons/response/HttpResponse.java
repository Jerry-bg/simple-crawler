package com.kons.response;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public class HttpResponse {
    private ByteArrayInputStream data;
    private String contentType;
    private Map<String, List<String>> header;
    private String content;

    public ByteArrayInputStream getData() {
        return data;
    }

    public void setData(ByteArrayInputStream data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String type) {
        this.contentType = type;
    }

    public Map<String, List<String>> getHeader() {
        return header;
    }

    public void setHeader(Map<String, List<String>> header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
