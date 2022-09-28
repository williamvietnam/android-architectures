package com.mvvm.java.core.data;

import com.mvvm.java.core.data.database.RoomDatabaseHelper;
import com.mvvm.java.core.data.network.ApiHelper;
import com.mvvm.java.core.data.preferences.PreferencesHelper;

public interface DataManager extends PreferencesHelper, RoomDatabaseHelper, ApiHelper {

    PreferencesHelper getPreferenceInstance();

    RoomDatabaseHelper getDatabaseInstance();

    ApiHelper getApiInstance();
}