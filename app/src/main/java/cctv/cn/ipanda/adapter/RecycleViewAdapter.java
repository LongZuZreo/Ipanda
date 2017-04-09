package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.viewholder.JCTJViewHolder;

/**
 * Created by ASUS on 2017/4/7.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter{
    private List<Object> mlist;
    private LayoutInflater inflater;
    private Context context;
    //不同的布局
    public static final int TYPE = 0;
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    public static final int TYPE5 = 5;
    public static final int TYPE6 = 6;
    public static final int TYPE7 = 7;
    public static final int TYPE8 = 8;
    public RecycleViewAdapter(Context context, List<Object> list){
        inflater = LayoutInflater.from(context);
        this.mlist = list;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder;
        switch (viewType){
            case TYPE:
                View view = inflater.inflate(R.layout.recycleview_image_item, parent,false);

                break;
            case TYPE1:
                View jctjRecycleView = inflater.inflate(R.layout.recycleview_jctj_item, parent, false);
                 viewHolder= new JCTJViewHolder(jctjRecycleView);
                return viewHolder;
            case TYPE2:
            case TYPE3:
            case TYPE4:
            case TYPE5:
            case TYPE6:
            case TYPE7:
            case TYPE8:


        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        Object o = mlist.get(position);
        if(o instanceof PanadaHomeBean.DataBean.BigImgBean){//轮播图
            return TYPE;
        }else if(o instanceof PanadaHomeBean.DataBean.AreaBean){//精彩推荐
            return TYPE1;
        }else if(o instanceof PanadaHomeBean.DataBean.PandaeyeBean){//熊猫观察
            return TYPE2;
        }else if(o instanceof PanadaHomeBean.DataBean.PandaliveBean){//熊猫直播
            return TYPE3;
        }else if(o instanceof PanadaHomeBean.DataBean.WallliveBean){//长城直播
            return TYPE4;
        }else if(o instanceof PanadaHomeBean.DataBean.ChinaliveBean){//直播中国
            return TYPE5;
        }else if(o instanceof PanadaHomeBean.DataBean.InteractiveBean){//特别策划
            return TYPE6;
        }else if(o instanceof PanadaHomeBean.DataBean.CctvBean){//CCTV
            return TYPE7;
        }else if(o instanceof PanadaHomeBean.DataBean.ListBeanXXX){//光影中国
            return TYPE8;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    //绑定加载数据
        int type = getItemViewType(position);
        Object o = mlist.get(position);
        switch (type){
            case TYPE:
                break;
            case TYPE1:
                PanadaHomeBean.DataBean.AreaBean areaBean = (PanadaHomeBean.DataBean.AreaBean) o;
                JCTJViewHolder jctjViewHolder = (JCTJViewHolder) holder;
                jctjViewHolder.titleText.setText(areaBean.getTitle());
                Glide.with(context).load(areaBean.getImage()).into(jctjViewHolder.titleImage);
                List<PanadaHomeBean.DataBean.AreaBean.ListscrollBean> listscroll = areaBean.getListscroll();
                 addJCTUMessage(listscroll,jctjViewHolder);

                break;
            case TYPE2:
                break;
            case TYPE3:
                break;
            case TYPE4:
                break;
            case TYPE5:
                break;
            case TYPE6:
                break;
            case TYPE7:
                break;
            case TYPE8:
                break;
        }
    }
    //精彩推荐动态添加横向的图片和标题
    public void addJCTUMessage(List<PanadaHomeBean.DataBean.AreaBean.ListscrollBean> jctjList,JCTJViewHolder jctjViewHolder){
        for(int i =0;i<jctjList.size();i++){
            PanadaHomeBean.DataBean.AreaBean.ListscrollBean listscrollBean = jctjList.get(i);
            //创建LinearLayout对象
            LinearLayout linearLayout = new LinearLayout(context);
            //创建LayoutParams对象
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(dp2px(140),dp2px(120));
            linearLayout.setLayoutParams(params);
            linearLayout.setPadding(10,0,0,0);
            //设置垂直方向
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            //创建图片对象
            ImageView imageView = new ImageView(context);
            //创建图片的宽和高
            ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dp2px(80));
            imageView.setLayoutParams(imageParams);
            imageView.setPadding(10,10,0,0);
            imageView.setTop(dp2px(25));
            //加载图片
            Glide.with(context).load(listscrollBean.getImage()).placeholder(R.drawable.panda_sign).into(imageView);

            //创建文字对象
            TextView textView = new TextView(context);
            ViewGroup.LayoutParams textParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dp2px(50));
            textView.setLayoutParams(textParams);
            textView.setTextSize(13);
            textView.setPadding(15,0,0,0);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setText(listscrollBean.getTitle());
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            jctjViewHolder.linearLayout.addView(linearLayout);
        }
    }

    public int dp2px(int dpValue){
        int value = (int) (context.getResources().getDisplayMetrics().density  * dpValue +0.5f);
        return value;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
