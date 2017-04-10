package cctv.cn.ipanda.adapter.banner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ASUS on 2017/4/10.
 */

public class MyBannerAdapter extends PagerAdapter{
    private List<ImageView> mlist;
    public MyBannerAdapter(List<ImageView> list){
        this.mlist = list;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mlist.get(position);
        mlist.add(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      //  super.destroyItem(container, position, object);
        mlist.remove(position);
    }
}
