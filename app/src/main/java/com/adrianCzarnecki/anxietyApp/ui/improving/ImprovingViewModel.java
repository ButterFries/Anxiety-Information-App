package com.adrianCzarnecki.anxietyApp.ui.improving;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImprovingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ImprovingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is improving fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}