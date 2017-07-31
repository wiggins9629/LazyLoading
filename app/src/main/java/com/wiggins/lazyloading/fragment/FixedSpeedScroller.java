package com.wiggins.lazyloading.fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * @Description 修改滑屏速度
 * ViewPager跳转滑动效果问题:
 * 在使用ViewPager的过程中，有需要直接跳转到某一个页面的情况，这个时候需要使用ViewPager的setCurrentItem
 * 方法，它的作用是跳转到ViewPager的指定页面。但是在使用这个方法的时候有这样一个问题，页面在跳转的时候有滑动
 * 效果，当需要从当前页面跳转到其它页面时，如果跳转的页面跨度过大或者ViewPager的每个页面视觉效果相差较大时，
 * 通过这种方式实现ViewPager的跳转显得很不美观。
 * <p>
 * 解决办法:
 * 去掉在使用ViewPager的setCurrentItem方法时的滑屏速度。
 * @Author 一花一世界
 */
public class FixedSpeedScroller extends Scroller {

    private int mDuration = 0;//滑屏速度

    /**
     * 设置滑屏速度
     *
     * @param mDuration 速度
     */
    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public FixedSpeedScroller(Context context) {
        super(context);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    public void initViewPagerScroll(ViewPager viewPager) {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(viewPager, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
