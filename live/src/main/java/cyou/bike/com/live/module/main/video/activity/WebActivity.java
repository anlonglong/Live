package cyou.bike.com.live.module.main.video.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebView;
import com.just.agentweb.ChromeClientCallbackManager;
import com.just.agentweb.DefaultWebClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cyou.bike.com.live.R;
import cyou.bike.com.live.module.main.home.activity.SwipeActivity;
import cyou.bike.com.live.utils.LogUtil;

public class WebActivity extends SwipeActivity {


    private static final String HASHID = "hash_id";
    private static final String VIDEOTITLE = "video_title";
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.container)
    LinearLayout mContainer;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.awv)
    WebView mAwv;
    private AgentWeb mAgentWeb;

    public static void start(Context context, String hsadId, String title) {
        Intent starter = new Intent(context, WebActivity.class);
        starter.putExtra(HASHID, hsadId);
        starter.putExtra(VIDEOTITLE, title);
        context.startActivity(starter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.video_web_activity;
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void detach() {
        mAgentWeb.getWebLifeCycle().onDestroy();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData(Intent intent) {
        String hsahId = intent.getStringExtra(HASHID);
        mTitle.setText(intent.getStringExtra(VIDEOTITLE));
        String url = "https://v.douyu.com/show/" + hsahId;
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mContainer, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.strict)
                .setOpenOtherAppWays(DefaultWebClient.OpenOtherAppWays.ASK)
                .openParallelDownload()//打开并行下载 , 默认串行下载
                .setNotifyIcon(R.mipmap.download) //下载图标
                .interceptUnkownScheme() //拦截找不到相关页面的Scheme
                .createAgentWeb()//
                .ready().go(url);
    }

    @OnClick(R.id.back)
    public void click(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                LogUtil.i("", "unknow id");
        }
    }

    private ChromeClientCallbackManager.ReceivedTitleCallback mCallback = new ChromeClientCallbackManager.ReceivedTitleCallback() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            LogUtil.i("onReceivedTitle = ", title);
        }
    };

}
