package com.dai.config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    /**
     * Objet who contains parsed object
     */
    JSONObject emails;

    /**
     * Class who give us all the address mail contains in the json file
     * @param path path to the file
     */
    public Address(String path){
        JsonParser jsonParser = new JsonParser(path);
        emails = jsonParser.loadJsonObject();
    }

    /**
     * Method who check if a given address mail is valid
     * @param email email
     * @return true if valid else false
     */
    private Boolean checkAddressValid(String email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Method who give us all the address mail
     * @return an array lisz of all the mail
     */
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
