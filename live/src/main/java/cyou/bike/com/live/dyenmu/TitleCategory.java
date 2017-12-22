package cyou.bike.com.live.dyenmu;

import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/11/23 09:52
 * Email: anlonglong0721@gmail.com
 */
@SuppressWarnings("unused")
public enum TitleCategory {
    FACEVALUE("颜值"),DIGHOTDATA("最热");

    private String mCate;

    TitleCategory(String type) {
        this.mCate = type;
    }

    public String getCate() {
        return mCate;
    }

    public TitleCategory formName(String category) {
        TitleCategory cate = null;
        try {
            cate = valueOf(category);
        }catch (Exception e) {
            LogUtil.e("TitleCategory","not found system type ,"+category,e);
        }
        return cate;
    }
}
