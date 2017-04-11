package cctv.cn.ipanda.adapter.recycleviewadapter_adapter;



import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;

/**
 * Created by ASUS on 2017/4/11.
 */

public class PullToRefreshRecycleViewAdapter extends BaseAdapter<Object> {

    public PullToRefreshRecycleViewAdapter(Context context, int layoutId, List<Object> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, Object o) {

    }
}
