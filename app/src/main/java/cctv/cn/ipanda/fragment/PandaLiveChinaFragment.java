package cctv.cn.ipanda.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.androidkun.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.ChinaLivePoPActivity;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.adapter.PandaLiveChinaItemAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.LiveChinaContract;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabAllListBeanDb;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabListBeanDb;
import cctv.cn.ipanda.model.db.db_manager.DbManager;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaListEntity;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaTabEntity;
import cctv.cn.ipanda.presenter.panda_live_china.PreseterImpl;
import cctv.cn.ipanda.view.DragGridView;

/**
 * Created by 张志远 on 2017/4/7.
 */

public class PandaLiveChinaFragment extends BaseFragment implements LiveChinaContract.View,TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private LiveChinaContract.Presenter presenter;
    private PullToRefreshRecyclerView refreshRecyclerView;
    private List<IPandaLiveChinaListEntity.LiveBean> liveBeenList;
    private PandaLiveChinaItemAdapter pandaLiveChinaItemAdapter;
    private ImageView addImage;
    private boolean isFirstGetTab;
    private SharedPreferences.Editor editor;
    private DbManager dbManager;

    private List<ChinaLiveTabListBeanDb> tabListBeanDbs;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live_china;
    }

    @Override
    protected void loadData() {
        if (isFirstGetTab) {
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


        }
    }



    @Override
    protected void initData() {

        tabListBeanDbs=new ArrayList<>();

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
    }

    @Override
    protected void initView(View view) {

        tabLayout = (TabLayout) view.findViewById(R.id.mTab);

        refreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.mPullToRefreshRecyclerView);

        presenter = new PreseterImpl(this);

        addImage = (ImageView) view.findViewById(R.id.add_Image);


    }

    @Override
    protected void initListener() {

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ChinaLivePoPActivity.class);

                startActivityForResult(intent,100);
            }
        });


    }

    @Override
    protected void show() {
    }

    @Override
    protected void hide() {

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

        editor.putBoolean("isFirstGetTab", false);

        editor.commit();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==100){

            tabListBeanDbs.clear();

            tabListBeanDbs.addAll(dbManager.selectChinaLiveTabListBeanDb());

            tabLayout.removeAllTabs();

            for (int i=0;i<tabListBeanDbs.size();i++){

                ChinaLiveTabListBeanDb chinaLiveTabListBeanDb = tabListBeanDbs.get(i);

                tabLayout.addTab(tabLayout.newTab().setText(chinaLiveTabListBeanDb.getTitle()).setTag(chinaLiveTabListBeanDb.getUrl()));
            }


        }
    }
}
