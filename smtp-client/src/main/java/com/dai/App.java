package com.dai;

import com.dai.config.Address;
import com.dai.config.JsonParser;
import com.dai.config.Mail;
import com.dai.config.Message;
import com.dai.SmtpClient.*;

import javax.management.BadAttributeValueExpException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        if(args.length != 3){
            throw new IllegalArgumentException("Le programme nécessite exactement 4 arguments.");
        }

        Address addr = new Address(args[1]);

        Message mess = new Message(args[2]);

        Integer nbGroup = Integer.valueOf(args[3]);

/*
        ArrayList<String> mails = addr.getEmailsAddress();
        ArrayList<Mail> messages = mess.getMails();

        SMTPClient client = new SMTPClient(mails.get(0),mails,"localhost",1025 );


        for(Mail m : messages){
            client.send(m.subject(),m.body());
        }


*/


    }
}
