package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaCCTVViewHolder extends RecyclerView.ViewHolder{

    public final TextView panadaCCTVTitle;
    public final GridView panadaCCTVGridView;

    public PanadaCCTVViewHolder(View itemView) {
        super(itemView);
        panadaCCTVTitle = (TextView) itemView.findViewById(R.id.mPanadaCCTV_Title);
        panadaCCTVGridView = (GridView) itemView.findViewById(R.id.mPanadaCCTV_GridView);
    }
}
