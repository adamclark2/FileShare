package com.adam.FileShare;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;
import org.junit.Test;

public class ByteScannerTest{

    private static ByteScanner getByteScanner(){
        StringReader reader = new StringReader("Hello World\nThis is Cool!");
        BufferedReader br = new BufferedReader(reader);
        ByteScanner byteScanner = new ByteScanner(br);

        return byteScanner;
    }

    @Test(timeout = 250)
    public void testByteRead() throws Exception{
        ByteScanner byteScanner = ByteScannerTest.getByteScanner();

        String s = "Hello World";
        String next = new String(byteScanner.next());
        assert(s.equals(next));

        s = "This is Cool!";
        next = new String(byteScanner.next());
        assert(s.equals(next));
    }    

    @Test(timeout = 250)
    public void testNextString() throws Exception{
        ByteScanner byteScanner = ByteScannerTest.getByteScanner();

        String s = "Hello World";
        String next = byteScanner.nextString();
        assert(s.equals(next));

        s = "This is Cool!";
        next = byteScanner.nextString();
        assert(s.equals(next));
    }

    @Test(timeout = 250)
    public void testReadNBytes() throws Exception{
        ByteScanner byteScanner = ByteScannerTest.getByteScanner();

        byte[] hw = "Hello World".getBytes();
        int numToRead = hw.length;
        byte[] len = byteScanner.read(numToRead);

        assertEquals(numToRead, len.length);
        for(int i = 0; i < numToRead;i++){
            assert(len[i] == hw[i]);
        }
    }
}