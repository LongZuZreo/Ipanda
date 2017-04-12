package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.click_listener.MyClickListener;
import cctv.cn.ipanda.common.Params;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabAllListBeanDb;

/**
 * Created by 张志远 on 2017/4/11.
 */

public class PandaLiveChinaAllGridItemAdapter extends MyCommonBaseAdapter<ChinaLiveTabAllListBeanDb>{

    public PandaLiveChinaAllGridItemAdapter(Context context, List<ChinaLiveTabAllListBeanDb> datas) {
        super(context, datas, R.layout.china_live_grid_item);
    }
    private MyClickListener clickListener;

    public void setClickListener(MyClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    protected void display(CommonViewHolder holder, final ChinaLiveTabAllListBeanDb chinaLiveTabAllListBeanDb) {

        TextView mText = holder.getView(R.id.mText);

        mText.setText(chinaLiveTabAllListBeanDb.getTitle());

        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag("AllTab");
                v.setTag(R.id.mText,chinaLiveTabAllListBeanDb);
                clickListener.onClick(v);
            }
        });
    }
}
