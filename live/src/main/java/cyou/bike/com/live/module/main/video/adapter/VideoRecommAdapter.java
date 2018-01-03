package cyou.bike.com.live.module.main.video.adapter;/**
 * Created by anlonglong on 2017/12/24.
 */

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.dialog.RxDialog;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cyou.bike.com.live.R;
import cyou.bike.com.live.module.main.home.adapter.BindValueHelper;
import cyou.bike.com.live.module.main.video.activity.WebActivity;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoSection;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/24 at 12:50
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoRecommAdapter extends BaseSectionQuickAdapter<VideoSection, BaseViewHolder> {

    private String mTitle;

    public VideoRecommAdapter(List<VideoSection> data) {
        super(R.layout.video_item_content, R.layout.item_head, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, VideoSection item) {
        SuperTextView headItem = helper.getView(R.id.stv_title_info);
        headItem.setLeftString(item.header);
        @IdRes int headIcon;
        switch (item.header) {
            case "热门视频":
                headIcon = R.drawable.reco_game_txt_icon;
                headItem.setRightIcon(R.drawable.icon_change_room);
                break;
            default:
                headIcon = R.drawable.icon_column;
        }
        headItem.setLeftIcon(headIcon);
        headItem.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                RxToast.info(superTextView.getLeftString());
            }
        });
    }

    @Override
    protected void convert(final BaseViewHolder holder, VideoSection item) {
      String videoTitle="";
      final BindValueHelper valueHelper = holder.itemView.getTag() == null?setTag(holder): (BindValueHelper) holder.itemView.getTag();
        valueHelper.bindValue(new BindValueHelper.BindValueListener<VideoSection>() {
            @Override
            public void bindValue(VideoSection videoSection) {
                String coverSrc;
                String repo;
                String title;
                String name;
                String number;
                if (null != videoSection.t) {
                    if (videoSection.t.getCateHotVideoList() != null) {
                        CateHotVideoList.DataBean bean = videoSection.t.getCateHotVideoList();
                        CateHotVideoList.DataBean.VideoListBean videoListBean = bean.getVideo_list().get(holder.getLayoutPosition());
                        coverSrc = videoListBean.getVideo_cover();
                        repo = videoListBean.getCtime()+"";
                        mTitle = title = videoListBean.getVideo_title();
                        name = videoListBean.getNickname();
                        int num = videoListBean.getView_num();
                        if (num > 10000) {
                            number = holder.itemView.getContext().getResources().getString(R.string.number, num / 10000.0);
                            LogUtil.i("xliff = ",holder.itemView.getContext().getResources().getString(R.string.number, num / 10000.0));
                        }else {
                            number = String.valueOf(num);
                        }
                        valueHelper.binderVideoValue(coverSrc,repo,title,name,number,videoListBean.getHash_id());
                    }else if (videoSection.t.getHotVideoList() != null) {
                        HotVideoList.DataBean bean = videoSection.t.getHotVideoList();
                        coverSrc = bean.getVideo_cover();
                        repo = bean.getRpos();
                        mTitle = title = bean.getVideo_title();
                        name = bean.getNickname();
                        int num = bean.getView_num();
                        if (num > 10000) {
                            number = holder.itemView.getContext().getResources().getString(R.string.number, num / 10000.0);
                           // LogUtil.i("xliff = ",holder.itemView.getContext().getResources().getString(R.string.number, (float)num / 10000.0));
                        }else {
                            number = String.valueOf(num);
                        }
                        valueHelper.binderVideoValue(coverSrc,repo,title,name,number,bean.getHash_id());
                    }else if (videoSection.t.getVideoListBean() != null) {
                        CateHotVideoList.DataBean.VideoListBean bean = videoSection.t.getVideoListBean();
                        coverSrc = bean.getVideo_cover();
                        repo = bean.getRpos();
                        mTitle = title = bean.getVideo_title();
                        name = bean.getNickname();
                        int num = bean.getView_num();
                        if (num > 10000) {
                            number = holder.itemView.getContext().getResources().getString(R.string.number, num / 10000.0);
                           // LogUtil.i("xliff = ",holder.itemView.getContext().getResources().getString(R.string.number, num / 10000.0));
                        }else {
                            number = String.valueOf(num);
                        }
                        valueHelper.binderVideoValue(coverSrc,repo,title,name,number,bean.getHash_id());
                    }

                }
            }
        },item);
        valueHelper.setOnItemClickListener(new BindValueHelper.OnItemClickListener() {
            @Override
            public void click(Context context, String hashID, boolean yanzhi) {
                WebActivity.start(context,hashID, mTitle);
            }
        });
    }

    private BindValueHelper setTag(BaseViewHolder holder) {
        BindValueHelper valueHelper = new BindValueHelper(holder);
        holder.itemView.setTag(valueHelper);
        return valueHelper;
    }
}
