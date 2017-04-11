package cctv.cn.ipanda.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabAllListBeanDb;

/**
 * Created by 张志远 on 2017/4/11.
 */

public class PandaLiveChinaAllGridItemAdapter extends MyCommonBaseAdapter<ChinaLiveTabAllListBeanDb>{

    public PandaLiveChinaAllGridItemAdapter(Context context, List<ChinaLiveTabAllListBeanDb> datas) {
        super(context, datas, R.layout.china_live_grid_item);
    }

    @Override
    protected void display(CommonViewHolder holder, ChinaLiveTabAllListBeanDb chinaLiveTabAllListBeanDb) {
        holder.setText(R.id.mText,chinaLiveTabAllListBeanDb.getTitle());
    }
}
