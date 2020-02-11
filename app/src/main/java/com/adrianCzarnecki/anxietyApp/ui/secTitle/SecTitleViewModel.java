package com.adrianCzarnecki.anxietyApp.ui.secTitle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SecTitleViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Integer> mBackground;

    public SecTitleViewModel() {
        mText = new MutableLiveData<>();
        mBackground = new MutableLiveData<>();
    }

    public void setText(String text) {
        mText.setValue(text);
    }
    public void setBackground(int color) {
        mBackground.setValue(color);
    }


    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Integer> getBackground() {
        return mBackground;
    }
}