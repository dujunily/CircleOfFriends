package com.luckydu.dujun.circleoffriends.ui.model.impl;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.api.apimanager.UserManagerApi;
import com.luckydu.dujun.circleoffriends.bean.SenderBean;
import com.luckydu.dujun.circleoffriends.ui.model.IUserInfoModel;
import com.tamic.novate.BaseSubscriber;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class UserInfoModel implements IUserInfoModel {

    @Override
    public void getUserInfo(Context context, String user, BaseSubscriber<SenderBean> subscriber) {
        // 先从数据库获取数据

        UserManagerApi.createNovate(context,"getUserInfo").call(UserManagerApi.getUserInfo(context,user),subscriber);
    }
}
