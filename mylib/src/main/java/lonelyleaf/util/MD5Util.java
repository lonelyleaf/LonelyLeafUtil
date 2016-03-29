package rock.util;


import java.security.MessageDigest;

/**
 * MD5转码
 * Created by Rock on 2015/1/10.
 */
public class MD5Util {

    /**
     * 将字符串转成MD5值
     *
     * @param string
     * @return
     */
//    public static String MD5 (String string) {
//        byte[] hash;
//
//        try {
//            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
//        } catch (NoSuchAlgorithmException e) {
//            return null;
//        } catch (UnsupportedEncodingException e) {
//            return null;
//        }
//        String result = new String(hash);
//        LogUtils.e("MD5"+result);
//        return result;
//    }

    /**
     * MD5加码 生成32位md5码
     */
    public static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }
}
