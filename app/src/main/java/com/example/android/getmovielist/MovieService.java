package com.example.android.getmovielist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {

    @GET("v3/{uuid}")
    Call<ProductDto> listRepos(@Path("uuid") String parameterUuid);
}