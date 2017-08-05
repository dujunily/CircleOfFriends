package com.luckydu.dujun.circleoffriends.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.luckydu.dujun.circleoffriends.MyBaseSubscriber;
import com.luckydu.dujun.circleoffriends.R;
import com.luckydu.dujun.circleoffriends.api.TweetApi;
import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.constant.Constant;
import com.luckydu.dujun.circleoffriends.ui.view.ICircleOfFriendsView;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class CircleOfFriendsActivityFragment extends Fragment implements ICircleOfFriendsView{

    @BindView(R.id.tv_content)
    TextView tvContent;

    Unbinder unbinder;

    private Context context;

    public CircleOfFriendsActivityFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle_of_friends, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        Novate novate = new Novate.Builder(context)
                .connectTimeout(10)  //连接时间 可以忽略
                .addCookie(false)  //是否同步cooike 默认不同步
//                .addCache(true)  //是否缓存 默认缓存
                .baseUrl(Constant.HOST) //base URL
                .addLog(true) //是否开启log
                .tag("getTweets")
                .skipSSLSocketFactory(true) // 信任所有https
                .build();

        TweetApi tweetApi = novate.create(TweetApi.class);

        novate.call(tweetApi.getTweets("jsmith"), new MyBaseSubscriber<List<Tweet>>(context) {
            @Override
            public void onNext(List<Tweet> tweets) {
                Toast.makeText(context, "onNext", Toast.LENGTH_SHORT).show();
                tvContent.setText(tweets.toString());
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(context, "onError", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
