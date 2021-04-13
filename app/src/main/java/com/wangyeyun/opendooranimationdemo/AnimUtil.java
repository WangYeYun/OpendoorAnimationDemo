package com.wangyeyun.opendooranimationdemo;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 创建人: WangYeYun
 * 创建日期: 2021/4/13 14:15
 * 描述: 开门动画工具类
 */
public class AnimUtil {

    private static ScaleAnimation scaleAnim;
    private static TranslateAnimation translateAnimationLeft, translateAnimationRight;

    /**
     * View放缩动画效果
     */
    private static void setScaleAnimation(final View view, int duration) {
        if (null == view || duration < 0) {
            return;
        }
        view.setPivotX(0.5f);
        view.setPivotY(0.5f);
        scaleAnim = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        scaleAnim.setInterpolator(new DecelerateInterpolator(3f));//插值器 动画越来越慢
        scaleAnim.setDuration(duration);
        scaleAnim.setFillAfter(true);//动画结束是画面停留在此动画的最后一帧
        scaleAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                scaleAnim = null;
                view.clearAnimation();
                view.setVisibility(View.VISIBLE);

            }
        });
        view.startAnimation(scaleAnim);
    }

    /**
     * View左移动画效果
     */
    private static void setTranslateAnimationLeft(final View ivLeft, int duration) {
        translateAnimationLeft = new TranslateAnimation(0, -ivLeft.getWidth(), 0, 0);
        translateAnimationLeft.setInterpolator(new DecelerateInterpolator(3f));//插值器 动画越来越慢
        translateAnimationLeft.setDuration(duration);
        translateAnimationLeft.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                translateAnimationLeft = null;
                ivLeft.clearAnimation();
                ivLeft.setVisibility(View.GONE);

            }
        });
        ivLeft.startAnimation(translateAnimationLeft);
    }

    /**
     * View右移动画效果
     */
    private static void setTranslateAnimationRight(final View ivRight, int duration) {
        translateAnimationRight = new TranslateAnimation(0, ivRight.getWidth(), 0, 0);
        translateAnimationRight.setInterpolator(new DecelerateInterpolator(3f));//插值器 动画越来越慢
        translateAnimationRight.setDuration(duration);
        translateAnimationRight.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                translateAnimationLeft = null;
                ivRight.clearAnimation();
                ivRight.setVisibility(View.GONE);

            }
        });
        ivRight.startAnimation(translateAnimationRight);
    }

    /**
     * 开门动画
     *
     * @param ivLeft
     * @param ivRight
     * @param tvContent
     */
    public static void setOpenDoorAnimation(ImageView ivLeft, ImageView ivRight, TextView tvContent) {
        Bitmap[] bitmapArray = BitmapUtil.getBitmaps();
        ivLeft.setImageBitmap(bitmapArray[0]);
        ivRight.setImageBitmap(bitmapArray[1]);
        int animTime = 1500;//开门动画时间
        int animDelayTime = 500;//动画延迟500毫秒，保证数据先加载完成
        tvContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                setScaleAnimation(tvContent, animTime);
                setTranslateAnimationLeft(ivLeft, animTime);
                setTranslateAnimationRight(ivRight, animTime);
            }
        }, animDelayTime);
    }
}
