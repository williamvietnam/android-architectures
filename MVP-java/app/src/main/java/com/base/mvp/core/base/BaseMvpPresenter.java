package com.base.mvp.core.base;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.error.ANError;
import com.base.mvp.R;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.data.remote.models.ApiError;
import com.base.mvp.core.utilities.AppConstants;
import com.base.mvp.core.utilities.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import timber.log.Timber;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public abstract class BaseMvpPresenter<V extends BaseContractView> implements BaseContractPresenter<V> {

    private static final String TAG = "BaseMvpPresenter";
    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable;

    private V view;

    public BaseMvpPresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
//        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.compositeDisposable.dispose();
        view = null;
    }

    @Override
    public DataManager getDataManager() {
        return this.dataManager;
    }

    @Override
    public SchedulerProvider getSchedulerProvider() {
        return this.schedulerProvider;
    }

    @Override
    public CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Override
    public void onCreateScreen() {
        // handle at child
    }

    @Override
    public void onDestroyScreen() {
        // handle at child
    }


    @Override
    public void handleApiError(ANError error) {

        if (error == null || error.getErrorBody() == null) {
            getView().onError(R.string.api_default_error);
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR
                && error.getErrorDetail().equals(ANConstants.CONNECTION_ERROR)) {
            getView().onError(R.string.connection_error);
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR
                && error.getErrorDetail().equals(ANConstants.REQUEST_CANCELLED_ERROR)) {
            getView().onError(R.string.api_retry_error);
            return;
        }

        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        try {
            ApiError apiError = gson.fromJson(error.getErrorBody(), ApiError.class);

            if (apiError == null || apiError.getMessage() == null) {
                getView().onError(R.string.api_default_error);
                return;
            }

            switch (error.getErrorCode()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    setUserAsLoggedOut();
//                    getView().openActivityOnTokenExpire();
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                case HttpsURLConnection.HTTP_NOT_FOUND:
                default:
                    getView().onError(apiError.getMessage());
            }
        } catch (JsonSyntaxException | NullPointerException e) {
            Timber.tag(TAG).e(e, "handleApiError");
            getView().onError(R.string.api_default_error);
        }
    }

    @Override
    public void setUserAsLoggedOut() {
        getDataManager().setAccessToken(null);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
