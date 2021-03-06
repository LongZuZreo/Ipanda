package cctv.cn.ipanda.view;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.DragAdapter;

import static io.vov.vitamio.utils.Log.TAG;

/**
 * Created by 张志远 on 2017/4/11.
 */

public class DragGridView extends GridView implements AdapterView.OnItemLongClickListener{


    public static final int MODE_NORMAL=101;

    public static final int  MODE_DRAG=5;

    private int mode=MODE_NORMAL;

    private WindowManager windowManager;
    private View view;
    private int position;
    private int tempPosition;
    private float mX;
    private float mY;
    private float mWindowX;
    private float mWindowY;
    private View dragView;
    private WindowManager.LayoutParams layoutParams;
    private Animation.AnimationListener animationListener=new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

            ListAdapter adapter = getAdapter();

            if (adapter!=null && adapter instanceof DragAdapter){

                ((DragAdapter)adapter).exchangePosition(position,tempPosition,true);

            }
           position=tempPosition;

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    public DragGridView(Context context) {
        super(context);

    }

    public DragGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        setOnItemLongClickListener(this);
    }

    public DragGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mWindowX=ev.getRawX();

                mWindowY=ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode==MODE_DRAG){
                    updateWindow(ev);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mode==MODE_DRAG){
                    closeWindow(ev.getX(),ev.getY());
                }
                break;
        }

        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        if (mode==MODE_DRAG){
            return false;
        }
        this.view= view;

        this.position=position;

        this.tempPosition=position;

        mX=mWindowX-view.getLeft()-this.getLeft();

        mY=mWindowY-view.getTop()-this.getTop();

        initWindow();

        return true;
    }

    private void initWindow(){

        if (dragView==null){

            dragView= LayoutInflater.from(getContext()).inflate(R.layout.china_live_grid_item,null);

            TextView mText= (TextView) dragView.findViewById(R.id.mText);

            mText.setText(((TextView)view.findViewById(R.id.mText)).getText());
        }
        if (layoutParams==null){

            layoutParams=new WindowManager.LayoutParams();

            layoutParams.type=WindowManager.LayoutParams.TYPE_PHONE;

            layoutParams.format= PixelFormat.RGBA_8888;

            layoutParams.gravity= Gravity.TOP | Gravity.START;

            layoutParams.flags=WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL|
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

            layoutParams.width=view.getWidth();

            layoutParams.height=view.getHeight();

            layoutParams.x=view.getLeft()+this.getLeft();

            layoutParams.y=view.getTop()+this.getTop();


        }
        windowManager.addView(dragView,layoutParams);

        view.setVisibility(INVISIBLE);

        mode=MODE_DRAG;
    }
    private void updateWindow(MotionEvent ev){

        if (mode==MODE_DRAG){

            float x=ev.getRawX()-mX;

            float y=ev.getRawY()-mY;

            if (layoutParams!=null) {

                layoutParams.x=(int)x;

                layoutParams.y=(int)y;

                windowManager.updateViewLayout(dragView, layoutParams);
            }
        }
        float mx=ev.getX();

        float my=ev.getY();

        int dropPosition= pointToPosition((int)mx,(int)my);
        Log.i(TAG, "dropPosition : " + dropPosition + " , tempPosition : " + tempPosition);
        if (dropPosition == tempPosition || dropPosition == GridView.INVALID_POSITION){
            return;
        }
        itemMove(dropPosition);
    }

    private void itemMove(int dropPosition){

        TranslateAnimation translateAnimation;

        if (dropPosition<tempPosition){

            for (int i=dropPosition;i<tempPosition;i++){

                View view=getChildAt(i);

                View nextView=getChildAt(i+1);

                float xValue=(nextView.getLeft()-view.getLeft())*1f/view.getWidth();

                float yValue=(nextView.getTop()-view.getTop())*1f/view.getHeight();

                translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,xValue, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, yValue);

                translateAnimation.setInterpolator(new LinearInterpolator());

                translateAnimation.setFillAfter(true);

                translateAnimation.setDuration(300);

                if (i==tempPosition-1){

                    translateAnimation.setAnimationListener(animationListener);
                }
                view.startAnimation(translateAnimation);
            }

        }else{

            for (int i=tempPosition+1;i<=dropPosition;i++){

                View view=getChildAt(i);

                View prevView=getChildAt(i-1);

                float xValue=(prevView.getLeft()-view.getLeft())*1f/view.getWidth();

                float yValue=(prevView.getTop()-view.getTop())*1f/view.getHeight();

                translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, xValue, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, yValue);

                translateAnimation.setInterpolator(new LinearInterpolator());

                translateAnimation.setFillAfter(true);

                translateAnimation.setDuration(300);

                if (i == dropPosition){

                    translateAnimation.setAnimationListener(animationListener);

                }

                view.startAnimation(translateAnimation);
            }
        }
        tempPosition=dropPosition;
    }

    private void closeWindow(float x,float y){

        if (dragView !=null){
            windowManager.removeView(dragView);

            dragView=null;

            layoutParams=null;

        }
        itemDrop();
        mode=MODE_NORMAL;
    }

    private void itemDrop(){
        if (tempPosition==position || tempPosition==GridView.INVALID_POSITION){

            getChildAt(position).setVisibility(VISIBLE);

        }else{

            ListAdapter adapter = getAdapter();

            if (adapter!=null && adapter instanceof DragAdapter){

                ((DragAdapter)adapter).exchangePosition(position,tempPosition,false);
            }

        }
    }


}
