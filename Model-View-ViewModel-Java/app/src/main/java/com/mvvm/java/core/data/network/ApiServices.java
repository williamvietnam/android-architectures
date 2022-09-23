package com.mvvm.java.core.data.network;

import com.mvvm.java.core.data.network.models.response.ModelResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {
    @GET(ApiEndpoint.GET_USERS)
    Single<List<ModelResponse>> getUsers();

    @GET(ApiEndpoint.GET_USERS)
    Single<List<ModelResponse>> getUsers(@Query("page") int pageIndex);

    @GET(ApiEndpoint.GET_USER_DETAIL)
    Single<ModelResponse> getUserDetail(@Path("userId") String userId);
}