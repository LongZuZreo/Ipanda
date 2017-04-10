package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaListBeanViewHolder extends RecyclerView.ViewHolder{

    public final TextView panadaListBeanTitle;
    public final ListView panadaListBeanListView;

    public PanadaListBeanViewHolder(View itemView) {
        super(itemView);
        panadaListBeanTitle = (TextView) itemView.findViewById(R.id.mPanadaListBean_title);
        panadaListBeanListView = (ListView) itemView.findViewById(R.id.mPanadaListBean_listView);
    }
}
