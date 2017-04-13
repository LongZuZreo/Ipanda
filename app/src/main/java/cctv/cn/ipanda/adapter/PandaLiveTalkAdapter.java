package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.fragment.PandaLiveEyeFragment;
import cctv.cn.ipanda.model.pandalive.PandaLiveTalkListBean;

/**
 * Created by lenovo on 2017/4/13.
 */

public class PandaLiveTalkAdapter extends BaseAdapter<PandaLiveTalkListBean.DataBean.ContentBean> {

    public PandaLiveTalkAdapter(Context context, List<PandaLiveTalkListBean.DataBean.ContentBean> datas) {
        super(context, R.layout.panda_live_talklistview_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, PandaLiveTalkListBean.DataBean.ContentBean contentBean) {

        holder.setText(R.id.panda_live_talk_message, contentBean.getMessage())
                .setText(R.id.panda_live_talk_author, contentBean.getAuthor());
    }
}
