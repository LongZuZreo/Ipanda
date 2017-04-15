package cctv.cn.ipanda.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveTalkListBean;

/**
 * Created by lenovo on 2017/4/12.
 */

public class PandaPersonFragment extends BaseFragment implements LiveContract.View, View.OnClickListener {

    private ImageView back_img;
    private RelativeLayout user_name_img;
    private RelativeLayout user_guankanlishi;
    private RelativeLayout user_wodeshoucang;
    private RelativeLayout user_setting;
    private BaseFragment currentFragment;
    private BaseFragment personInfoFragment;
    private BaseFragment watchHistoryFragment;
    private BaseFragment myCollectionFragment;
    private BaseFragment settingFragment;
    private BaseFragment pandaLoginFragment;

    @Override
    protected int getLayoutId() {

        return R.layout.panda_person_view;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

        personInfoFragment = new PersonInfoFragment();
        watchHistoryFragment = new WatchHistoryFragment();
        myCollectionFragment = new MyCollectionFragment();
        pandaLoginFragment = new PandaLoginFragment();
        settingFragment = new SettingFragment();
    }

    @Override
    protected void initView(View view) {

        user_name_img = (RelativeLayout) view.findViewById(R.id.panda_person_username);
        user_guankanlishi = (RelativeLayout) view.findViewById(R.id.panda_person_guankanlishi);
        user_wodeshoucang = (RelativeLayout) view.findViewById(R.id.panda_person_wodeshoucang);
        user_setting = (RelativeLayout) view.findViewById(R.id.panda_person_setting);
    }

    @Override
    protected void initListener() {

        user_name_img.setOnClickListener(this);
        user_guankanlishi.setOnClickListener(this);
        user_wodeshoucang.setOnClickListener(this);
        user_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.panda_person_username:

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFragment(personInfoFragment, null, true);
//                mainActivity.changeFragment(pandaLoginFragment, null, true);
                mainActivity.changTitle(2, "个人信息");
                break;
            case R.id.panda_person_guankanlishi:

                MainActivity mainActivity1 = (MainActivity) getActivity();
                mainActivity1.changeFragment(watchHistoryFragment, null, true);
                break;
            case R.id.panda_person_wodeshoucang:

                MainActivity mainActivity2 = (MainActivity) getActivity();
                mainActivity2.changeFragment(myCollectionFragment, null, true);
                break;
            case R.id.panda_person_setting:

                MainActivity mainActivity3 = (MainActivity) getActivity();
                mainActivity3.changeFragment(settingFragment, null, true);
                mainActivity3.changTitle(2,"设置");
                break;
        }
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public void clickTabToOtherList() {

    }

    @Override
    public void showDetail(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void dismissDetail() {

    }

    @Override
    public void sendMessageSuccess() {

    }

    @Override
    public void addMessageSuccess() {

    }

    @Override
    public void clickTabtoHome() {

    }

    @Override
    public void showLiveFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void showLiveTitle() {

    }

    @Override
    public void showEyeFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void showEyeTitle() {

    }

    @Override
    public void showJcyk(PandaLiveJcyiBean pandaLiveJcyiBean) {

    }

    @Override
    public void showTalkList(PandaLiveTalkListBean pandaLiveJcyiBean) {

    }

    @Override
    public void loadTab2(PandaLiveBqBean pandaLiveBqBean) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void loadError() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void toPersonCenter() {

    }

    @Override
    public void toVideoPlay() {

    }

    @Override
    public void changeTitleBar() {

    }
}
