package com.yxd.myprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * 创建时间：2020/7/14
 * 编写人：czy_yangxudong
 * 功能描述：自定义ProgressBar
 */
public class MyProgressBar extends View {

    //圆环的线条宽度
    private int STROKWITH=10;
    //显示圆角还是直角
    private int STROKECAP=1;
    //背景色
    private String BACKGROUND_COLOR="#999999";
    //前景色
    private String  FOREGROUND_COLOR="#666666";
    //绘制时间间隔
    private Long INTERVAL=10l;
    //字体大小
    private float TEXT_SIZE=10;
    //字体颜色
    private String TEXT_COLOR=FOREGROUND_COLOR;
    //标记是否显示文字
    private boolean IS_SHOW_TEXT=true;
    //需要显示的文字
    private String TEXT="0%";
    //进度0-100
    private float PROGRESS=0.f;


    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //创建对象
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyProgressBar);
        //获取用户设置的属性
        STROKWITH=Math.round(ta.getDimension(R.styleable.MyProgressBar_STROKWITH,10));;
        TEXT_SIZE=ta.getDimension(R.styleable.MyProgressBar_TEXT_SIZE,10);
        IS_SHOW_TEXT=ta.getBoolean(R.styleable.MyProgressBar_IS_SHOW_TEXT,true);
        STROKECAP=ta.getInt(R.styleable.MyProgressBar_Stroke_Cap,STROKECAP);
        if (ta.getString(R.styleable.MyProgressBar_BACKGROUND_COLOR)!=null){
            BACKGROUND_COLOR=ta.getString(R.styleable.MyProgressBar_BACKGROUND_COLOR);
        }
        if (ta.getString(R.styleable.MyProgressBar_FOREGROUND_COLOR)!=null){
            FOREGROUND_COLOR=ta.getString(R.styleable.MyProgressBar_FOREGROUND_COLOR);
        }
        if (ta.getString(R.styleable.MyProgressBar_INTERVAL)!=null){
            INTERVAL=Long.parseLong(ta.getString(R.styleable.MyProgressBar_INTERVAL));
        }
        if (ta.getString(R.styleable.MyProgressBar_TEXT_COLOR)!=null){
            TEXT_COLOR=ta.getString(R.styleable.MyProgressBar_TEXT_COLOR);
        }
        //用完要关闭回收资源，必须的强制性的
        ta.recycle();

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        //setProgress(80);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("test","onDraw="+PROGRESS);

        //控件的宽度
        int pbWith=getWidth();
        //半径  外径
        int radiusOuter=pbWith/2;
        //半径 内径
        int radiusInside=radiusOuter-STROKWITH/2;

        /**
         *画背景圆
         */
        Paint paint=new Paint();
        //画笔颜色
        paint.setColor(Color.parseColor(BACKGROUND_COLOR));
        //画笔宽度
        paint.setStrokeWidth(STROKWITH);
        //画线
        paint.setStyle(Paint.Style.STROKE);
        //抗锯齿
        paint.setAntiAlias(true);
        //画笔是否有圆角
        if (STROKECAP==0){
            paint.setStrokeCap(Paint.Cap.BUTT);
        }else if(STROKECAP==1){
            paint.setStrokeCap(Paint.Cap.ROUND);
        }else if(STROKECAP==2){
            paint.setStrokeCap(Paint.Cap.SQUARE);
        }
        //画圆
        canvas.drawCircle(radiusOuter,radiusOuter,radiusInside,paint);

        /**
         *画文字
         */
        if (IS_SHOW_TEXT){
            paint.setColor(Color.parseColor(TEXT_COLOR));
            //文字大小
            paint.setTextSize(TEXT_SIZE);
            paint.setStrokeWidth(0);
            //文字的宽度
            float textWith=paint.measureText(TEXT);
            //2. 计算文字所在矩形，可以得到宽高
            Rect rect = new Rect();
            paint.getTextBounds(TEXT, 0, TEXT.length(), rect);
            //文字的高度
            int textheight = rect.height();
            //int w = rect.width();
            // Log.i("test", "w=" +w+"  h="+h);
            canvas.drawText(TEXT,pbWith/2-textWith/2,pbWith/2+textheight/2,paint);
            Log.i("test","文字打印了="+TEXT);
        }

        /**
         *画弧形圈
         */
        RectF rectF=new RectF(radiusOuter-radiusInside,radiusOuter-radiusInside,radiusOuter+radiusInside,radiusOuter+radiusInside);
        paint.setStrokeWidth(STROKWITH);
        paint.setColor(Color.parseColor(FOREGROUND_COLOR));
        //画笔 圆角
        if (STROKECAP==0){
            paint.setStrokeCap(Paint.Cap.BUTT);
        }else if(STROKECAP==1){
            paint.setStrokeCap(Paint.Cap.ROUND);
        }else if(STROKECAP==2){
            paint.setStrokeCap(Paint.Cap.SQUARE);
        }
        //画弧
        canvas.drawArc(rectF,0,360*PROGRESS/100,false,paint);
        Log.i("test","画弧="+PROGRESS);
    }


    private int mProgress=0;
    //设置进度 0-100
    public void setProgress(final int progress){

        if(progress>100){
            mProgress=100;
        }else if(progress<0){
            mProgress=0;
        }else{
            mProgress=progress;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= mProgress*2; i++) {
                    PROGRESS=i/2.f;
                    TEXT=i/2+"%";
                    Log.i("test", "PROGRESS="+PROGRESS);
                    postInvalidate();
                    try {
                        Thread.sleep(INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }




    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i("test","绘制完毕");
    }
}
