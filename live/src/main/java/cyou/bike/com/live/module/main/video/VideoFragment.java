package cyou.bike.com.live.module.main.video;

import android.os.Bundle;
import android.view.View;

import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;

/**
 * Created by：anlonglong
 * on 2017/12/7 17:33
 * Email: anlonglong0721@gmail.com
 */

public class VideoFragment extends BaseFragment {


    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {
//{"error":0,"data":[{"cid1":"1","cate1_name":"\u6e38\u620f\u7ade\u6280","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/09\/12\/e17f24d55792bf6ab491227bbea5a901.png"},{"cid1":"102","cate1_name":"\u5ba2\u5385\u6e38\u620f","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/09\/12\/ce5a5bdc6d32b89bb29bec8349c55fcb.png"},{"cid1":"51","cate1_name":"\u79fb\u52a8\u6e38\u620f","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/09\/12\/92f72a17e8fb0ca887bf99f3288bd430.png"},{"cid1":"3","cate1_name":"\u661f\u79c0\u5a31\u4e50","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/10\/27\/20372ed0dd7e1ab866a6fe1d953dc7d6.png"},{"cid1":"108","cate1_name":"\u6570\u7801\u79d1\u6280","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/09\/19\/033302d1c2f94532891d88cca5320bc3.png"},{"cid1":"109","cate1_name":"\u6587\u5a31\u8bfe\u5802","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/09\/19\/356071804aa7c31193210a0fb6daf902.png"},{"cid1":"129","cate1_name":"\u6b63\u80fd\u91cf","mobile_icon":"https:\/\/cs-op.douyucdn.cn\/vod-index\/2017\/11\/01\/c397d386c134310eda1a1c45ea8b9945.png"}]}标题
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.vodeo_fragment_layout;
    }

    @Override
    protected void detach() {

    }

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }
}
