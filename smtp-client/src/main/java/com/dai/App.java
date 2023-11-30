package com.dai;

import com.dai.config.Address;
import com.dai.config.JsonParser;
import com.dai.config.Mail;
import com.dai.config.Message;
import com.dai.SmtpClient.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        Address addr = new Address("./smtp-client/resources/email.json");

        Message mess = new Message("./smtp-client/resources/message.json");


        ArrayList<String> mails = addr.getEmailsAddress();
        ArrayList<Mail> messages = mess.getMails();

        SMTPClient client = new SMTPClient(mails.get(0),mails,"localhost",1025 );


        for(Mail m : messages){
            client.send(m.subject(),m.body());
        }





    }
}
