package cyou.bike.com.live.module.main.my;

import android.os.Bundle;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.library.SuperTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;

/**
 * Created by：anlonglong
 * on 2017/12/7 17:36
 * Email: anlonglong0721@gmail.com
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.me_bg)
    ImageView mMeBg;
    @BindView(R.id.login)
    TextView mLogin;
    @BindView(R.id.register)
    TextView mRegister;
    @BindView(R.id.history)
    TextView mHistory;
    @BindView(R.id.message)
    TextView mMessage;
    @BindView(R.id.task)
    TextView mTask;
    @BindView(R.id.recharge)
    TextView mRecharge;
    @BindView(R.id.guide)
    Guideline mGuide;
    @BindView(R.id.anchor)
    SuperTextView mAnchor;
    @BindView(R.id.video)
    SuperTextView mVideo;
    @BindView(R.id.line1)
    View mLine1;
    @BindView(R.id.collec)
    SuperTextView mCollec;
    @BindView(R.id.account)
    SuperTextView mAccount;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.game)
    SuperTextView mGame;


    @Override
    protected Class getThisClass() {
        return null;
    }

    @Override
    protected void loadData(View view) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.my_fragment_layout;
    }

    @Override
    protected void detach() {

    }

    public static MyFragment newInstance() {
        Bundle args = new Bundle();
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @OnClick({R.id.login, R.id.register, R.id.history, R.id.message, R.id.task, R.id.recharge, R.id.anchor, R.id.video, R.id.collec, R.id.account, R.id.game})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                break;
            case R.id.register:
                break;
            case R.id.history:
                break;
            case R.id.message:
                break;
            case R.id.task:
                break;
            case R.id.recharge:
                break;
            case R.id.anchor:
                break;
            case R.id.video:
                break;
            case R.id.collec:
                break;
            case R.id.account:
                break;
            case R.id.game:
                break;
        }
    }
}
