package cctv.cn.ipanda.activity;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.PandaLiveChinaAllGridItemAdapter;
import cctv.cn.ipanda.adapter.PandaLiveChinaGridItemAdapter;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.click_listener.MyClickListener;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabAllListBeanDb;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabListBeanDb;
import cctv.cn.ipanda.model.db.db_manager.DbManager;
import cctv.cn.ipanda.view.DragGridView;

/**
 * Created by 张志远 on 2017/4/12.
 */

public class ChinaLivePoPActivity extends BaseActivity implements MyClickListener {
    private DragGridView mListItemGrid;
    private GridView mAllListItemGrid;
    private TextView dismiss_text;
    private Button editBtn;

    private PandaLiveChinaGridItemAdapter pandaLiveChinaGridItemAdapter;
    private List<ChinaLiveTabAllListBeanDb> chinaLiveTabAllListBeanDbs;
    private PandaLiveChinaAllGridItemAdapter pandaLiveChinaAllGridItemAdapter;
    private List<ChinaLiveTabListBeanDb> tabListBeanDbs;
    private boolean deleteAble=true;
    private DbManager dbManager;
    private ImageView addImage;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_china_live_popup_view;
    }

    @Override
    protected void loadData() {
        tabListBeanDbs.clear();

        tabListBeanDbs.addAll(dbManager.selectChinaLiveTabListBeanDb());

        chinaLiveTabAllListBeanDbs.clear();

        chinaLiveTabAllListBeanDbs.addAll(dbManager.selectChinaLiveAllTabListBeanDb());

        pandaLiveChinaAllGridItemAdapter.notifyDataSetChanged();

        pandaLiveChinaGridItemAdapter.notifyDataSetChanged();
        addDataToGridAdapter();
    }

    @Override
    protected void initView() {
        addImage = (ImageView) findViewById(R.id.add_Image);
        dismiss_text = (TextView) findViewById(R.id.dismiss_text);

        mListItemGrid = (DragGridView)findViewById(R.id.mListItemGrid);

        mAllListItemGrid = (GridView)findViewById(R.id.mAllListItemGrid);

        editBtn = (Button) findViewById(R.id.edit_btn);
    }

    @Override
    protected void initData() {
        tabListBeanDbs=new ArrayList<>();

        pandaLiveChinaGridItemAdapter = new PandaLiveChinaGridItemAdapter(this,tabListBeanDbs);

        mListItemGrid.setAdapter(pandaLiveChinaGridItemAdapter);

        chinaLiveTabAllListBeanDbs = new ArrayList<>();

        pandaLiveChinaAllGridItemAdapter = new PandaLiveChinaAllGridItemAdapter(this,chinaLiveTabAllListBeanDbs);

        mAllListItemGrid.setAdapter(pandaLiveChinaAllGridItemAdapter);

        dbManager = new DbManager(this);
    }

    @Override
    protected void initListener() {
        dismiss_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              finish();
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
    private void addDataToGridAdapter() {


        chinaLiveTabAllListBeanDbs.clear();

        chinaLiveTabAllListBeanDbs.addAll(dbManager.selectChinaLiveAllTabListBeanDb());

        for (int i=chinaLiveTabAllListBeanDbs.size()-1;i>=0;i--){

            for(int j=0;j<tabListBeanDbs.size();j++){

                if (chinaLiveTabAllListBeanDbs.get(i).getTitle().equals(tabListBeanDbs.get(j).getTitle())){

                    chinaLiveTabAllListBeanDbs.remove(i);
                }
            }

        }
        pandaLiveChinaGridItemAdapter.notifyDataSetChanged();
        pandaLiveChinaAllGridItemAdapter.notifyDataSetChanged();
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

        addDataToGridAdapter();
    }
}
