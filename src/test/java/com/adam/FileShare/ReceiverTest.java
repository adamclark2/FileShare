package com.adam.FileShare;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import com.adam.FileShare.Receive.Receiver;

import org.junit.Test;

public class ReceiverTest{

    @Test(timeout = 250)
    public void testVer() throws Exception{
        StringReader reader = new StringReader("VER\nClient Name Goes Here\nVersion 1.0\nHello World!!!");
        BufferedReader br = new BufferedReader(reader);
        ByteScanner byteScanner = new ByteScanner(br);

        Client c = new Client();
        c.name = "Client Name Goes Here";
        c.version = "Version 1.0";
        c.blurb = "Hello World!!!";

        // Receiver should populate sent
        // with info above
        Client sent = new Client();
        Receiver r = new Receiver(byteScanner);
        r.handle(sent);

        assertNotNull(sent);
        assertNotNull(sent.name);
        assertNotNull(sent.version);
        assertNotNull(sent.blurb);

        assert(c.name.equals("Client Name Goes Here"));
        assert(sent.name.equals(c.name));
        assert(sent.version.equals(c.version));
        assert(sent.blurb.equals(c.blurb));
    }
}