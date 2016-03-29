package rock.util.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * 帮助实现View的伸缩效果
 * Created by Rock on 2016/2/9.
 */
public class ViewExpandHelper {

    private long ANIM_TIME = 300;
    private View mExpandView;
    private int mOriginalHeight;

    public ViewExpandHelper(View expandView, int originalHeight) {
        this.mExpandView = expandView;
        this.mOriginalHeight = originalHeight;
    }

    public void expandAnimToggle() {

        // Declare a ValueAnimator object
        ValueAnimator valueAnimator;
        if (!mExpandView.isShown()) {
            mExpandView.setVisibility(View.VISIBLE);
            mExpandView.setEnabled(true);
            // These values in this method can be changed to expandAnimToggle however much you like
            valueAnimator = ValueAnimator.ofInt(0, mOriginalHeight);
        } else {
            valueAnimator = ValueAnimator.ofInt(mOriginalHeight, 0);

            Animation a = new AlphaAnimation(1.00f, 0.00f); // Fade out

            a.setDuration(ANIM_TIME);
            // Set a listener to the animation and configure onAnimationEnd
            a.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mExpandView.setVisibility(View.INVISIBLE);
                    mExpandView.setEnabled(false);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            // Set the animation on the custom view
            mExpandView.startAnimation(a);

        }
        valueAnimator.setDuration(ANIM_TIME);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                mExpandView.getLayoutParams().height = value.intValue();
                mExpandView.requestLayout();
            }
        });

        valueAnimator.start();
    }
}
