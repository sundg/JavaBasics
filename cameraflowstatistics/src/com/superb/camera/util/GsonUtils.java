package com.superb.camera.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

/**
 * Audit Log 2013-01-31 new created 2013-03-14 modified fromJson parameter from Class<Object> to
 * Class<?> and test passed 2013-03-26 modified toJson method, added disableHtmlEscaping
 * 
 * @author zcai
 */
public class GsonUtils {

  public static Gson getInstance(boolean prettyPrint) {
    Gson gson = null;
    /* pretty print */
    if (prettyPrint) {
      /* disableHtmlEscaping will print HTML tag as it is */
      gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    } else {
      gson = new GsonBuilder().create();
    }

    return gson;
  }

  public static String toJson(Object obj) {
    return getInstance(true).toJson(obj);
  }

  public static <T> T fromJson(String json, Class<T> classOfT) throws JsonParseException {
    return getInstance(true).fromJson(json, classOfT);
  }

  public static <T> T fromJson(String json, Type typeOfT) throws JsonParseException {
    return (T) getInstance(true).fromJson(json, typeOfT);
  }
}
