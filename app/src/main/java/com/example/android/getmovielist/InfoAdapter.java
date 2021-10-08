package com.example.android.getmovielist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<ProductInfo> {
    public InfoAdapter(Activity context, ArrayList<ProductInfo> productInfo) {
        super(context, 0, productInfo);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_detail, parent, false);
        }
        ProductInfo currentProductInfo = getItem(position);

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.company_logo);
        if(currentProductInfo.getLogoPath() != null){
        String url = "https://image.tmdb.org/t/p/w500" + currentProductInfo.getLogoPath();
        Glide.with(parent).load(url).into(imageView);
        }else{
            Glide.with(parent).load(R.drawable.no_data).into(imageView);
        }

        TextView companyName = listItemView.findViewById(R.id.company_name);
        companyName.setText(currentProductInfo.getCompanyName());

        TextView originCountry = listItemView.findViewById(R.id.origin_country);
        String OriginCountryName = currentProductInfo.getOriginCountry();
        if(OriginCountryName != null) {
            String countryWithFlag = CountryFlags.getCountryFlagByCountryCode(OriginCountryName);
            originCountry.setText(countryWithFlag + OriginCountryName);
        }else{
            originCountry.setText("WE ARE SORRY, THERE IS NO DATA");
        }

        return listItemView;
    }
}
