package cctv.cn.ipanda.adapter;

import android.content.Context;

import java.util.List;

import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;

/**
 * Created by 张志远 on 2017/4/12.
 */

public abstract class DragAdapter<T> extends MyCommonBaseAdapter<T>{

    public boolean isMove;

    public int movePosition;

    public DragAdapter(Context context, List<T> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    public void exchangePosition(int originalPosition,int nowPosition,boolean isMove){

        T t = datas.get(originalPosition);

        datas.remove(originalPosition);

        datas.add(nowPosition,t);

        movePosition=nowPosition;

        this.isMove=isMove;

        notifyDataSetChanged();
    }
}
