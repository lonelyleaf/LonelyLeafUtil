package rock.util;

import android.app.Activity;
import android.content.Intent;

/**
 * 系统分享功能工具类
 * Created by Rock on 2015/11/24.
 */
public class ShareUtil {

    /**
     * 分享纯文本
     */
    public static void shareText(Activity activity, String text) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        activity.startActivity(sendIntent);
    }

    /**
     * 分享纯文本,不会选择默认应用
     */
    public static void shareText(Activity activity, String shareText, String shareTitle) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");
        activity.startActivity(Intent.createChooser(sendIntent, shareTitle));
    }

//    /**
//     * 分享图片
//     */
//    public static void shareImage(Activity activity, byte[] img) {
//        Intent shareIntent = new Intent();
//        shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, img);
//        shareIntent.setType("image/jpeg");
//        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
//    }


}
