package com.adam.FileShare;
import java.io.*;
import java.util.*;

public class ByteScanner{
    private BufferedReader br;
    private byte[] delimiter;

    public ByteScanner(BufferedReader br){
        this.br = br;

        String newLine = "\n";
        delimiter = newLine.getBytes();
    }

    public byte[] next() throws Exception{
        List<Byte> bytes = new ArrayList<>();
        int equalIndex = 0;

        boolean done = false;
        while(equalIndex < delimiter.length && !done){
            if(br.ready()){
                int nextByte = br.read();

                if(delimiter[equalIndex] == (byte) nextByte){
                    equalIndex++;
                }else{
                    equalIndex = 0;

                    if(nextByte == -1 || !br.ready()){
                        done = true;
                    }else{
                        bytes.add((byte) nextByte);
                    }
                }
                
                if(nextByte == -1 || !br.ready()){
                    done = true;
                }
                
            }else{
                done = true;
            }
        }

        byte[] b = new byte[bytes.size()];
        for(int i = 0; i < b.length;i++){
            b[i] = bytes.get(i);
        }
        return b;
    }

    public String nextString() throws Exception{
        byte[] next = next();
        return new String(next);
    }

    public byte[] read(long numberOfBytes) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        if(br.ready()){
            int read = br.read();
            numberOfBytes--;
            while(numberOfBytes >= 0 && read != -1){
                baos.write((byte) read);
                read = br.read();
                numberOfBytes--;
            }
        }

        byte[] ret = baos.toByteArray();
        baos.close();
        return ret;
    }
}