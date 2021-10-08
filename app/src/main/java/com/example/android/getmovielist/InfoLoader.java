package com.example.android.getmovielist;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.util.ArrayList;

public class InfoLoader extends AsyncTaskLoader<ArrayList<ProductInfo>> {
    public static final String LOG_TAG = AsyncTaskLoader.class.getSimpleName();
    private final String mUrl;

    public InfoLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"This is onStartLoading() method");
        forceLoad();
    }

    @Nullable
    @Override
    public ArrayList<ProductInfo> loadInBackground() {
        Log.i(LOG_TAG,"This is loadInBackground() method");
        return QueryUtils.fetchProductInfoData(mUrl);
    }
}
