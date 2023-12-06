package com.dai.config;

import org.json.JSONObject;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static java.nio.file.Files.readString;

public class JsonParser {

    /**
     * String who contains all the file content for parsing
     */
    private String fileContent;

    /**
     * Class to parse json
     * @param path path to json file to parse
     */
    public JsonParser(String path){
        try {
            fileContent = readString(Paths.get(path), StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println("Error while reading file : " + e.toString());
        }
    }

    /**
     * Create the json object who contain the parsed json
     * @return the json object
     */
    public JSONObject loadJsonObject(){
        return new JSONObject(fileContent);
    }
}
