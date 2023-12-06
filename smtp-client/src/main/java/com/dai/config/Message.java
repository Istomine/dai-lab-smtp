package com.dai.config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Message {
    /**
     * Json object who contain the json file parsed
     */
    JSONObject jsonObject;

    /**
     * Class who will give us all the mail messages conatains in the json file
     * @param pathFile path of the json file
     */
    public Message(String pathFile){
        JsonParser jsonParser = new JsonParser(pathFile);
        jsonObject = jsonParser.loadJsonObject();
    }

    /**
     * Method to get the list of all mails
     * @return the array list of all mails
     */
    public ArrayList<Mail> getMails(){
        ArrayList<Mail> messages = new ArrayList<Mail>();
        JSONArray emails = jsonObject.getJSONArray("emails");
        JSONObject mail;
        Mail message;
        for(int i = 0; i < emails.length(); i++){
            mail = emails.getJSONObject(i);
            message = new Mail(mail.get("subject").toString(), mail.get("body").toString());
            messages.add(message);
        }
        return messages;
    }
}
