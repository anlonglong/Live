package cyou.bike.com.live.module.live.danmu;

/**
 * Created by：anlonglong
 * on 2017/12/5 15:53
 * Email: anlonglong0721@gmail.com
 */

public class KeepGetMsg extends Thread {
    @Override
    public void run() {
        ////获取弹幕客户端
        DyBulletScreenClient danmuClient = DyBulletScreenClient.getInstance();

        //判断客户端就绪状态
        while (danmuClient.getReadyFlag()) {
            //获取服务器发送的弹幕信息
            danmuClient.getServerMsg();
        }
    }
}
