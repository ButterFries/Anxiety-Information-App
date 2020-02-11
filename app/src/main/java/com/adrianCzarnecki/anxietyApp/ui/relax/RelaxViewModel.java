package com.adrianCzarnecki.anxietyApp.ui.relax;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RelaxViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RelaxViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is relax fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}