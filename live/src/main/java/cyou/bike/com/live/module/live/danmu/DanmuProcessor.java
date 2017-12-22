package cyou.bike.com.live.module.live.danmu;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.BaseCacheStuffer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SpannedCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.danmaku.parser.android.BiliDanmukuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

/**
 * Created by：anlonglong
 * on 2017/12/5 14:52
 * Email: anlonglong0721@gmail.com
 */

public class DanmuProcessor {
    private DanmakuContext mDanmakuContext;
    private BaseDanmakuParser mDanmakuParser;
    private DanmakuView mDanmakuView;
    /**
     * 弹幕  随机颜色
     */
    private Random random;
    private int[] ranColor = {
                                0xe0ffffff,
                                0xe0F0E68C,
                                0xe0F08080,
                                0xe0FFC0CB,
                                0xe000FA9A,
                                0xe000FF7F,
                                0xe0FFD700,
                                0xe07FFFD4,
                                0xe0FF7F50,
                                0xe0DC143C,
                                0xe0FFC0CB,
                                0xe0DB7093,
                                0xe87CEEB
                                };
    private DyBulletScreenClient mDanmuClient;

    public DanmuProcessor() {
        random = new Random();
    }

    public void configDanmu() {
        HashMap<Integer, Integer> maxLine = new HashMap<>();
        HashMap<Integer, Boolean> overLappingEnablePair = new HashMap<>();
        maxLine.put(BaseDanmaku.TYPE_SCROLL_LR, 6);
        overLappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_LR, true);
        overLappingEnablePair.put(BaseDanmaku.TYPE_FIX_TOP, true);
        mDanmakuContext = DanmakuContext.create();
        mDanmakuContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3)
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f)//是否启用合并重复弹幕
                .setScaleTextSize(1.2f)//设置弹幕滚动速度系数,只对滚动弹幕有效
                .setCacheStuffer(new SpannedCacheStuffer(), mCacheStufferAdapter)// 图文混排使用SpannedCacheStuffer  设置缓存绘制填充器，
                // 默认使用{@link SimpleTextCacheStuffer}只支持纯文字显示,
                // 如果需要图文混排请设置{@link SpannedCacheStuffer}
                // 如果需要定制其他样式请扩展{@link SimpleTextCacheStuffer}|{@link SpannedCacheStuffer}
                .setMaximumLines(maxLine)//设置最大显示行数
                .preventOverlapping(overLappingEnablePair);//设置防弹幕重叠，null为允许重叠
    }

    public void setCallBack( DanmakuView danmakuView) {
           this.mDanmakuView = danmakuView;
        if (null != danmakuView) {
            //创建解析器对象，从raw资源目录下解析comments.xml文本
            mDanmakuParser = cretaeParse(null);
            danmakuView.setCallback(new DrawHandler.Callback() {
                @Override
                public void prepared() {
                    mDanmakuView.start();
                }

                @Override
                public void updateTimer(DanmakuTimer timer) {

                }

                @Override
                public void danmakuShown(BaseDanmaku danmaku) {

                }

                @Override
                public void drawingFinished() {

                }
            });
            mDanmakuView.prepare(mDanmakuParser, mDanmakuContext);
            mDanmakuView.show();//是否显示FPS
            mDanmakuView.enableDanmakuDrawingCache(true);
        }
    }


    public void addDanmu(final int roomId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDanmuClient = DyBulletScreenClient.getInstance();
                int groupId = -9999;
                mDanmuClient.start(roomId, groupId);
                mDanmuClient.setmHandleMsgListener(new DyBulletScreenClient.HandleMsgListener() {
                    @Override
                    public void handleMessage(String txt) {
                        addDanmaku(true, txt);
                    }
                });
            }
        }).start();
    }

    private void addDanmaku(boolean islive, String txt) {
        BaseDanmaku danmaku = mDanmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        if (danmaku == null || mDanmakuView == null) {
            return;
        }
        danmaku.text = txt;
        danmaku.padding = 10;
        danmaku.priority = 1;
        danmaku.isLive = islive;
        danmaku.textSize = 15f * (mDanmakuParser.getDisplayer().getDensity() - 0.6f);
        danmaku.time = mDanmakuView.getCurrentTime();
        mDanmakuView.addDanmaku(danmaku);
    }

    private BaseDanmakuParser cretaeParse(InputStream stream) {
        if (stream == null) {
            return new BaseDanmakuParser() {

                @Override
                protected Danmakus parse() {
                    return new Danmakus();
                }
            };
        }

        // DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI) //xml解析
        // DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_ACFUN) //json文件格式解析
        ILoader loader = DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI);
        try {
            loader.load(stream);
        } catch (IllegalDataException e) {
            e.printStackTrace();
        }
        BaseDanmakuParser parser  = new BiliDanmukuParser();
        IDataSource<?> dataSource = loader.getDataSource();
        parser.load(dataSource);
        return parser;
    }
    public void finish() {
        //停止从服务器获取弹幕
        mDanmuClient.stop();
    }

    private BaseCacheStuffer.Proxy mCacheStufferAdapter = new BaseCacheStuffer.Proxy() {

        @Override
        public void prepareDrawing(final BaseDanmaku danmaku, boolean fromWorkerThread) {
        }

        @Override
        public void releaseResource(BaseDanmaku danmaku) {
            danmaku.text = null;
        }
    };


    class BackgroundCacheStuffer extends SpannedCacheStuffer {
        // 通过扩展SimpleTextCacheStuffer或SpannedCacheStuffer个性化你的弹幕样式
        final Paint paint = new Paint();
        final RectF rf = new RectF();

        @Override
        public void measure(BaseDanmaku danmaku, TextPaint paint, boolean fromWorkerThread) {
            danmaku.padding = 15;  // 在背景绘制模式下增加padding

            super.measure(danmaku, paint, fromWorkerThread);
        }

        @Override
        public void drawBackground(BaseDanmaku danmaku, Canvas canvas, float left, float top) {
            int ranNumber = random.nextInt(ranColor.length);
            int color = ranColor[ranNumber];
            paint.setAntiAlias(true);
            if (color != 0xe0ffffff && ranNumber % 2 == 0) {
                paint.setColor(color);  //弹幕背景颜色
                rf.left = left;
                rf.right = left + danmaku.paintWidth;
                rf.top = top;
                rf.bottom = top + danmaku.paintHeight;
                danmaku.textColor = 0xe0ffffff;
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(rf, 40, 40, paint);
            } else {
                danmaku.textColor = color;
                paint.setColor(color);  //弹幕背景颜色
                rf.left = left;
                rf.right = left + danmaku.paintWidth;
                rf.top = top;
                rf.bottom = top + danmaku.paintHeight;
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawRoundRect(rf, 40, 40, paint);
            }
        }

        @Override
        public void drawStroke(BaseDanmaku danmaku, String lineText, Canvas canvas, float left, float top, Paint paint) {
            // 禁用描边绘制
        }


        public void close() {

            if (mDanmakuView != null) {
                mDanmakuView = null;
            }
            if (mDanmakuContext != null) {
                mDanmakuContext = null;
            }
            if (mDanmuClient != null) {
                mDanmuClient = null;
            }
            if (mDanmakuParser != null) {
                mDanmakuParser = null;
            }

        }
    }
}
