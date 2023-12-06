package com.dai;

import com.dai.config.Address;
import com.dai.GroupManager.*;
import com.dai.config.Mail;
import com.dai.config.Message;
import com.dai.SmtpClient.*;
import java.util.ArrayList;


public class App 
{

    public static void main( String[] args ){

        try{
            if(args.length != 3){
                throw new IllegalArgumentException("The program must have 3 arguments");
            }

            int groupNumber = Integer.parseInt(args[2]);

            if(groupNumber < 1){
                throw new IllegalArgumentException("The number of groups must be bigger than 0");
            }

            // Email and group managment
            Address address = new Address(args[0]);
            GroupManager group = new GroupManager(address.getEmailsAddress(),groupNumber);

            // Message managment
            Message m = new Message(args[1]);
            ArrayList<Mail> message = m.getMails();


            SMTPClient client;
            for(int i = 0; i < groupNumber ; ++i){
                client = new SMTPClient(group.getSender(i),group.getReceiver(i),"localhost",1025 );
                client.send(message.get(i).subject(),message.get(i).body());
            }


        }catch (Exception e){
            System.out.println("An error has occured ! : " + e);
        }
        
    }
}
