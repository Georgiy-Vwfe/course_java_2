package ru.course.lambda.expressions.homework.MA.util;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    private static Gson gson = new Gson();

    public static HashMap doRead(InputStream inputStream){
        Map maps = gson.fromJson(new InputStreamReader(inputStream), HashMap.class);
        return (HashMap) maps;
    }
}
