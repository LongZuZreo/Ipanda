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
import cctv.cn.ipanda.click_listener.MyClickListener;
import cctv.cn.ipanda.common.Params;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabListBeanDb;

/**
 * Created by 张志远 on 2017/4/11.
 */

public class PandaLiveChinaGridItemAdapter extends DragAdapter<ChinaLiveTabListBeanDb>{

    private boolean deleteAble=false;

    public PandaLiveChinaGridItemAdapter(Context context, List<ChinaLiveTabListBeanDb> datas) {
        super(context, datas, R.layout.china_live_grid_item);
    }

    private MyClickListener clickListener;

    public void setClickListener(MyClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    protected void display(CommonViewHolder holder, final ChinaLiveTabListBeanDb chinaLiveTabListBeanDb) {
        TextView textView = holder.getView(R.id.mText);

        textView.setText(chinaLiveTabListBeanDb.getTitle());

        ImageView deleteBtn = holder.getView(R.id.deleteBtn);

        if (deleteAble){
            deleteBtn.setVisibility(View.VISIBLE);
        }else {
            deleteBtn.setVisibility(View.GONE);
        }

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag("Tab");
                v.setTag(R.id.mText,chinaLiveTabListBeanDb);
                clickListener.onClick(v);
            }
        });
        View convertView = holder.getConvertView();
        if (datas.indexOf(chinaLiveTabListBeanDb) == movePosition && isMove ){
            convertView.setVisibility(View.INVISIBLE);
        }
    }

    public void setDeleteAble(boolean deleteAble){
        this.deleteAble=deleteAble;
    }

}
