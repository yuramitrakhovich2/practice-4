package com.example.loadermanager;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

public class MyLoader extends AsyncTaskLoader<String> {
    private String firstName;
    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            firstName = args.getString(ARG_WORD);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        // emulate long-running operation
        SystemClock.sleep(5000);
        return firstName;
    }
}