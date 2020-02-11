package com.adrianCzarnecki.anxietyApp.ui.stress;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StressViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StressViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is stress fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}