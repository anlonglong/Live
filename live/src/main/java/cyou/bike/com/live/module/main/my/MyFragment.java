package cyou.bike.com.live.module.main.my;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;

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

    @BindView(R.id.share)
    TextView mShare;
    @BindView(R.id.bottomsheet)
    BottomSheetLayout mBottomsheet;

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


    @OnClick(R.id.share)
    public void onViewClicked() {

    }
}
