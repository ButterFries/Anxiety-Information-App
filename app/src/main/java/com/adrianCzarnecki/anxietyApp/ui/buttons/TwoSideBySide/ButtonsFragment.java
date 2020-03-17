package com.adrianCzarnecki.anxietyApp.ui.buttons.TwoSideBySide;

import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adrianCzarnecki.anxietyApp.R;
import com.adrianCzarnecki.anxietyApp.ui.buttons.ImageButtonSquare;

public class ButtonsFragment extends Fragment {

    View v;

    private ImageButtonSquare ibsRight, ibsLeft;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        v = inflater.inflate(R.layout.fragment_image_button, parent, false);
        return v;
    }

    // The onActivityCreated method is called when Fragment is created.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ibsLeft = getView().findViewById(R.id.imageButtonLeft);
        ibsRight = getView().findViewById(R.id.imageButtonRight);

        ibsLeft.setActivity(getActivity());
        ibsRight.setActivity(getActivity());

        try {
            ViewGroup.LayoutParams p = v.getLayoutParams();

            DisplayMetrics dm = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);

            p.height = dm.widthPixels/2;
            p.width = dm.widthPixels;

            Bundle bundle = getArguments();

            if (bundle != null) {
                ibsLeft.setImage(bundle.getString("img1"));
                setupImage(ibsLeft);
                ibsRight.setImage(bundle.getString("img2"));
                setupImage(ibsRight);

                ibsLeft.setPressedColor(bundle.getInt("colorOnClick"));
                ibsRight.setPressedColor(bundle.getInt("colorOnClick"));

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

        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    private void setupImage(ImageButtonSquare ib) {

        switch (ib.getImage()) {
            case "home/planet":
                ib.setDest("helpingPressed");
                ib.setImageResource(R.drawable.what);
                return;

            case "home/what":
                ib.setDest("improvingPressed");
                ib.setImageResource(R.drawable.planet);
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
