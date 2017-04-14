package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaEyesViewHolder extends RecyclerView.ViewHolder{


    public final TextView panadaTitle;
    public final ImageView panadaeyesTitleImage;
    public final TextView panadaeyesTitleTitle1;
    public final TextView panadaeyesTitleMessage1;
    public final TextView panadaeyesTitleTitle2;
    public final TextView panadaeyesTitleMessage2;



    public PanadaEyesViewHolder(View itemView) {
        super(itemView);
        panadaTitle = (TextView) itemView.findViewById(R.id.mPanadaeyes_title);
        panadaeyesTitleImage = (ImageView) itemView.findViewById(R.id.mPanadaeyes_title_image);
        panadaeyesTitleTitle1 = (TextView) itemView.findViewById(R.id.mPanadaeyes_title_title1);
        panadaeyesTitleMessage1 = (TextView) itemView.findViewById(R.id.mPanadaeyes_title_message1);
        panadaeyesTitleTitle2 = (TextView) itemView.findViewById(R.id.mPanadaeyes_title_title2);
        panadaeyesTitleMessage2 = (TextView) itemView.findViewById(R.id.mPanadaeyes_title_message2);

    }
}
