package cctv.cn.ipanda.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.presenter.pandalive.PandaLivePresenterImpl;

/**
 * Created by lenovo on 2017/4/7.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View {

    private ImageView panda_live_image;
    private TextView panda_live_title;
    private CheckBox panda_live_detail;
    private TextView getPanda_live_detailInfo;
    private PandaLivePresenterImpl pandaLivePresenter;
    private PandaLiveBean.LiveBean liveBean;

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_panda_live_live;
    }

    @Override
    protected void initView(View view) {

        panda_live_title = (TextView) view.findViewById(R.id.panda_live_title);
        panda_live_detail = (CheckBox) view.findViewById(R.id.panda_live_detail);
        panda_live_image = (ImageView) view.findViewById(R.id.panda_live_image);
        getPanda_live_detailInfo = (TextView) view.findViewById(R.id.panda_live_detailInfo);

    }

    @Override
    protected void initData() {

        pandaLivePresenter = new PandaLivePresenterImpl(getActivity());
    }

    @Override
    protected void loadData() {

        pandaLivePresenter.getData(Urls.PANDALIVE, null, new MyCallback<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {

                if (pandaLiveBean != null) {
                    List<PandaLiveBean.LiveBean> live = pandaLiveBean.getLive();

                    if (live != null) {

                        for (int i = 0; i < live.size(); i++) {

                            liveBean = live.get(i);
                        }
                    }
                }
            }

            @Override
            public void onError(String msg) {

                Toast.makeText(getActivity(), "网络请求失败", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(getActivity()).load(liveBean.getImage()).into(panda_live_image);
        panda_live_title.setText(liveBean.getTitle());

        if (panda_live_detail.isChecked()) {

            getPanda_live_detailInfo.setSystemUiVisibility(View.VISIBLE);
            getPanda_live_detailInfo.setText(liveBean.getBrief());
        }

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void clickTabToOtherList() {

    }

    @Override
    public void showDetail() {

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
    public void loadTab() {

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
