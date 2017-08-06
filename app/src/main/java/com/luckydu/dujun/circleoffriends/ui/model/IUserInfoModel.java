package com.luckydu.dujun.circleoffriends.ui.model;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.bean.SenderBean;
import com.tamic.novate.BaseSubscriber;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public interface IUserInfoModel {

    void getUserInfo(Context context, String user, BaseSubscriber<SenderBean> subscriber);
}
