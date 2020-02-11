package com.adrianCzarnecki.anxietyApp.ui.relax;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.adrianCzarnecki.anxietyApp.R;

public class RelaxFragment extends Fragment {

    private RelaxViewModel relaxViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        relaxViewModel =
                ViewModelProviders.of(this).get(RelaxViewModel.class);
        View root = inflater.inflate(R.layout.fragment_relax, container, false);
        final TextView textView = root.findViewById(R.id.text_relax);
        relaxViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}