package cyou.bike.com.live.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorRes;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;

import java.text.MessageFormat;

/**
 * Created by：anlonglong
 * on 2017/10/19 11:54
 * Email: anlonglong0721@gmail.com
 */

public class CommentUtil {

    public CommentUtil() {
        throw new UnsupportedOperationException("you can't instance me (￣ε(#￣)☆╰╮o(￣皿￣///)");
    }


    public static void resetStateBar(Activity activity, @ColorRes int resid) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(resid));
        }
    }

    public static CharSequence fillString(Context context, int strResId, Object... args)
    {
        String str = context.getResources().getString(strResId,args);
        return fillString(str, args);
    }

    public static CharSequence fillHtmlString(Context context, int strResId, Object... args)
    {
        String str = context.getResources().getString(strResId,args);
        return fillHtmlString(str, args);
    }

    public static CharSequence fillString(String baseStr, Object... args)
    {
        return MessageFormat.format(baseStr, args);
    }

    @SuppressWarnings("deprecation")
    public static CharSequence fillHtmlString(String baseStr, Object... args)
    {
        CharSequence str = fillString(baseStr, args);
        str = Html.fromHtml(str.toString());
        return str;
    }

}
