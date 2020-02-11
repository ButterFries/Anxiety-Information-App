package com.adrianCzarnecki.anxietyApp.ui.secTitle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.adrianCzarnecki.anxietyApp.R;

public class SecTitleFragment extends Fragment {

    private SecTitleViewModel secTitleViewModel;
    private int background;

    private String text = "";

    private TextView textView;
    private LinearLayout ln;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        secTitleViewModel =
                ViewModelProviders.of(this).get(SecTitleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sec_title, container, false);
        textView = root.findViewById(R.id.text_sec_title);

        secTitleViewModel.setText(text);
        if (textView != null)
            textView.setText(text);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        secTitleViewModel.setText(text);
        ln = getView().findViewById(R.id.sec_title_banner);
        ln.setBackgroundColor(background);
    }

    public void setText(String text) {
        secTitleViewModel.setText(text);
        if (textView != null)
            textView.setText(text);

    }

    public void setBackground(int c) {
        secTitleViewModel.setBackground(c);
        if (ln != null)
            ln.setBackgroundColor(c);
    }

}