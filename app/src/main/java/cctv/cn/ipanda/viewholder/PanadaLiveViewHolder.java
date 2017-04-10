package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaLiveViewHolder extends RecyclerView.ViewHolder{

    public final TextView panadaLiveTitle;
    public  final GridView panadaLiveGridView;

    public PanadaLiveViewHolder(View itemView) {
        super(itemView);
        panadaLiveTitle = (TextView) itemView.findViewById(R.id.mPanadaLive_title);
        panadaLiveGridView = (GridView) itemView.findViewById(R.id.mPanadaLive_GridView);
    }
}
