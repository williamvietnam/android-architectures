package com.base.mvp.core.data.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHelperImplement implements ApiHelper {

    private final ApiHeader apiHeader;

    @Inject
    public ApiHelperImplement(ApiHeader apiHeader) {
        this.apiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return apiHeader;
    }
}
