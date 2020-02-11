package com.adrianCzarnecki.anxietyApp.ui.buttons;

import android.content.Context;
import android.util.AttributeSet;

public class ImageButtonSquare extends ImageButtonMain {

    public ImageButtonSquare(Context context) {
        super(context);

    }
    public ImageButtonSquare(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageButtonSquare(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = width < height ? height : width;
        setMeasuredDimension(size, size);
    }




}
