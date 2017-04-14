package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.recycleviewadapter_adapter.CctvGridViewAdapter;
import cctv.cn.ipanda.adapter.recycleviewadapter_adapter.ChinaLiveGridViewAdapter;
import cctv.cn.ipanda.adapter.recycleviewadapter_adapter.ListBeanListViewAdapter;
import cctv.cn.ipanda.adapter.recycleviewadapter_adapter.PanadaEyesListAdapter;
import cctv.cn.ipanda.adapter.recycleviewadapter_adapter.WallLiveGridViewAdapter;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaEyesBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.presenter.panada_home.HomePresentImp;
import cctv.cn.ipanda.viewholder.JCTJViewHolder;
import cctv.cn.ipanda.viewholder.PanadaCCTVViewHolder;
import cctv.cn.ipanda.viewholder.PanadaChinaLiveViewHolder;
import cctv.cn.ipanda.viewholder.PanadaEyesListViewHolder;
import cctv.cn.ipanda.viewholder.PanadaEyesViewHolder;
import cctv.cn.ipanda.adapter.recycleviewadapter_adapter.PanadaLiveGridViewAdapter;
import cctv.cn.ipanda.viewholder.PanadaInteractiveViewHolder;
import cctv.cn.ipanda.viewholder.PanadaListBeanViewHolder;
import cctv.cn.ipanda.viewholder.PanadaLiveViewHolder;
import cctv.cn.ipanda.viewholder.PanadaViewPagerViewHolder;
import cctv.cn.ipanda.viewholder.PanadaWallLiveViewHolder;

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
    public static final int TYPE9 = 9;
    private PanadaEyesViewHolder panadaEyesViewHolder;
    private PanadaLiveViewHolder panadaLiveViewHolder;
    private PanadaWallLiveViewHolder panadaWallLiveViewHolder;
    private PanadaChinaLiveViewHolder panadaChinaLiveViewHolder;
    private PanadaInteractiveViewHolder panadaInteractiveViewHolder;
    private PanadaCCTVViewHolder panadaCCTVViewHolder;
    private PanadaListBeanViewHolder panadaListBeanViewHolder;
    private PanadaEyesListViewHolder panadaEyesListViewHolder;

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

                break;
            case TYPE1:
                View jctjRecycleView = inflater.inflate(R.layout.recycleview_jctj_item, parent, false);
                 viewHolder= new JCTJViewHolder(jctjRecycleView);
                return viewHolder;
            case TYPE2:
                View panadaeyesRecycleView = inflater.inflate(R.layout.recycleview_panadaeyes_item, parent, false);
                panadaEyesViewHolder = new PanadaEyesViewHolder(panadaeyesRecycleView);
                return panadaEyesViewHolder;
            case TYPE3:
                View panadaEyesListRecycleView = inflater.inflate(R.layout.recycleview_panadaeyes_item_listview, parent, false);
                panadaEyesListViewHolder = new PanadaEyesListViewHolder(panadaEyesListRecycleView);
                return panadaEyesListViewHolder;

            case TYPE4:
                View panadaLiveRecycleView = inflater.inflate(R.layout.recycleview_panadalive_item, parent, false);
                panadaLiveViewHolder = new PanadaLiveViewHolder(panadaLiveRecycleView);
                return panadaLiveViewHolder;
            case TYPE5:
                View wallliveRecycle = inflater.inflate(R.layout.recycleview_walllive_item, parent, false);
                panadaWallLiveViewHolder = new PanadaWallLiveViewHolder(wallliveRecycle);
                return panadaWallLiveViewHolder;
            case TYPE6:
                View chinaliveRecycle = inflater.inflate(R.layout.recycleview_chinalive_item, parent, false);
                panadaChinaLiveViewHolder = new PanadaChinaLiveViewHolder(chinaliveRecycle);
                return panadaChinaLiveViewHolder;
            case TYPE7:
                View interactiveRecycleView = inflater.inflate(R.layout.recycleview_interactive_item, parent, false);
                panadaInteractiveViewHolder = new PanadaInteractiveViewHolder(interactiveRecycleView);
                return panadaInteractiveViewHolder;
            case TYPE8:
                View panadaCCTVRecycleView = inflater.inflate(R.layout.recycleview_cctv_item, parent, false);
                panadaCCTVViewHolder = new PanadaCCTVViewHolder(panadaCCTVRecycleView);
                return panadaCCTVViewHolder;
            case TYPE9:
                View panadalistbeanRecycleView = inflater.inflate(R.layout.recycleview_listbean_itme, parent, false);
                panadaListBeanViewHolder = new PanadaListBeanViewHolder(panadalistbeanRecycleView);
                return panadaListBeanViewHolder;


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
        }else if(o instanceof PanadaEyesBean){//熊猫观察的LISTVIEW
            return TYPE3;
        }else if(o instanceof PanadaHomeBean.DataBean.PandaliveBean){//熊猫直播
            return TYPE4;
        }else if(o instanceof PanadaHomeBean.DataBean.WallliveBean){//长城直播
            return TYPE5;
        }else if(o instanceof PanadaHomeBean.DataBean.ChinaliveBean){//直播中国
            return TYPE6;
        }else if(o instanceof PanadaHomeBean.DataBean.InteractiveBean){//特别策划
            return TYPE7;
        }else if(o instanceof CctvAgainBean){//CCTV
            return TYPE8;
        }else if(o instanceof PanadaChinaListBean){//光影中国
            return TYPE9;
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
                /*PanadaHomeBean.DataBean.BigImgBean bigImgBean = (PanadaHomeBean.DataBean.BigImgBean) o;*/

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
                PanadaHomeBean.DataBean.PandaeyeBean pandaeyeBean = (PanadaHomeBean.DataBean.PandaeyeBean) o;
                PanadaEyesViewHolder panadaEyesViewHolder = (PanadaEyesViewHolder) holder;
                panadaEyesViewHolder.panadaTitle.setText(pandaeyeBean.getTitle());
                Glide.with(context).load(pandaeyeBean.getPandaeyelogo()).into(panadaEyesViewHolder.panadaeyesTitleImage);
                panadaEyesViewHolder.panadaeyesTitleTitle1.setText(pandaeyeBean.getItems().get(0).getBrief());
                panadaEyesViewHolder.panadaeyesTitleMessage1.setText(pandaeyeBean.getItems().get(0).getTitle());
                panadaEyesViewHolder.panadaeyesTitleTitle2.setText(pandaeyeBean.getItems().get(1).getBrief());
                panadaEyesViewHolder.panadaeyesTitleMessage2.setText(pandaeyeBean.getItems().get(1).getTitle());

                break;
            case TYPE3:
                PanadaEyesBean panadaEyesBean = (PanadaEyesBean) o;
                panadaEyesListViewHolder = (PanadaEyesListViewHolder) holder;
                ((PanadaEyesListViewHolder) holder).panadaeyesListView.setAdapter(new PanadaEyesListAdapter(context,panadaEyesBean.getList()));
                break;
            case TYPE4:
                PanadaHomeBean.DataBean.PandaliveBean pandaliveBean = (PanadaHomeBean.DataBean.PandaliveBean) o;
                panadaLiveViewHolder = (PanadaLiveViewHolder) holder;
                panadaLiveViewHolder.panadaLiveTitle.setText(pandaliveBean.getTitle());
                PanadaLiveGridViewAdapter panadaLiveGridViewAdapter = new PanadaLiveGridViewAdapter(context,pandaliveBean.getList());
                panadaLiveViewHolder.panadaLiveGridView.setAdapter(panadaLiveGridViewAdapter);
                break;
            case TYPE5:
                PanadaHomeBean.DataBean.WallliveBean wallliveBean = (PanadaHomeBean.DataBean.WallliveBean) o;
                panadaWallLiveViewHolder = (PanadaWallLiveViewHolder) holder;
                ((PanadaWallLiveViewHolder) holder).panadaWallLiveTitle.setText(wallliveBean.getTitle());
                ((PanadaWallLiveViewHolder) holder).panadaWallLiveGridView.setAdapter(new WallLiveGridViewAdapter(context,wallliveBean.getList()));
                break;
            case TYPE6:
                PanadaHomeBean.DataBean.ChinaliveBean chinaliveBean = (PanadaHomeBean.DataBean.ChinaliveBean) o;
                panadaChinaLiveViewHolder = (PanadaChinaLiveViewHolder) holder;
                ((PanadaChinaLiveViewHolder) holder).panadaChinaLiveTitle.setText(chinaliveBean.getTitle());
                ((PanadaChinaLiveViewHolder) holder).panadaChinaLiveGridView.setAdapter(new ChinaLiveGridViewAdapter(context,chinaliveBean.getList()));
                break;
            case TYPE7:
                PanadaHomeBean.DataBean.InteractiveBean interactiveBean = (PanadaHomeBean.DataBean.InteractiveBean) o;
                panadaInteractiveViewHolder = (PanadaInteractiveViewHolder) holder;
                ((PanadaInteractiveViewHolder) holder).panadaInteractiveTitle.setText(interactiveBean.getTitle());
                Glide.with(context).load(interactiveBean.getInteractiveone().get(0).getImage()).into(((PanadaInteractiveViewHolder) holder).panadaInteractiveImage);
                ((PanadaInteractiveViewHolder) holder).panadaInteractiveMessage.setText(interactiveBean.getInteractiveone().get(0).getTitle());
                break;
            case TYPE8:
                panadaCCTVViewHolder = (PanadaCCTVViewHolder) holder;
                CctvAgainBean cctvAgainBean = (CctvAgainBean) o;
                ((PanadaCCTVViewHolder) holder).panadaCCTVGridView.setAdapter(new CctvGridViewAdapter(context,cctvAgainBean.getList()));
                break;
            case TYPE9:
                 PanadaChinaListBean panadaChinaListBean = (PanadaChinaListBean) o;
                panadaListBeanViewHolder = (PanadaListBeanViewHolder) holder;
                ((PanadaListBeanViewHolder) holder).panadaListBeanListView.setAdapter(new ListBeanListViewAdapter(context,panadaChinaListBean.getList()));
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
           // linearLayout.setPadding(10,0,0,0);
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
