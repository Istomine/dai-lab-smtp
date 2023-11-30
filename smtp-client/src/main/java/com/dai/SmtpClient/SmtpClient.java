package com.dai.SmtpClient;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

class SmtpClient{

    private String from;

    private ArrayList<String> to;

    private String ip;

    private final int PORT;

    private BufferedReader reader;

    private BufferedWriter writer;

    SmtpClient(String from, ArrayList<String> to,String ip, int port){
        this.from = from;
        this.to = to;
        this.ip = ip;
        this.PORT = port;
    }

    private void writeServer(String texte) throws IOException{
        writer.write(texte + "\r\n");
        writer.flush();
    }


    public void send(String subject,String message) {

        try (Socket socket = new Socket(ip, PORT)) {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));


            System.out.println(reader.readLine());


            writeServer("EHLO localhost");

            String line = reader.readLine();
            while(line.startsWith("250-")){
                line = reader.readLine();
                System.out.println(line);
            }


            writeServer("MAIL FROM: <" + from + ">");
            System.out.println(reader.readLine());


            for(String mail : to){
                writeServer("RCPT TO: <" + mail + ">");
                System.out.println(reader.readLine());
            }






            writeServer("DATA");


            writeServer("Content-Type: text/plain; charset=utf-8");

            writeServer("FROM:" + from);



            for(String mail : to){
                writeServer("TO:" + mail);
            }


            writeServer("Subject: =?utf-8?B?" + Base64.getEncoder().encodeToString(subject.getBytes(StandardCharsets.UTF_8)) + "?=");

            writer.write("\r\n");

            writeServer(message);

            writeServer(".");
            System.out.println(reader.readLine());

            writeServer("QUIT");
            System.out.println(reader.readLine());

            writer.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("Could not send a email !");
        }
    }
}