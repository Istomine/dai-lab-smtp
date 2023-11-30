package com.dai.config;

import org.json.JSONObject;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static java.nio.file.Files.readString;

public class JsonParser {
    private String fileContent;

    public JsonParser(String path){
        try {
            fileContent = readString(Paths.get(path), StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println("Error while reading file : " + e.toString());
        }
    }

    public JSONObject loadJsonObject(){
        return new JSONObject(fileContent);
    }
}
