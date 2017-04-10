package cctv.cn.ipanda.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;

/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLiveRecycleAdapter extends BaseAdapter<PandaLiveBqBean.TablistBean> {

    public PandaLiveRecycleAdapter(Context context, List<PandaLiveBqBean.TablistBean> datas) {
        super(context, R.layout.fragment_panda_live_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, PandaLiveBqBean.TablistBean tablistBean) {

        holder.setText(R.id.panda_live_item_title, tablistBean.getTitle());
    }
}
