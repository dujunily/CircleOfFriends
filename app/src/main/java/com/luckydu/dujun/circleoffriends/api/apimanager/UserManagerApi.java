package com.luckydu.dujun.circleoffriends.api.apimanager;


import android.content.Context;

import com.luckydu.dujun.circleoffriends.api.UserApi;
import com.luckydu.dujun.circleoffriends.bean.SenderBean;

import rx.Observable;

/**
 * 用户管理类
 *
 * Created by dujun on 2017-08-06.
 */

public class UserManagerApi extends BaseApiManager{
    public static Observable<SenderBean> getUserInfo(Context context, String user){
        return createNovate(context,"getUserInfo").create(UserApi.class).getUserInfo(user);
    }
}
