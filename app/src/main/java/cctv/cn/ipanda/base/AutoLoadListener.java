package cctv.cn.ipanda.base;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import cctv.cn.ipanda.common.App;

/**
 * Created by lenovo on 2017/4/13.
 */

public class AutoLoadListener implements AbsListView.OnScrollListener {

    public interface AutoLoadCallBack {

        void execute();
    }

    private boolean isLoadMore;
    private int getLastVisiblePosition = 0, lastVisiblePositionY = 0;
    private AutoLoadCallBack mCallback;

    public AutoLoadListener(AutoLoadCallBack callback) {

        this.mCallback = callback;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && isLoadMore == true) {
            //滚动到底部
            /*if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                View v = (View) view.getChildAt(view.getChildCount() - 1);
                int[] location = new int[2];
                v.getLocationOnScreen(location);//获取在整个屏幕内的绝对坐标
                int y = location[1];

                if (view.getLastVisiblePosition() != getLastVisiblePosition && lastVisiblePositionY != y)//第一次拖至底部
                {
                    Toast.makeText(view.getContext(), "已经拖动至底部，再次拖动即可翻页", Toast.LENGTH_SHORT).show();
                    getLastVisiblePosition = view.getLastVisiblePosition();
                    lastVisiblePositionY = y;
                    return;
                } else if (view.getLastVisiblePosition() == getLastVisiblePosition && lastVisiblePositionY == y)//第二次拖至底部
                {
                    mCallback.execute();
                }
            }

            //未滚动到底部，第二次拖至底部都初始化
            getLastVisiblePosition = 0;
            lastVisiblePositionY = 0;*/
            Toast.makeText(App.context, "0...0", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

        if (i + i1 == i2) {

            Log.i("qqq", "qqqq");
            isLoadMore = true;
        }
    }
}
