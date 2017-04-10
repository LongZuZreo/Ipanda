package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.fragment.PandaLiveLiveFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLivePersenterImpl;

/**
 * Created by lenovo on 2017/4/10.
 */

public class PandaLiveLiveGridViewAdapter extends MyCommonBaseAdapter<PandaLiveDuoshijiaoBean.ListBean> {

    public PandaLiveLiveGridViewAdapter(Context context, List<PandaLiveDuoshijiaoBean.ListBean> datas) {
        super(context, datas, R.layout.fragment_panda_live_duoshijiaolive_item);
    }

    @Override
    protected void display(CommonViewHolder holder, PandaLiveDuoshijiaoBean.ListBean listBean) {

        holder.setImage(R.id.panda_live_duoshijiao_image, listBean.getImage())
                .setText(R.id.panda_live_duoshijiao_title, listBean.getTitle());
    }
}
