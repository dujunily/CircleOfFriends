package com.luckydu.dujun.circleoffriends.api.apimanager;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.api.TweetApi;
import com.luckydu.dujun.circleoffriends.bean.Tweet;

import java.util.List;

import rx.Observable;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class TweetApiManager extends BaseApiManager{

    public static Observable<List<Tweet>> getTweets(Context context,String user){
        return createNovate(context,"getTweets").create(TweetApi.class).getTweets(user);
    }
}
