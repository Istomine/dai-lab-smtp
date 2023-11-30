package com.dai.config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Message {
    /**
     *
     */
    JSONObject jsonObject;

    /**
     *
     * @param pathFile
     */
    public Message(String pathFile){
        JsonParser jsonParser = new JsonParser(pathFile);
        jsonObject = jsonParser.loadJsonObject();
    }

    /**
     *
     * @return
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
