package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaWallLiveViewHolder extends RecyclerView.ViewHolder {

    public  final TextView panadaWallLiveTitle;
    public  final GridView panadaWallLiveGridView;

    public PanadaWallLiveViewHolder(View itemView) {
        super(itemView);
        panadaWallLiveTitle = (TextView) itemView.findViewById(R.id.mPanadaWalllive_title);
        panadaWallLiveGridView = (GridView) itemView.findViewById(R.id.mPanadaWalllive_Gridview );
    }
}
