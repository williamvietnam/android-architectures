package com.mvvm.java.sample.welcome;

import com.mvvm.java.R;
import com.mvvm.java.core.base.BaseMvvmViewModel;
import com.mvvm.java.core.data.DataManager;
import com.mvvm.java.core.utilities.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class WelcomeViewModel extends BaseMvvmViewModel {

    private final List<Welcome> welcomes;

    @Inject
    public WelcomeViewModel(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
        welcomes = new ArrayList<>();
    }

    public List<Welcome> getWelcomes() {
        Welcome welcome1 = new Welcome(R.drawable.ic_approval, R.string.headline_welcome_1, R.string.description_welcome_1);
        Welcome welcome2 = new Welcome(R.drawable.ic_app_blocking, R.string.headline_welcome_2, R.string.description_welcome_2);
        Welcome welcome3 = new Welcome(R.drawable.ic_alarm_on, R.string.headline_welcome_3, R.string.description_welcome_3);
        this.welcomes.add(welcome1);
        this.welcomes.add(welcome2);
        this.welcomes.add(welcome3);
        return this.welcomes;
    }
}