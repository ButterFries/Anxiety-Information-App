package com.adrianCzarnecki.anxietyApp.ui.improving;

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

public class ImprovingFragment extends Fragment {

    private ImprovingViewModel improvingViewModel;

    private SecTitleFragment secTitle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        improvingViewModel =
                ViewModelProviders.of(this).get(ImprovingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_improving, container, false);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentManager fm = getChildFragmentManager();

        secTitle = (SecTitleFragment) fm.findFragmentById(R.id.sec_title);
        secTitle.setText(resources.getString(R.string.improving_title));
        secTitle.setBackground(resources.getColor(R.color.colorHeaderImproving));


    }
}