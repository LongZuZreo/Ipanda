package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabListBeanDb;

/**
 * Created by 张志远 on 2017/4/11.
 */

public class PandaLiveChinaGridItemAdapter extends MyCommonBaseAdapter<ChinaLiveTabListBeanDb> {

    private boolean deleteAble=false;

    public PandaLiveChinaGridItemAdapter(Context context, List<ChinaLiveTabListBeanDb> datas) {
        super(context, datas, R.layout.china_live_grid_item);
    }

    @Override
    protected void display(CommonViewHolder holder, ChinaLiveTabListBeanDb chinaLiveTabListBeanDb) {
        TextView textView = holder.getView(R.id.mText);

        textView.setText(chinaLiveTabListBeanDb.getTitle());

        ImageView deleteBtn = holder.getView(R.id.deleteBtn);

        if (deleteAble){

            deleteBtn.setVisibility(View.VISIBLE);
        }else {
            deleteBtn.setVisibility(View.GONE);
        }
    }

    public void setDeleteAble(boolean deleteAble){
        this.deleteAble=deleteAble;
    }


}
