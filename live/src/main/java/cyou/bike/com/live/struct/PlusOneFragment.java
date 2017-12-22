package cyou.bike.com.live.struct;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cyou.bike.com.live.R;


/**

 */
public class PlusOneFragment extends Fragment {
    public static final String INAME = PlusOneFragment.class.getName()+"NRNP";
    private FunctionManagers mFunctionManagers;

    public void setFunctionManager(FunctionManagers manager) {
        this.mFunctionManagers = manager;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.setFunctionForFragment(getTag());
        }
    }

    public PlusOneFragment() {
       super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        return view;
    }

    public void onButtonPressed(Uri uri) {
       if (null != mFunctionManagers) {

           //触发回调函数
           mFunctionManagers.invoke(INAME);
           String string = mFunctionManagers.invoke(PlusOneFragment.INAME, String.class);
       }
    }

}
