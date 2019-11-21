package com.anma.bh.sb.springtesting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Tester {

    private static String readUrl(String urlString) throws Exception {

        BufferedReader reader = null;

        try {

            URL url = new URL(urlString);

            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuffer buffer = new StringBuffer();

            int read;

            char[] chars = new char[1024];

            while ((read = reader.read(chars)) != -1)

                buffer.append(chars, 0, read);

            return buffer.toString();

        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static void main(String[] args) throws Exception {

//        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        String jsonString = readUrl ("https://jsonplaceholder.typicode.com/users/1");
//        String jsonString = readUrl ("https://swapi.co/api/vehicles/4");

        GsonBuilder builder = new GsonBuilder();

        builder.setPrettyPrinting();

        Gson gson = builder.create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

//        System.out.println(jsonObject);
        System.out.println(jsonObject);

        jsonString = gson.toJson(jsonObject);

//        System.out.println(jsonString);
    }
}
