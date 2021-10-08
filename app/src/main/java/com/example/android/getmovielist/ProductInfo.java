package com.example.android.getmovielist;

public class ProductInfo {
    private final String mLogoPath;
    private final String mCompanyName;
    private final String mOriginCountry;

    public ProductInfo(String logoPath, String companyName, String originCountry) {
        this.mLogoPath = logoPath;
        this.mCompanyName = companyName;
        this.mOriginCountry = originCountry;
    }
    public String getLogoPath(){
        return mLogoPath;
    }
    public String getCompanyName(){
        return mCompanyName;
    }
    public String getOriginCountry(){
        return mOriginCountry;
    }
}