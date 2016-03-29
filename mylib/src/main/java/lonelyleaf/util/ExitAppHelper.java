package rock.util;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by Rock on 2015/1/7.
 */
public class ExitAppHelper {

    private static ExitAppHelper instance;

    private ArrayList<Activity> activities;

    private ExitAppHelper() {
        activities = new ArrayList<>();
    }

    public static ExitAppHelper getInstance() {
        if (instance == null)
            synchronized (ExitAppHelper.class) {
                if (instance == null) {
                    instance = new ExitAppHelper();
                }
            }
        return instance;
    }

    /**
     * 关闭除此以外的所有activity
     */
    public void closeOthers(Activity activity) {
        for (Activity a : activities) {
            if (a != null)
                a.finish();
        }
        activities.add(activity);
    }

    /**
     * 把新打开的activity放入列表中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Activity销毁后，移除出去
     *
     * @param activity 销毁的activity
     * @return 是否是最后一个activity。用来判断是否需要做app退出操作
     */
    public boolean removeActivity(Activity activity) {
        activities.remove(activity);
        return activities.isEmpty();
    }

    /**
     * 退出APP
     */
    public void exitApp() {
        for (Activity a : activities) {
            if (a != null)
                a.finish();
        }
    }

}
