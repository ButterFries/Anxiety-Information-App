package com.adrianCzarnecki.anxietyApp.ui.helping;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelpingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is helping fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}