package lonelyleaf.mylib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by Rock on 2015/11/27.
 */
public class IntentUtil {

    private IntentUtil() {
    }

    /**
     * 打电话
     *
     * @param activity activity
     * @param phoneNum 电话号码
     */
    public static void call(Activity activity, String phoneNum) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + phoneNum));
        activity.startActivity(intent);
    }

    /**
     * 调用相机，获取图片。注意需要重写调用者的onActivityResult方法来接收结果
     *
     * @param activity    调用的activity
     * @param photoUri    图片的存储路径
     * @param requestCode startActivityForResult的requestCode
     */
    public static void getPhotoByCamera(Activity activity, Uri photoUri, int requestCode) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        activity.startActivityForResult(intent, requestCode);//or TAKE_SMALL_PICTURE
    }
    /**
     * 调用相机，获取图片。注意需要重写调用者的onActivityResult方法来接收结果
     *
     * @param activity    调用的activity
     * @param photoUri    图片的存储路径
     * @param requestCode startActivityForResult的requestCode
     */
    public static void getPhotoByCamera(Activity activity,int requestCode) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture
        activity.startActivityForResult(intent, requestCode);//or TAKE_SMALL_PICTURE
    }

    /**
     * 从本地获得图片,图片选完后会回调onActivityResult方法来接收结果。结果在方法参数中的intent中，使用
     * intent.getData()获取图片的路径。并且路径在4.4以下和4.4以下路径不同，需要分开处理。
     *
     * @param activity    调用的activity
     * @param requestCode startActivityForResult的requestCode
     */
    public static void getPhotoFromLocal(Activity activity, int requestCode) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activity.startActivityForResult(intent, requestCode);
    }

}
