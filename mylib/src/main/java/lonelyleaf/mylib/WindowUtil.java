package lonelyleaf.mylib;

import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Rock on 2015/11/24.
 */
public class WindowUtil {

    private WindowUtil() {
    }

    public static int getWindowWidth(WindowManager wm) {
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
