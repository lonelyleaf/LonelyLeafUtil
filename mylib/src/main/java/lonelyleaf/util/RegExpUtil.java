package rock.util;

import java.util.regex.Pattern;

/**
 * 正则工具类
 * Created by Rock on 2016/1/26.
 */
public class RegExpUtil {

    private RegExpUtil() {
    }

    private static Pattern pCoord;

    /**
     * 检查是否是位置坐标
     */
    public static boolean isCoord(String coord) {
        if (pCoord == null)
            pCoord = Pattern.compile("\\d+\\.+\\d+,\\d+\\.+\\d+");
        return pCoord.matcher(coord).matches();
    }

    private static Pattern pIdNum;

    /**
     * 检查是否是身份证号
     */
    public static boolean isIdNum(String idNum) {
        if (pIdNum == null) {
            pIdNum = Pattern.compile("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$");
        }
        return pIdNum.matcher(idNum).matches();
    }

}
