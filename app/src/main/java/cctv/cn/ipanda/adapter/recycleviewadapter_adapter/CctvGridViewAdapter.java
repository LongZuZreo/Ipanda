package cctv.cn.ipanda.adapter.recycleviewadapter_adapter;

import android.content.Context;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.http.RetrofitUtils;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.presenter.panada_home.HomePresentImp;

/**
 * Created by ASUS on 2017/4/10.
 */

public class CctvGridViewAdapter extends MyCommonBaseAdapter<CctvAgainBean.ListBean>{

    public CctvGridViewAdapter(Context context, List<CctvAgainBean.ListBean> datas) {
        super(context, datas, R.layout.recycleview_cctv_item_gridview);
    }

    @Override
    protected void display(CommonViewHolder holder, CctvAgainBean.ListBean cctvBean) {
        holder.setText(R.id.mPanadaCCTV_GridView_message,cctvBean.getTitle());
        holder.setImage(R.id.mPanadaCCTV_GridView_image,cctvBean.getImage());

    }
}
