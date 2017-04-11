package cctv.cn.ipanda.adapter;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaListEntity;

/**
 * Created by 张志远 on 2017/4/10.
 */

public class PandaLiveChinaItemAdapter extends BaseAdapter<IPandaLiveChinaListEntity.LiveBean>{


    public PandaLiveChinaItemAdapter(Context context, List<IPandaLiveChinaListEntity.LiveBean> datas) {
        super(context, R.layout.fragment_panda_live_china_list_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, IPandaLiveChinaListEntity.LiveBean liveBean) {

        ImageView imageView = holder.getView(R.id.mImage);

        Glide.with(context).load(liveBean.getImage()).into(imageView);

        final TextView briefText = holder.getView(R.id.mTextContent);

        briefText.setText(liveBean.getBrief());

        holder.setText(R.id.mTextTitle,liveBean.getTitle());

        holder.setOnclickListener(R.id.mCheckbox, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked){

                    briefText.setVisibility(View.VISIBLE);

                }else{
                    briefText.setVisibility(View.GONE);
                }
            }
        });
    }
}
