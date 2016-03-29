package rock.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Rock on 2015/11/30.
 */
public class ImageUtil {

    /**
     * 4.4及以上使用，获取content://类型图片的绝对路径
     *
     * @param activity 调用的activity
     * @param data
     * @param imageUri
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getImgAbsolutePath(Activity activity, Intent data, Uri imageUri) {
        String imgPath = null;
        //TODO 需要测试
        if ("file".equals(imageUri.getScheme()) || imageUri.getScheme() == null) {
            return imageUri.getEncodedPath();
        }

        if (!DocumentsContract.isDocumentUri(activity, imageUri)) {//不是系统图库
            Cursor cursor = null;
            try {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                cursor = activity.getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgPath = cursor.getString(columnIndex);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

        } else {//系统图库
            String wholeID = DocumentsContract.getDocumentId(imageUri);
            if (!TextUtils.isEmpty(wholeID) && wholeID.contains(":")) {
                Cursor cursor = null;
                try {
                    // 获得资源唯一ID
                    String id = wholeID.split(":")[1];
                    // 定义索引字段
                    String[] column = {MediaStore.Images.Media.DATA};
                    String sel = MediaStore.Images.Media._ID + "=?";

                    cursor = activity.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column, sel, new String[]{id}, null);
                    int columnIndex = cursor.getColumnIndex(column[0]);

                    if (cursor.moveToFirst()) {
                        // DATA字段就是本地资源的全路径
                        imgPath = cursor.getString(columnIndex);
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                // 切记要关闭游标

            }
        }
        return imgPath;
    }

    public static void cropImg(Activity activity, int requestCode, Uri dataUri, Uri outputUri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(dataUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 4);
        intent.putExtra("aspectY", 3);
        intent.putExtra("outputX", 400);
        intent.putExtra("outputY", 300);
        intent.putExtra("scale", true);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 压缩指定路径的图片，并得到图片对象
     */
    public static boolean compressImg(Uri imgUri) {
        String srcPath = imgUri.getPath();
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath);

        File file = new File(imgUri.getPath());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fos);
    }
}
