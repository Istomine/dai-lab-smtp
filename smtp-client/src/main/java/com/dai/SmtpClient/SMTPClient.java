package com.dai.SmtpClient;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

public class SMTPClient{

    /**
     * The email address of the sender.
     */
    private String from;

    /**
     * The list of email addresses of the recipients.
     */
    private ArrayList<String> to;

    /**
     * The IP address of the SMTP server.
     */
    private String ip;

    /**
     * The port number for the SMTP server.
     */
    private final int PORT;

    /**
     * Reader for reading responses from the SMTP server.
     */
    private BufferedReader reader;

    /**
     * Writer for sending commands to the SMTP server.
     */
    private BufferedWriter writer;

    /**
     * Constructs a new SMTPClient with the specified parameters.
     *
     * This constructor initializes an SMTPClient object with the provided information
     * such as the sender's email address, a list of recipient email addresses,
     * the SMTP server's IP address, and the port number for communication.
     *
     * @param from The email address of the sender.
     * @param to   An ArrayList of recipient email addresses.
     * @param ip   The IP address of the SMTP server.
     * @param port The port number to be used for communication with the SMTP server.
     *
     */
    public SMTPClient(String from, ArrayList<String> to,String ip, int port){
        this.from = from;
        this.to = to;
        this.ip = ip;
        this.PORT = port;
    }

    /**
     * Writes the specified text to the server.
     *
     * This method sends the provided text to the connected server.
     *
     * @param texte The text to be sent to the server.
     *
     * @throws IOException If an I/O error occurs while writing to the server.
     *
     */
    private void writeServer(String texte) throws IOException{
        writer.write(texte + "\r\n");
        writer.flush();
    }

    /**
     * Sends an email with the specified subject and message content.
     *
     * This method sends an email using the SMTP protocol with the provided subject
     * and message content. The recipient list and sender's address must be set
     * before calling this method.
     *
     * @param subject The subject of the email.
     * @param message The content of the email message.
     *
     * @throws IOException If an I/O error occurs during the communication with the SMTP server.
     *
     */
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