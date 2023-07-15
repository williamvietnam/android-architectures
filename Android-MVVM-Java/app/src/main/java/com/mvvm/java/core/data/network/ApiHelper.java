package com.mvvm.java.core.data.network;

import com.mvvm.java.core.data.network.models.response.ModelResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface ApiHelper {
    Single<List<ModelResponse>> getUsers();

    Single<List<ModelResponse>> getUsers(int pageIndex);

    Single<ModelResponse> getUserDetail(String userId);
}