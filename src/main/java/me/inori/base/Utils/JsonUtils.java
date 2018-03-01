package me.inori.base.Utils;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /* ---------Json转化处理-----------*/
    public static <T> T getBeanFromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static <T> T getBeanFromJson(String json, TypeToken<T> classtype) {
        return gson.fromJson(json, classtype.getType());
    }

    public static <T> List<T> getArrayFromJson(String json, TypeToken<List<T>> classtype) {
        if (json == null || json.equals("")) json = "[]";
        return gson.fromJson(json, classtype.getType());
    }

    public static String getJsonFromBean(Object bean) {
        return gson.toJson(bean);
    }

    public static <T> String getJsonFromArray(List<T> lists) {
        return gson.toJson(lists);
    }

   

    public static <T> ArrayList<T> fromJsonList(String json, Class<T> cls) {
        ArrayList<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            mList.add(gson.fromJson(elem, cls));
        }
        return mList;
    }
    

}
