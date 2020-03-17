package com.adrianCzarnecki.anxietyApp.ui.buttons;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.adrianCzarnecki.anxietyApp.R;

public class ImageButtonMain extends ImageButton {

    protected int pressedColor;
    protected boolean pressed = false;
    protected boolean eventFlag = false;
    protected String img = "";
    protected String dest = "";

    private Activity act = null;

    public ImageButtonMain(Context context) {
        super(context);
        setupClickListener();

    }
    public ImageButtonMain(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupClickListener();
    }

    public ImageButtonMain(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupClickListener();
    }

    public void setActivity(Activity a) {
        act = a;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {}

    public void setImage(String img) {
        this.img = img;
    }
    public String getImage() {
        return img;
    }


    public void setPressedColor(int color) {
        pressedColor = color;
    }
    public int getPressedColor() {
        return pressedColor;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
    public String getDest() {
        return dest;
    }

    private void setupClickListener() {

        this.setOnTouchListener(new OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("Pressed", "Button");
                    setColorFilter(getPressedColor(), PorterDuff.Mode.DARKEN);
                    pressed = !pressed;
                    return true;
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("Released", "Button");
                    clearColorFilter();
                    pressed = !pressed;
                    eventFlag = true;
                    if (act != null)
                        changeActivity(act);
                }
                return false;
            }
        });
    }

    private void changeActivity(Activity a) {
        try {
            NavController navController = Navigation.findNavController(a, R.id.nav_host_fragment);

            switch (dest) {
                case "helpingPressed":
                    navController.navigate(R.id.nav_helping);
                    return;

                case "improvingPressed":
                    navController.navigate(R.id.nav_improving);
                    return;

                case "relaxPressed":
                    navController.navigate(R.id.nav_relax);
                    return;

                case "stressPressed":
                    navController.navigate(R.id.nav_stress);
                    return;

                case "effectsPressed":
                    navController.navigate(R.id.nav_effects);
                    return;
            }


            if (dest.equals("improvingPressed")) {
                Log.d("pressed", "improvingPressed :D");
                // Loads a selected item from the toolbar
                navController.navigate(R.id.nav_improving);
            } else if (dest.equals("helpingPressed")) {
                // Loads a selected item from the toolbar
                navController.navigate(R.id.nav_helping);
            }
        } catch (Exception e) {
            Log.d("Pressed", "changeActivity exception: " + e.toString());
        }
    }


}
