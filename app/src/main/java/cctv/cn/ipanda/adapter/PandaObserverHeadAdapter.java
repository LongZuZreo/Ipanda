package cctv.cn.ipanda.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;

/**
*
*@author king
*Created at 2017-04-07 14:33
*
*/

public class PandaObserverHeadAdapter extends BaseAdapter<PandaObserverHeadEntity.DataBean> {


    public PandaObserverHeadAdapter(Context context, int layoutId, List<PandaObserverHeadEntity.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, PandaObserverHeadEntity.DataBean dataBean) {

    }
}
