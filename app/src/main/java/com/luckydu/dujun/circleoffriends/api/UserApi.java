package com.luckydu.dujun.circleoffriends.api;

import com.luckydu.dujun.circleoffriends.bean.SenderBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 获取用户信息
 * Created by dujun on 2017-08-06.
 */

public interface UserApi {

    @GET("/user/{user}")
    Observable<SenderBean> getUserInfo(@Path("user") String user);
}
