package rock.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Json转换的工具类
 * Created by Rock on 2015/1/10.
 */
public class JsonUtil {

//    private static Parser parser;

    public static String getString(String json, String param) {
        String s = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            s = jsonObject.getString(param);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static boolean getBoolean(String json, String param) {
        boolean b = false;
        try {
            JSONObject jsonObject = new JSONObject(json);
            b = jsonObject.getBoolean(param);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static int getInt(String json, String param) {
        int i = 0;
        try {
            JSONObject jsonObject = new JSONObject(json);
            i = jsonObject.getInt(param);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static double getDouble(String json, String param) {
        double d = 0;
        try {
            JSONObject jsonObject = new JSONObject(json);
            d = jsonObject.getDouble(param);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return d;
    }

//    public static Parser parse(String json) {
//        parser = new Parser(json);
//        return parser;
//    }
//
//    public static class Parser {
//        String json;
//        JSONObject jsonObject;
//
//        public Parser(String json) {
//            this.json = json;
//            try {
//                jsonObject = new JSONObject(json);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public Parser getString(String valueName, String target) {
//            try {
//                target = jsonObject.getString(valueName);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return this;
//        }
//
//        public Parser getBoolean(String valueName, Boolean target) {
//            try {
//                target = jsonObject.getBoolean(valueName);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return this;
//        }
//    }
}
