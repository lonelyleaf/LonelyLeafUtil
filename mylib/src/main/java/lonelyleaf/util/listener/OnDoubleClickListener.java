package rock.util.listener;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

/**
 * 双击事件监听，实现了OnTouchListener接口
 * Created by Rock on 2015/3/17.
 */
public abstract class OnDoubleClickListener implements View.OnTouchListener {
    private static final int MSG_GET = 0x111;
    private View v;
    private int intervalTime = 500;//点击间隔时间
    private int count = 0;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.v = v;

        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            count++;
            if (count == 1) {
                handler.sendEmptyMessageDelayed(MSG_GET, intervalTime);
            } else if (count == 2) {
                //双击事件
                onDoubleClick(v);
                count = 0;
            }
        }
        return true;
    }

    /**
     * 处理单击事件
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_GET) {
                if (count == 1) {
                    onClick(v);
                    count = 0;
                }
            }
        }
    };


    /**
     * 获得点击间隔时间
     *
     * @return
     */
    public int getIntervalTime() {
        return intervalTime;
    }

    /**
     * 设置点击间隔时间
     *
     * @param intervalTime
     */
    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }


    /**
     * 双击事件
     */
    public abstract boolean onDoubleClick(View v);

    /**
     * 单击事件
     */
    public abstract boolean onClick(View v);
}
