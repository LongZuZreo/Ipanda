package cctv.cn.ipanda.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by xingge on 2017/3/17.
 */

public class CircleImg extends ImageView{

    private Bitmap bitmap;
    public CircleImg(Context context) {
        super(context);
    }

    public CircleImg(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImg(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Bitmap bitmap = getBitmap();
        int width = 0;
        int height = 0;
        if(bitmap == null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
            bitmap = bitmapDrawable.getBitmap();
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }else {
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        }
        Bitmap newBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(newBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ffffff"));
        int radiu = 0;
        if(getMeasuredWidth() > getMeasuredHeight())
            radiu = getMeasuredHeight() / 2;
        else
            radiu = getMeasuredWidth() / 2;

        c.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,radiu,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        c.drawBitmap(bitmap,0,0,paint);

        canvas.drawBitmap(newBitmap,0,0,null);

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        invalidate();
    }

    public void setBitmapByFile(String bitmapPath){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(bitmapPath,options);
        int width = options.outWidth;
        int height = options.outHeight;

        int sampleSize = 1;
        int halfWidth = width/2;
        int halfHeight = height/2;
        while (true){
            if(halfWidth < getMeasuredWidth() || halfHeight < getMeasuredHeight()){
                break;
            }
            sampleSize = sampleSize * 2;
            halfWidth = halfWidth/2;
            halfHeight = halfHeight/2;
        }

        options.inSampleSize = sampleSize;
        options.inJustDecodeBounds = false;
        this.bitmap = BitmapFactory.decodeFile(bitmapPath,options);
        setImageDrawable(BitmapDrawable.createFromPath(bitmapPath));
        invalidate();

    }

}
