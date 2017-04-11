package cctv.cn.ipanda.model.db.db_manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabAllListBeanDb;
import cctv.cn.ipanda.model.db.db_dao.ChinaLiveTabListBeanDb;
import cctv.cn.ipanda.model.db.db_dao.DaoMaster;
import cctv.cn.ipanda.model.db.db_dao.DaoSession;

/**
 * Created by 张志远 on 2017/4/10.
 */

public class DbManager {

    private final DaoMaster daoMaster;

    public DbManager(Context context) {

        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(context,"panda.db");

        SQLiteDatabase writableDatabase = helper.getWritableDatabase();

        daoMaster = new DaoMaster(writableDatabase);
    }

    public <T> void insertData(T t){
        DaoSession daoSession = daoMaster.newSession();
        daoSession.insert(t);
    }

    public <T> void updateData(T t){
        DaoSession daoSession = daoMaster.newSession();

        daoSession.update(t);
    }
    public <T> void deleteData(T t){
        DaoSession daoSession=daoMaster.newSession();

        daoSession.delete(t);
    }

    public <T> void deleteAll(Class<T> entityClass){
        DaoSession daoSession=daoMaster.newSession();

        daoSession.deleteAll(entityClass);
    }

    public <T> void insertAll(List<T> list){

        for (int i=0;i<list.size();i++){
            DaoSession daoSession = daoMaster.newSession();

            daoSession.insert(list.get(i));
        }

    }
    public List<ChinaLiveTabListBeanDb> selectChinaLiveTabListBeanDb(){

        DaoSession daoSession = daoMaster.newSession();

        return daoSession.getChinaLiveTabListBeanDbDao().queryBuilder().build().list();
    }

    public List<ChinaLiveTabAllListBeanDb> selectChinaLiveAllTabListBeanDb(){

        DaoSession daoSession = daoMaster.newSession();

        return daoSession.getChinaLiveTabAllListBeanDbDao().queryBuilder().build().list();
    }
}
