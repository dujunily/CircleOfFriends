package com.luckydu.dujun.circleoffriends.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.luckydu.dujun.circleoffriends.R;
import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.ui.presenter.impl.CircleOfFriendsPresenter;
import com.luckydu.dujun.circleoffriends.ui.view.ICircleOfFriendsView;

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
    private CircleOfFriendsPresenter circleOfFriendsPresenter;

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
//        initView();
        initData();
        return view;
    }

    private void initData() {
        circleOfFriendsPresenter = new CircleOfFriendsPresenter(this);
        getTweets("jsmith");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getTweets(String user) {
        circleOfFriendsPresenter.getTweets(getActivity(),user);
    }

    @Override
    public void onSuccess(List<Tweet> tweets) {
        Toast.makeText(context,"size:"+tweets.size(),Toast.LENGTH_SHORT).show();
        tvContent.setText(tweets.toString());
    }

    @Override
    public void onFail(Throwable e) {
        Toast.makeText(context,"onFail:" + e.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
