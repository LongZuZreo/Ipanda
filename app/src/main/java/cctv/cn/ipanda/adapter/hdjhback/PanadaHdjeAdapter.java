package cctv.cn.ipanda.adapter.hdjhback;

import android.content.Context;
import android.support.v4.app.INotificationSideChannel;
import android.widget.BaseAdapter;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.panada_hdjh.PanadaInterfactionBean;

/**
 * Created by ASUS on 2017/4/12.
 */

public class PanadaHdjeAdapter extends MyCommonBaseAdapter<PanadaInterfactionBean.InteractiveBean> {
    public PanadaHdjeAdapter(Context context, List<PanadaInterfactionBean.InteractiveBean> datas) {
        super(context, datas, R.layout.fragment_hdjh_item);
    }

    @Override
    protected void display(CommonViewHolder holder, PanadaInterfactionBean.InteractiveBean interactiveBean) {
        holder.setText(R.id.mPanadaHDJH_title, interactiveBean.getTitle());
        holder.setImage(R.id.mPanadaHDJH_image,interactiveBean.getImage());
    }
}
