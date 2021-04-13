package com.wangyeyun.opendooranimationdemo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

/**
 * 创建人: WangYeYun
 * 创建日期: 2021/4/13 14:13
 * 描述: 主页
 */
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this).statusBarColor(R.color.purple_500).statusBarDarkFont(false).fitsSystemWindows(false).navigationBarDarkIcon(true)
                .init();
        TextView tvContent = findViewById(R.id.tv_content);
        ImageView ivLeft = findViewById(R.id.iv_left);
        ImageView ivRight = findViewById(R.id.iv_right);
        AnimUtil.setOpenDoorAnimation(ivLeft, ivRight, tvContent);
    }
}