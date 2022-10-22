package com.mobvoi.wear.providers;

import android.provider.BaseColumns;
/* loaded from: classes2.dex */
public interface AppUpdateColumn extends BaseColumns {
    public static final String CHANGE_LOG = "change_log";
    public static final int INDEX_CHANGE_LOG = 4;
    public static final int INDEX_ICON_URL = 3;
    public static final int INDEX_PACKAGE_NAME = 0;
    public static final int INDEX_REMIND_ENABLE = 5;
    public static final int INDEX_VERSION_CODE = 1;
    public static final int INDEX_VERSION_NAME = 2;
    public static final String PACKAGE_NAME = "package_name";
    public static final String VERSION_CODE = "version_code";
    public static final String VERSION_NAME = "version_name";
    public static final String ICON_URL = "icon_url";
    public static final String REMIND_ENABLE = "remind_enable";
    public static final String[] COLUMN_NAMES = {"package_name", VERSION_CODE, VERSION_NAME, ICON_URL, "change_log", REMIND_ENABLE};
}
