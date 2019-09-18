package com.xugege.xucustomattributes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;


/**
 * @Author: KaixuGege
 * Time:           2019/9/18
 * ProjectName:    XuCustomAttributes
 * ClassName:
 * Info:
 */
public class MyView extends View implements IView {

    private Paint mPaint;

    private Context mContext;


    public MyView(Context context) {
        this(context,null);
    }


    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init(attrs);
    }



    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        init(attrs);
    }



    private void init(AttributeSet attrs) {
        mPaint = new TextPaint();
        TypedArray ta = mContext.obtainStyledAttributes(attrs,R.styleable.myview_test);
        int textColor  = ta.getColor(R.styleable.myview_test_MyTextColor,0xffffffff);
        int textSize  = (int) ta.getDimension(R.styleable.myview_test_MyTextSize,36);
        String text  = (String) ta.getText(R.styleable.myview_test_MyText );

        mPaint.setColor(textColor);

        mPaint.setTextSize(textSize);
        ta.recycle();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(10,10,99,99),mPaint);
    }
}
