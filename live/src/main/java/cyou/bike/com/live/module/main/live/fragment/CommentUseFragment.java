package cyou.bike.com.live.module.main.live.fragment;

import android.os.Bundle;
import android.view.View;

import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;

/**
 * Created by：anlonglong
 * on 2017/12/16 13:48
 * Email: anlonglong0721@gmail.com
 */

public class CommentUseFragment extends BaseFragment {
    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.comment_use_fragment;
    }

    @Override
    protected void detach() {

    }

    public static CommentUseFragment newInstance() {

        Bundle args = new Bundle();

        CommentUseFragment fragment = new CommentUseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
