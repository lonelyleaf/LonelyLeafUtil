package rock.util;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

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

    /**
     * 针对android6.0的运行时权限，对权限进行检查
     *
     * @param context
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static boolean checkPermission_WRITE_SETTINGS(Context context) {
        int hasWriteContactsPermission = context.checkSelfPermission(Manifest.permission.WRITE_SETTINGS);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 针对android6.0的运行时权限，对权限进行请求，需要重写对应activity的onRequestPermissionsResult方法
     *
     * @param Activity    显示请求权限dialog的activity
     * @param requestCode 请求的requestCode
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static void requestPermission_WRITE_SETTINGS(Activity activity, int requestCode) {
        activity.requestPermissions(new String[]{Manifest.permission.WRITE_SETTINGS}, requestCode);
    }
}
