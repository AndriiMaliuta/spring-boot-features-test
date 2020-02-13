package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.services.netcore.CoreNetServiceImpl;
import com.anma.bh.sb.springtesting.services.okhttp.OkHttpService;
import com.anma.bh.sb.springtesting.services.okhttp.OkHttpServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Tester {

    private static void testCoreNet(String url) throws Exception {

        String jsonString = new CoreNetServiceImpl().readUrl(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));


    }

    private static void testOkHttp(String url) throws IOException {

        String jsonString = new OkHttpServiceImpl().getBody(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));
    }


    public static void main(String[] args) throws Exception {

        testOkHttp("https://jsonplaceholder.typicode.com/users/1");

    }
}
