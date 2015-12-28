package lonelyleaf.mylib;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Rock on 2015/11/30.
 */
public class PermissionUtil {

    private PermissionUtil() {
    }

    public static boolean hasExternalStoragePermission(Context context) {
        int perm = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        return perm == PackageManager.PERMISSION_GRANTED;
    }
}
