package com.adrianCzarnecki.anxietyApp.ui.title;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TitleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TitleViewModel() {
        mText = new MutableLiveData<>();
    }

    public void setText(String text) {
        mText.setValue(text);
    }


    public LiveData<String> getText() {
        return mText;
    }
}