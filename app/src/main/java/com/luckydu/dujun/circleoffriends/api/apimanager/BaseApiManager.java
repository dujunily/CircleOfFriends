package com.luckydu.dujun.circleoffriends.api.apimanager;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.constant.Constant;
import com.tamic.novate.Novate;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class BaseApiManager {

    public static Novate createNovate(Context context, String tag){
        return new Novate.Builder(context)
                .connectTimeout(10)  //连接时间 可以忽略
                .addCookie(false)  //是否同步cooike 默认不同步
//                .addCache(true)  //是否缓存 默认缓存
                .baseUrl(Constant.HOST) //base URL
                .addLog(true) //是否开启log
                .tag(tag)
                .skipSSLSocketFactory(true) // 信任所有https
                .build();
    }
}
