package com.luckydu.dujun.circleoffriends.api;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.constant.Constant;
import com.tamic.novate.Novate;

import java.util.List;

import rx.Observable;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class TweetApiManager {

    public static Novate createNovate(Context context){
        return new Novate.Builder(context)
                .connectTimeout(10)  //连接时间 可以忽略
                .addCookie(false)  //是否同步cooike 默认不同步
//                .addCache(true)  //是否缓存 默认缓存
                .baseUrl(Constant.HOST) //base URL
                .addLog(true) //是否开启log
                .tag("getTweets")
                .skipSSLSocketFactory(true) // 信任所有https
                .build();
    }

    public static Observable<List<Tweet>> getTweets(Context context,String user){
        return createNovate(context).create(TweetApi.class).getTweets(user);
    }
}
