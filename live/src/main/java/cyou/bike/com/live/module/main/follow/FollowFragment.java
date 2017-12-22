package cyou.bike.com.live.module.main.follow;

import android.os.Bundle;
import android.view.View;

import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;

/**
 * Created by：anlonglong
 * on 2017/12/7 17:43
 * Email: anlonglong0721@gmail.com
 */

public class FollowFragment extends BaseFragment {
    @Override
    protected Class getThisClass() {
        return null;
    }

    @Override
    protected void loadData(View view) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.concern_fragment_layout;
    }

    @Override
    protected void detach() {

    }

    public static FollowFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FollowFragment fragment = new FollowFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
