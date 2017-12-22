package cyou.bike.com.live.module.main.home.module;

import cyou.bike.com.live.annotation.DefSystemType;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.contract.HomeContract;
import cyou.bike.com.live.module.main.home.contract.HomeContract.HomeMoudle;
import cyou.bike.com.live.module.main.home.fragment.HomeFragment;

/**
 * Created by：anlonglong
 * on 2017/11/1 10:55
 * Email: anlonglong0721@gmail.com
 */
@SuppressWarnings("unused")
public class HomeModule implements HomeMoudle {

    public HomeModule() {
    }

    @Override
    public HomeContract.View getView() {
        return InstanceProxy.getInstance().getView(HomeFragment.class);
    }

    @Override
    public void getCateList(int limit, @DefSystemType SystemType sysType, int offset) {

    }


}
