package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/7.
 */

public class JCTJViewHolder extends RecyclerView.ViewHolder{

    public  final ImageView titleImage;
    public  final TextView titleText;
    public  final LinearLayout linearLayout;


    public JCTJViewHolder(View itemView) {
        super(itemView);
        titleImage = (ImageView) itemView.findViewById(R.id.mtitleImage);
        titleText = (TextView) itemView.findViewById(R.id.mtitleText);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.tuijian_horizontal_group);
    }
}
