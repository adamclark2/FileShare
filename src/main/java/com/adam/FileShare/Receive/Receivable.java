package com.adam.FileShare.Receive;
import java.io.*;
import java.util.*;
import com.adam.FileShare.*;

public interface Receivable{
    public String getName();
    public void handle(ByteScanner byteScanner, BufferedWriter network, Client c);
}