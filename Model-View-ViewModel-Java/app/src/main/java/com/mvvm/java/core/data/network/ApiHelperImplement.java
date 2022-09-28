package com.mvvm.java.core.data.network;

import com.mvvm.java.core.data.network.models.response.ModelResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

@Singleton
public class ApiHelperImplement implements ApiHelper {

    @Inject
    public ApiHelperImplement() {
    }

    @Override
    public Single<List<ModelResponse>> getUsers() {
        return ApiClient.getInstance().getApiService().getUsers();
    }

    @Override
    public Single<List<ModelResponse>> getUsers(int pageIndex) {
        return ApiClient.getInstance().getApiService().getUsers(pageIndex);
    }

    @Override
    public Single<ModelResponse> getUserDetail(String userId) {
        return ApiClient.getInstance().getApiService().getUserDetail(userId);
    }
}