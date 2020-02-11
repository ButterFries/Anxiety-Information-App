package com.adrianCzarnecki.anxietyApp.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.adrianCzarnecki.anxietyApp.R;

import com.adrianCzarnecki.anxietyApp.ui.buttons.TwoSideBySide.ButtonsFragment;
import com.adrianCzarnecki.anxietyApp.ui.buttons.ThreeSideBySideTwoLeft.ButtonsFragmentThree;
import com.adrianCzarnecki.anxietyApp.ui.title.TitleFragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.adrianCzarnecki.anxietyApp.MainActivity.resources;


public class HomeFragment extends Fragment {


    final String home_improving = "home/improving";
    final String home_helping = "home/helping";

    private TitleFragment title;
    private ButtonsFragmentThree button_top_obj;
    private ButtonsFragment button_mid_obj;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        title = new TitleFragment();
        title.setText(resources.getString(R.string.home_title));
        ft.add(R.id.home_container, title);


        button_top_obj = new ButtonsFragmentThree();

        Bundle bundle1 = new Bundle();
        bundle1.putString("img1", home_improving);
        bundle1.putString("img2", home_helping);
        bundle1.putInt("colorOnClick", 0x7F000000);
        button_top_obj.setArguments(bundle1);

        ft.add(R.id.home_container, button_top_obj);


        button_mid_obj = new ButtonsFragment();

        Bundle bundle2 = new Bundle();
        bundle2.putString("img1", home_helping);
        bundle2.putString("img2", home_improving);
        bundle2.putInt("colorOnClick", 0x7F000000);
        button_mid_obj.setArguments(bundle2);

        ft.add(R.id.home_container, button_mid_obj);
        ft.commit();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);


    }

}