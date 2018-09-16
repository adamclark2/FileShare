package com.adam.FileShare.Receive;

import com.adam.FileShare.*;


public class Receiver{
    private ByteScanner br;

    private Receivable[] receivables = {
        new Ver()
    };

    public Receiver(ByteScanner br){
        this.br = br;
    }

    public void handle(Client c) throws Exception{
        String request = br.nextString();
        for(Receivable r : receivables){
            if(r.getName().equals("" + request)){
                r.handle(br, null, c);
                return;
            }else{
                System.out.print(request);
            }
        }

        throw new Exception("Cannot handle request");
    }
}