package cctv.cn.ipanda.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaInteractiveViewHolder extends RecyclerView.ViewHolder{

    public final ImageView panadaInteractiveImage;
    public final TextView panadaInteractiveTitle;
    public final TextView panadaInteractiveMessage;

    public PanadaInteractiveViewHolder(View itemView) {
        super(itemView);
        panadaInteractiveImage = (ImageView) itemView.findViewById(R.id.mPanadaInteractive_image);
        panadaInteractiveTitle = (TextView) itemView.findViewById(R.id.mPanadaInteractive_title);
        panadaInteractiveMessage = (TextView) itemView.findViewById(R.id.mPanadaInteractive_message);
    }
}
