package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaChinaLiveViewHolder extends RecyclerView.ViewHolder{

    public  final TextView panadaChinaLiveTitle;
    public final GridView panadaChinaLiveGridView;

    public PanadaChinaLiveViewHolder(View itemView) {
        super(itemView);
        panadaChinaLiveTitle = (TextView) itemView.findViewById(R.id.mPanadaChinalive_title);
        panadaChinaLiveGridView = (GridView) itemView.findViewById(R.id.mPanadaChinalive_GridView);
    }
}
