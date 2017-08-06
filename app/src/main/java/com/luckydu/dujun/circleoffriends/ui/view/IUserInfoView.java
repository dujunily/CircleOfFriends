package com.luckydu.dujun.circleoffriends.ui.view;

import com.luckydu.dujun.circleoffriends.bean.SenderBean;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public interface IUserInfoView {

    /**
     * 获取用户信息
     * @param user 用户名
     */
    void getUserInfo(String user);

    void onSuccess(SenderBean senderBean);

    void onFail(Throwable e);
}
