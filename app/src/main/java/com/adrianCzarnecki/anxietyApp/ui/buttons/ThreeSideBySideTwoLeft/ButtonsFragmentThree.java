package com.adrianCzarnecki.anxietyApp.ui.buttons.ThreeSideBySideTwoLeft;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.adrianCzarnecki.anxietyApp.R;
import com.adrianCzarnecki.anxietyApp.ui.buttons.ImageButtonMain;
import com.adrianCzarnecki.anxietyApp.ui.buttons.ImageButtonSquare;
import com.adrianCzarnecki.anxietyApp.ui.buttons.ImageButtonRectangle;

public class ButtonsFragmentThree extends Fragment {

    View v;

    private ImageButtonSquare ibsUp, ibsDown;
    private ImageButtonRectangle ibr;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        v = inflater.inflate(R.layout.fragment_image_button_three, parent, false);
        return v;
    }

    // The onActivityCreated method is called when Fragment is created.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("buttons3fragment","onactivitycreated");

        ibsUp = getView().findViewById(R.id.imageButtonThreeUp);
        ibsDown = getView().findViewById(R.id.imageButtonThreeDown);
        ibr = getView().findViewById(R.id.imageButtonThreeRight);

        ibsUp.setActivity(getActivity());
        ibsDown.setActivity(getActivity());
        ibr.setActivity(getActivity());

        try {
            ViewGroup.LayoutParams p = v.getLayoutParams();

            DisplayMetrics dm = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);

            p.width = dm.widthPixels;
            p.height = (int) (185 * dm.density);

            Bundle bundle = getArguments();

            if (bundle != null) {
                ibsUp.setImage(bundle.getString("img1"));
                setupImage(ibsUp);
                ibsDown.setImage(bundle.getString("img2"));
                setupImage(ibsDown);
                ibr.setImage(bundle.getString("img3"));
                setupImage(ibr);

                ibsUp.setPressedColor(bundle.getInt("colorOnClick"));
                ibsDown.setPressedColor(bundle.getInt("colorOnClick"));
                ibr.setPressedColor(bundle.getInt("colorOnClick"));
            }

            v.setLayoutParams(p);

        } catch (Exception e) {
            Log.d("Buttons", "2 GroupInfoFragment Height Exception: " + e.toString());
        }

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d("buttons3fragment","onviewcreated");
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    private void setupImage(ImageButtonMain ib) {

        switch (ib.getImage()) {
            case "home/planet":
                ib.setDest("helpingPressed");
                ib.setImageResource(R.drawable.planet);
                return;

            case "home/what":
                ib.setDest("improvingPressed");
                ib.setImageResource(R.drawable.what);
                return;

            case "home/awareness":
                ib.setDest("relaxPressed");
                ib.setImageResource(R.drawable.awareness);
                return;

            case "home/effects":
                ib.setDest("stressPressed");
                ib.setImageResource(R.drawable.effects);
                return;

            case "home/mental":
                ib.setDest("effectsPressed");
                ib.setImageResource(R.drawable.mental);
                return;
        }

    }
}
