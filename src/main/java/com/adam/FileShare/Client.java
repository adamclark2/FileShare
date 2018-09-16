package com.adam.FileShare;

public class Client implements Cloneable{
    public String name;
    public String version;
    public String blurb;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}