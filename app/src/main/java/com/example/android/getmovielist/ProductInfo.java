package com.example.android.getmovielist;

import androidx.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
@AutoValue
public abstract class ProductInfo {
    @Nullable
    @SerializedName("logo_path")
    abstract String logoPath();
    @Nullable
    @SerializedName("name")
    abstract String companyName();
    @Nullable
    @SerializedName("origin_country")
    abstract String originCountry();

    public static ProductInfo create(String logoPath, String name, String originCountry) {
        return new AutoValue_ProductInfo(logoPath, name, originCountry);
    }
}
