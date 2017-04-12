package cctv.cn.ipanda.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by lenovo on 2017/4/12.
 */

public class HeadGridView extends GridView {

    public HeadGridView(Context context) {
        super(context);
    }


    public HeadGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public HeadGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
