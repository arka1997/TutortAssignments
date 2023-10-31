package com.OracleHealth.stream_apis;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StreamTestMethods {
    int val;
    String size;

    public StreamTestMethods(int val, String size) {
        super();
        this.val = val;
        this.size = size;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Collection<Object> getProductDetails() {
        return Arrays.asList(val, size);
    }

    public String reduceTest(){
        return val+","+size;
    }
}
