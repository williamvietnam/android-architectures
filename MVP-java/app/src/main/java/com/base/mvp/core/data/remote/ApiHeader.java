package com.base.mvp.core.data.remote;

import com.base.mvp.core.di.ApiInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {

    private final ProtectedApiHeader protectedApiHeader;
    private final PublicApiHeader publicApiHeader;

    @Inject
    public ApiHeader(PublicApiHeader publicApiHeader, ProtectedApiHeader protectedApiHeader) {
        this.publicApiHeader = publicApiHeader;
        this.protectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return protectedApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return publicApiHeader;
    }

    public static final class PublicApiHeader {

        @Expose
        @SerializedName("api_key")
        private String mApiKey;

        @Inject
        public PublicApiHeader(@ApiInfo String apiKey) {
            mApiKey = apiKey;
        }

        public String getApiKey() {
            return mApiKey;
        }

        public void setApiKey(String apiKey) {
            mApiKey = apiKey;
        }
    }

    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("api_key")
        private String apiKey;

        @Expose
        @SerializedName("user_id")
        private Long userId;

        @Expose
        @SerializedName("access_token")
        private String accessToken;

        public ProtectedApiHeader(String apiKey, Long userId, String accessToken) {
            this.apiKey = apiKey;
            this.userId = userId;
            this.accessToken = accessToken;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long mUserId) {
            this.userId = mUserId;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }
}
