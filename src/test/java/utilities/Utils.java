package utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.User;
import model.UserData;


import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;


public class Utils {

    public static Random rand = new Random();

    public static User getUser(String keyUser) {
        Map<String, UserData> output;
        JsonReader getLocalJsonFile;
        try {
            getLocalJsonFile = new JsonReader(new FileReader(Constants.JSON_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Type mapTokenType = new TypeToken<Map<String, UserData>>() {
        }.getType();
        output = new Gson().fromJson(getLocalJsonFile, mapTokenType);
        return new User(keyUser, output.get(keyUser));

    }

    public static Map<String, UserData> getUsersMap() {
        //Map<String, UserData> output;
        JsonReader getLocalJsonFile;
        try {
            getLocalJsonFile = new JsonReader(new FileReader(Constants.JSON_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Type mapTokenType = new TypeToken<Map<String, UserData>>() {
        }.getType();
        return new Gson().fromJson(getLocalJsonFile, mapTokenType);
        //return new User(keyUser, output.get(keyUser));

    }



    public static String getTimestampAsString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return (now.format(formatter));
    }

}
