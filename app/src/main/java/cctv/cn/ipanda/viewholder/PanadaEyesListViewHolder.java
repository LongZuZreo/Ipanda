package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/14.
 */

public class PanadaEyesListViewHolder extends RecyclerView.ViewHolder{
    public final ListView panadaeyesListView;
    public PanadaEyesListViewHolder(View itemView) {
        super(itemView);
        panadaeyesListView = (ListView) itemView.findViewById(R.id.mPanadaeyes_listview);
    }
}
