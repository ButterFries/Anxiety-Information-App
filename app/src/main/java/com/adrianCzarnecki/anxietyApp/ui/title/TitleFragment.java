package com.adrianCzarnecki.anxietyApp.ui.title;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.adrianCzarnecki.anxietyApp.R;

public class TitleFragment extends Fragment {

    private TitleViewModel titleViewModel;
    private String text = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        titleViewModel =
                ViewModelProviders.of(this).get(TitleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_title, container, false);
        final TextView textView = root.findViewById(R.id.text_title);
        titleViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        titleViewModel.setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

}