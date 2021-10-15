package com.example.android.getmovielist;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoLoader extends AsyncTaskLoader<List<ProductInfo>> {
    public static final String LOG_TAG = AsyncTaskLoader.class.getSimpleName();
    private final String uuid;

    public InfoLoader(@NonNull Context context, String url) {
        super(context);
        String reg = "[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}";
        Matcher m = Pattern.compile(reg).matcher(url);
        m.find();
        uuid = m.group();
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"This is onStartLoading() method");
        forceLoad();
    }

    @Nullable
    @Override
    public List<ProductInfo> loadInBackground() {
        Log.i(LOG_TAG,"This is loadInBackground() method");
        try{
            ProductDto productDto = MovieRepository.fetch(uuid);
            return productDto.productionCompanyList();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
