package cn.monksfish.happypush.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yan_wenjie
 */
public class JsonUtils {
    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
        return gson.toJson(obj);
    }
}
