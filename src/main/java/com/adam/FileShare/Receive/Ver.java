package com.adam.FileShare.Receive;
import java.io.*;
import java.util.*;
import com.adam.FileShare.*;

public class Ver implements Receivable {
    public String getName(){
        return "VER";
    }

    public void handle(ByteScanner byteScanner, BufferedWriter network, Client client){
        try{
            client.name = byteScanner.nextString();
            client.version = byteScanner.nextString();
            client.blurb = byteScanner.nextString();
        }catch(Exception e){
            // Send ERR to client
            e.printStackTrace();
        }
        
    }
}