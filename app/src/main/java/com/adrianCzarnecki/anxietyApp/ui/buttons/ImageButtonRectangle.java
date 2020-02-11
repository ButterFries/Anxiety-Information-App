package com.adrianCzarnecki.anxietyApp.ui.buttons;

import android.content.Context;
import android.util.AttributeSet;

public class ImageButtonRectangle extends ImageButtonMain {

    public ImageButtonRectangle(Context context) {
        super(context);

    }
    public ImageButtonRectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageButtonRectangle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.getSize(heightMeasureSpec)+50;
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, height);
    }




}
