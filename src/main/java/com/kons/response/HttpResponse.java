package com.kons.response;

import com.kons.utils.ProcessorType;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public class HttpResponse {
    private ByteArrayInputStream data;
    private ProcessorType type;
    private Map<String, List<String>> header;
    public String context;

    public ByteArrayInputStream getData() {
        return data;
    }

    public void setData(ByteArrayInputStream data) {
        this.data = data;
    }

    public ProcessorType getType() {
        return type;
    }

    public void setType(ProcessorType type) {
        this.type = type;
    }

    public Map<String, List<String>> getHeader() {
        return header;
    }

    public void setHeader(Map<String, List<String>> header) {
        this.header = header;
    }
}
