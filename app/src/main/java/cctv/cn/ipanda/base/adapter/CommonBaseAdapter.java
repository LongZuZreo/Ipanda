package cctv.cn.ipanda.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 张志远 on 2017/4/6.
 */

public abstract class CommonBaseAdapter<T> extends BaseAdapter {

    protected int layoutId;

    protected Context context;

    protected List<T> datas;
    public CommonBaseAdapter(Context context, List<T> datas, int layoutId) {

        this.layoutId=layoutId;

        this.context=context;

        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
