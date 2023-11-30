package com.dai.config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    JSONObject emails;

    public Address(String path){
        JsonParser jsonParser = new JsonParser(path);
        emails = jsonParser.loadJsonObject();
    }

    private Boolean checkAddressValid(String email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public ArrayList<String> getEmailsAddress(){
        ArrayList<String> list_address = new ArrayList<String>();
        JSONArray email_array = emails.getJSONArray("adresses_emails");
        for(int i = 0; i < email_array.length(); i++){
            if(checkAddressValid(email_array.getString(i))){
                list_address.add(email_array.getString(i));
            }
        }
        return list_address;
    }
}
