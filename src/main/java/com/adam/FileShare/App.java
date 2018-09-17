package com.adam.FileShare;

import java.util.*;
import com.jcraft.jsch.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        // SSH File Transfer Example...
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Host");
        String host = sc.nextLine();
        System.out.println("Username:");
        String user = sc.nextLine();
        System.out.println("Password:");
        char[] passCar = System.console().readPassword();
        String pass = new String(passCar);

        System.out.println("\n\nFile Path To Transfer:");
        String path = sc.nextLine();
        System.out.println("\n\nFile Path On Remote:");
        String dst = sc.nextLine();

        // JSch example
        JSch sch = new JSch();
        Session session = sch.getSession(user, host);
        session.setPassword(pass);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
        sftp.connect();
        sftp.put(path, dst);

        sftp.disconnect();
        session.disconnect();
    }
}
