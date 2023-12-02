package com.dai;

import com.dai.GroupManager.GroupManager;
import com.dai.config.Address;
import com.dai.config.JsonParser;
import com.dai.config.Message;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Address address = new Address("./resources/email.json");
        ArrayList<String> messages = address.getEmailsAddress();

        GroupManager groupManager = new GroupManager(messages, 4);
        groupManager.toPrint();
    }
}
