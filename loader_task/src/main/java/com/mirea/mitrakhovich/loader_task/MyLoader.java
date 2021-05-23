package com.example.looper_task;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {
    private String firstName;
    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null){
            firstName = args.getString(ARG_WORD);
        }
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        List<Character> characters = new ArrayList();
        for(char c:firstName.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(firstName.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        firstName = output.toString();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        // emulate long-running operation
        SystemClock.sleep(2000);
        return firstName;
    }
}