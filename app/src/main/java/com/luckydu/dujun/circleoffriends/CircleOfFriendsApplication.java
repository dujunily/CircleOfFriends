package com.luckydu.dujun.circleoffriends;

import android.app.Application;

import org.litepal.LitePal;

/**
 *
 * Created by dujun on 2017-08-05.
 */

public class CircleOfFriendsApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化
        init();
    }

    private void init() {
        // litepal初始化
        LitePal.initialize(this);
    }
}
