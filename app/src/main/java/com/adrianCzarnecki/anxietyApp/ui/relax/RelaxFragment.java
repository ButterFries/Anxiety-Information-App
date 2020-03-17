package com.adrianCzarnecki.anxietyApp.ui.relax;

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
import com.adrianCzarnecki.anxietyApp.ui.secTitle.SecTitleFragment;
import com.adrianCzarnecki.anxietyApp.ui.stress.StressViewModel;

import static com.adrianCzarnecki.anxietyApp.MainActivity.resources;

public class RelaxFragment extends Fragment {

    private RelaxViewModel relaxViewModel;

    private SecTitleFragment secTitle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        relaxViewModel =
                ViewModelProviders.of(this).get(RelaxViewModel.class);
        View root = inflater.inflate(R.layout.fragment_relax, container, false);


        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentManager fm = getChildFragmentManager();

        secTitle = (SecTitleFragment) fm.findFragmentById(R.id.sec_title);
        secTitle.setText(resources.getString(R.string.relax_title));
        secTitle.setBackground(resources.getColor(R.color.colorHeaderRelax));

    }
}