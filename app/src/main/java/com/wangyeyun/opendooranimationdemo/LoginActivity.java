package com.wangyeyun.opendooranimationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.gyf.immersionbar.ImmersionBar;

/**
 * 创建人: WangYeYun
 * 创建日期: 2021/4/13 14:13
 * 描述: 登录页
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImmersionBar.with(this).statusBarColor(R.color.purple_500).statusBarDarkFont(false).fitsSystemWindows(false).navigationBarDarkIcon(true)
                .init();
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapUtil.cutBitmapArray(LoginActivity.this);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

    }
}