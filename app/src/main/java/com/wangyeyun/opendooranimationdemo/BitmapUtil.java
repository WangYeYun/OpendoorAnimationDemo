package com.wangyeyun.opendooranimationdemo;

import android.app.Activity;
import android.graphics.Bitmap;

import com.gyf.immersionbar.ImmersionBar;

/**
 * 创建人: WangYeYun
 * 创建日期: 2021/4/13 14:15
 * 描述: Bitmap工具类
 */
public class BitmapUtil {
    private static Bitmap[] bitmaps;

    /**
     * 截屏并裁剪
     *
     * @param activity
     * @return
     */
    public static void cutBitmapArray(Activity activity) {
        //截屏（有导航栏会截到导航栏）
        activity.getWindow().getDecorView().setDrawingCacheEnabled(true);
        Bitmap bitmap = activity.getWindow().getDecorView().getDrawingCache();

        //裁剪成左右两张
        Bitmap[] bitmapArray = new Bitmap[2];
        int bitmapWith = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight() - ImmersionBar.getNavigationBarHeight(activity); //减去导航栏高度
        bitmapArray[0] = Bitmap.createBitmap(bitmap, 0, 0, bitmapWith / 2, bitmapHeight, null,
                false);
        bitmapArray[1] = Bitmap.createBitmap(bitmap, bitmapWith / 2, 0, bitmapWith / 2, bitmapHeight, null,
                false);
        bitmaps = bitmapArray;//缓存
    }

    /**
     * 获取缓存的bitmap
     *
     * @return
     */
    public static Bitmap[] getBitmaps() {
        return bitmaps;
    }
}
