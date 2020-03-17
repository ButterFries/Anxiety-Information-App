package com.adrianCzarnecki.anxietyApp.ui.stress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.adrianCzarnecki.anxietyApp.R;
import com.adrianCzarnecki.anxietyApp.ui.helping.HelpingViewModel;
import com.adrianCzarnecki.anxietyApp.ui.secTitle.SecTitleFragment;

import static com.adrianCzarnecki.anxietyApp.MainActivity.resources;

public class StressFragment extends Fragment {

    private StressViewModel stressViewModel;

    private SecTitleFragment secTitle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        stressViewModel =
                ViewModelProviders.of(this).get(StressViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stress, container, false);


        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentManager fm = getChildFragmentManager();

        secTitle = (SecTitleFragment) fm.findFragmentById(R.id.sec_title);
        secTitle.setText(resources.getString(R.string.stress_title));
        secTitle.setBackground(resources.getColor(R.color.colorHeaderStress));

    }
}


