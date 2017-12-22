package cyou.bike.com.live.struct;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import cyou.bike.com.live.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       // getSupportFragmentManager().beginTransaction().replace()
    }

    public void setFunctionForFragment(String tag){
        //找到需要设置会回调函数的fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (null != fragment && fragment instanceof PlusOneFragment) {
            PlusOneFragment f = (PlusOneFragment) fragment;
            //给找到的Fragment注册回调函数.
            f.setFunctionManager(FunctionManagers.getInstance().addFunction(new FunctionNoResultNoParams(PlusOneFragment.INAME) {
                @Override
                public void function() {

                }
            }).addFunction(new FunctionHaveResultNoParams<String>(PlusOneFragment.INAME) {
                @Override
                public String function() {
                    return "";
                }
            }).addFuncation(new FunctionHaveResultHaveParams<String,Integer>(PlusOneFragment.INAME) {
                @Override
                public String function(Integer integer) {
                    return null;
                }
            }));
        }
    }

}
