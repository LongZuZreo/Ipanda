package cctv.cn.ipanda.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.PandaLiveChinaAllGridItemAdapter;
import cctv.cn.ipanda.adapter.PandaLiveChinaGridItemAdapter;
import cctv.cn.ipanda.adapter.PandaLiveChinaItemAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.click_listener.MyClickListener;
import cctv.cn.ipanda.common.Params;
import cctv.cn.ipanda.contract.LiveChinaContract;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabAllListBeanDb;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabListBeanDb;
import cctv.cn.ipanda.model.db.db_manager.DbManager;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaListEntity;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaTabEntity;
import cctv.cn.ipanda.presenter.panda_live_china.PreseterImpl;

/**
 * Created by 张志远 on 2017/4/7.
 */

public class PandaLiveChinaFragment extends BaseFragment implements LiveChinaContract.View,TabLayout.OnTabSelectedListener,MyClickListener {

    private TabLayout tabLayout;
    private LiveChinaContract.Presenter presenter;
    private PullToRefreshRecyclerView refreshRecyclerView;
    private List<IPandaLiveChinaListEntity.LiveBean> liveBeenList;
    private PandaLiveChinaItemAdapter pandaLiveChinaItemAdapter;
    private ImageView addImage;
    private TextView dismiss_text;
    private View popView;
    private PopupWindow popupWindow;
    private boolean isFirstGetTab;
    private SharedPreferences.Editor editor;
    private DbManager dbManager;
    private GridView mListItemGrid;
    private GridView mAllListItemGrid;
    private List<ChinaLiveTabListBeanDb> tabListBeanDbs;
    private PandaLiveChinaGridItemAdapter pandaLiveChinaGridItemAdapter;
    private List<ChinaLiveTabAllListBeanDb> chinaLiveTabAllListBeanDbs;
    private PandaLiveChinaAllGridItemAdapter pandaLiveChinaAllGridItemAdapter;
    private Button editBtn;
    private boolean deleteAble=true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live_china;
    }

    @Override
    protected void loadData() {
        if (isFirstGetTab) {

            editor.putBoolean("isFirstGetTab", false);

            editor.commit();
            presenter.getAllTab();
        } else {
            tabListBeanDbs.clear();

            tabListBeanDbs.addAll(dbManager.selectChinaLiveTabListBeanDb());

            for (int i = 0; i < tabListBeanDbs.size(); i++) {

                ChinaLiveTabListBeanDb chinaLiveTabListBeanDb = tabListBeanDbs.get(i);

                tabLayout.addTab(tabLayout.newTab().setText(chinaLiveTabListBeanDb.getTitle()).setTag(chinaLiveTabListBeanDb.getUrl()));
            }

            TabLayout.Tab firstTab = tabLayout.getTabAt(0);

            presenter.getVideoList((String) firstTab.getTag());

            tabLayout.addOnTabSelectedListener(this);

            addDataToGridAdapter();
        }
    }

    private void addDataToGridAdapter() {
        pandaLiveChinaGridItemAdapter.notifyDataSetChanged();

        chinaLiveTabAllListBeanDbs.clear();

        chinaLiveTabAllListBeanDbs.addAll(dbManager.selectChinaLiveAllTabListBeanDb());

        for (int i=chinaLiveTabAllListBeanDbs.size()-1;i>=0;i--){

            for(int j=0;j<tabListBeanDbs.size();j++){

                if (chinaLiveTabAllListBeanDbs.get(i).getTitle().equals(tabListBeanDbs.get(j).getTitle())){

                    chinaLiveTabAllListBeanDbs.remove(i);
                }
            }

        }

        pandaLiveChinaAllGridItemAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0000FF"));

        liveBeenList = new ArrayList<>();

        pandaLiveChinaItemAdapter = new PandaLiveChinaItemAdapter(getActivity(), liveBeenList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        refreshRecyclerView.setLayoutManager(layoutManager);

        refreshRecyclerView.setAdapter(pandaLiveChinaItemAdapter);

        dbManager = new DbManager(getActivity());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("isFirstGetTab", Context.MODE_PRIVATE);

        isFirstGetTab = sharedPreferences.getBoolean("isFirstGetTab", true);

        editor = sharedPreferences.edit();

        tabListBeanDbs=new ArrayList<>();

        pandaLiveChinaGridItemAdapter = new PandaLiveChinaGridItemAdapter(getActivity(),tabListBeanDbs);

        mListItemGrid.setAdapter(pandaLiveChinaGridItemAdapter);

        chinaLiveTabAllListBeanDbs = new ArrayList<>();

        pandaLiveChinaAllGridItemAdapter = new PandaLiveChinaAllGridItemAdapter(getActivity(),chinaLiveTabAllListBeanDbs);

        mAllListItemGrid.setAdapter(pandaLiveChinaAllGridItemAdapter);

        TranslateAnimation translateAnimation=new TranslateAnimation(getScreenWidth(getActivity()),0,0,0);

        translateAnimation.setDuration(1000);

        popupWindow.setAnimationStyle(R.style.PopupAnimation);
    }

    @Override
    protected void initView(View view) {

        tabLayout = (TabLayout) view.findViewById(R.id.mTab);

        refreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.mPullToRefreshRecyclerView);

        presenter = new PreseterImpl(this);

        addImage = (ImageView) view.findViewById(R.id.add_Image);

        popView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_panda_china_live_popup_view, null);

        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        dismiss_text = (TextView) popView.findViewById(R.id.dismiss_text);

        mListItemGrid = (GridView) popView.findViewById(R.id.mListItemGrid);

        mAllListItemGrid = (GridView)popView.findViewById(R.id.mAllListItemGrid);

        editBtn = (Button) popView.findViewById(R.id.edit_btn);
    }

    @Override
    protected void initListener() {

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);

                popupWindow.setBackgroundDrawable(new BitmapDrawable());

                popupWindow.setOutsideTouchable(true);

                popupWindow.isShowing();
            }
        });

        dismiss_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow.dismiss();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pandaLiveChinaGridItemAdapter.setDeleteAble(deleteAble);

                pandaLiveChinaGridItemAdapter.notifyDataSetChanged();

                if (deleteAble){
                    editBtn.setText("完成");
                }else{
                    editBtn.setText("编辑");
                }

                deleteAble=!deleteAble;

            }
        });

        pandaLiveChinaGridItemAdapter.setClickListener(this);
        pandaLiveChinaAllGridItemAdapter.setClickListener(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismiss() {


    }

    @Override
    public void loadError() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {


    }

    @Override
    public void toPersonCenter() {

    }

    @Override
    public void toVideoPlay() {

    }

    @Override
    public void changeTitleBar() {

    }

    @Override
    public void toTabPopupWindow() {

    }

    @Override
    public void toOtherTab() {

    }

    @Override
    public void loadTab(IPandaLiveChinaTabEntity iPandaLiveChinaTabEntity) {

        List<IPandaLiveChinaTabEntity.TablistBean> tablist = iPandaLiveChinaTabEntity.getTablist();

        for (int i = 0; i < tablist.size(); i++) {

            IPandaLiveChinaTabEntity.TablistBean tablistBean = tablist.get(i);

            String title = tablistBean.getTitle();

            tabLayout.addTab(tabLayout.newTab().setText(title).setTag(tablist.get(i).getUrl()));
        }
        presenter.getVideoList(tablist.get(0).getUrl());

        List<IPandaLiveChinaTabEntity.AlllistBean> allTabList = iPandaLiveChinaTabEntity.getAlllist();

        List<ChinaLiveTabAllListBeanDb> allTabListDb = new ArrayList<>();
        for (int i = 0; i < allTabList.size(); i++) {

            IPandaLiveChinaTabEntity.AlllistBean alllistBean = allTabList.get(i);

            ChinaLiveTabAllListBeanDb listBeanDb = new ChinaLiveTabAllListBeanDb(null, alllistBean.getTitle(), alllistBean.getUrl(), alllistBean.getType(), alllistBean.getOrder());

            allTabListDb.add(listBeanDb);
        }

        List<IPandaLiveChinaTabEntity.TablistBean> tabList = iPandaLiveChinaTabEntity.getTablist();

        List<ChinaLiveTabListBeanDb> tabListDb = new ArrayList<>();

        for (int i = 0; i < tabList.size(); i++) {

            IPandaLiveChinaTabEntity.TablistBean tablistBean = tabList.get(i);

            ChinaLiveTabListBeanDb chinaLiveTabAllListBeanDb = new ChinaLiveTabListBeanDb(null, tablistBean.getTitle(), tablistBean.getUrl(), tablistBean.getType(), tablistBean.getOrder());

            tabListDb.add(chinaLiveTabAllListBeanDb);
        }

        dbManager.insertAll(allTabListDb);

        dbManager.insertAll(tabListDb);

        tabListBeanDbs.clear();

        tabListBeanDbs.addAll(dbManager.selectChinaLiveTabListBeanDb());

        pandaLiveChinaItemAdapter.notifyDataSetChanged();

        tabLayout.addOnTabSelectedListener(this);

        addDataToGridAdapter();
    }

    @Override
    public void loadList(IPandaLiveChinaListEntity iPandaLiveChinaListEntity) {


        liveBeenList.clear();

        liveBeenList.addAll(iPandaLiveChinaListEntity.getLive());

        pandaLiveChinaItemAdapter.notifyDataSetChanged();

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        presenter.getVideoList((String) tab.getTag());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public int getScreenWidth(Activity activity){

        DisplayMetrics dm = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int screenWidth = dm.widthPixels;
        return screenWidth;
    }

    @Override
    public void onClick(View view) {

        String adapterName= (String) view.getTag();

        if (adapterName.equals("Tab")){

            ChinaLiveTabListBeanDb chinaLiveTabListBeanDb= (ChinaLiveTabListBeanDb) view.getTag(R.id.mText);

            chinaLiveTabListBeanDb.setId(null);

            tabListBeanDbs.remove(chinaLiveTabListBeanDb);

            dbManager.deleteAll(ChinaLiveTabListBeanDb.class);

            dbManager.insertAll(tabListBeanDbs);

            ChinaLiveTabAllListBeanDb chinaLiveTabAllListBeanDb=new ChinaLiveTabAllListBeanDb(null,chinaLiveTabListBeanDb.getTitle(),chinaLiveTabListBeanDb.getUrl(),chinaLiveTabListBeanDb.getType(),chinaLiveTabListBeanDb.getOrder());

            dbManager.insertData(chinaLiveTabAllListBeanDb);
        }else{

            ChinaLiveTabAllListBeanDb chinaLiveTabAllListBeanDb=(ChinaLiveTabAllListBeanDb) view.getTag(R.id.mText);

            dbManager.deleteData(chinaLiveTabAllListBeanDb);

            ChinaLiveTabListBeanDb chinaLiveTabListBeanDb=new ChinaLiveTabListBeanDb(null,chinaLiveTabAllListBeanDb.getTitle(),chinaLiveTabAllListBeanDb.getUrl(),chinaLiveTabAllListBeanDb.getType(),chinaLiveTabAllListBeanDb.getOrder());

            dbManager.insertData(chinaLiveTabListBeanDb);
        }
        tabListBeanDbs.clear();

        tabListBeanDbs.addAll(dbManager.selectChinaLiveTabListBeanDb());

        chinaLiveTabAllListBeanDbs.clear();

        chinaLiveTabAllListBeanDbs.addAll(dbManager.selectChinaLiveAllTabListBeanDb());

        pandaLiveChinaAllGridItemAdapter.notifyDataSetChanged();

        pandaLiveChinaGridItemAdapter.notifyDataSetChanged();

    }
}
