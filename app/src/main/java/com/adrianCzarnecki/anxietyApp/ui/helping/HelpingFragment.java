package com.adrianCzarnecki.anxietyApp.ui.helping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.adrianCzarnecki.anxietyApp.R;
import com.adrianCzarnecki.anxietyApp.ui.secTitle.SecTitleFragment;

import static com.adrianCzarnecki.anxietyApp.MainActivity.resources;

public class HelpingFragment extends Fragment {

    private HelpingViewModel helpingViewModel;

    private SecTitleFragment secTitle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helpingViewModel =
                ViewModelProviders.of(this).get(HelpingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_helping, container, false);


        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentManager fm = getChildFragmentManager();

        secTitle = (SecTitleFragment) fm.findFragmentById(R.id.sec_title);
        secTitle.setText(resources.getString(R.string.helping_title));
        secTitle.setBackground(resources.getColor(R.color.colorHeaderHelping));

    }
}