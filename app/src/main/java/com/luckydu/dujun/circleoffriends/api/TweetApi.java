package com.luckydu.dujun.circleoffriends.api;

import com.luckydu.dujun.circleoffriends.bean.Tweet;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 *
 * Created by dujun on 2017-08-05.
 */

public interface TweetApi {

    @GET("/user/{user}/tweets")
    Observable<List<Tweet>> getTweets(@Path("user") String user);
}
