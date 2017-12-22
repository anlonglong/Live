package cyou.bike.com.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by：anlonglong
 * on 2017/12/11 10:51
 * Email: anlonglong0721@gmail.com
 */

public class CircleIndication extends View {
    public CircleIndication(Context context) {
        this(context,null);
    }

    public CircleIndication(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleIndication(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
