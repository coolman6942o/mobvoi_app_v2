package com.mobvoi.wear.permission;

import android.net.Uri;
import android.provider.BaseColumns;
/* loaded from: classes2.dex */
public interface PermissionConstant {
    public static final String DATABASE_NAME = "permission_db";
    public static final int DATABASE_VERSION = 1;
    public static final int DENIED_VALUE = -1;
    public static final int GRANTED_VALUE = 1;
    public static final int INIT_VALUE = 0;
    public static final String PROVIDER_NAME = "com.mobvoi.ticwear.permissionmanager.PermissionProvider";
    public static final String TABLE_FIELD_APP = "field_app";
    public static final String TABLE_FIELD_PERIMISSION = "field_perimission";
    public static final String TABLE_NAME = "permission";
    public static final int uriCode = 1;
    public static final Uri CONTENT_URI = Uri.parse("content://com.mobvoi.ticwear.permissionmanager.PermissionProvider/permission");
    public static final Uri CONTENT_PERIMISSION_URI = Uri.parse("content://com.mobvoi.ticwear.permissionmanager.PermissionProvider/permission/field_perimission");
    public static final Uri CONTENT_APP_URI = Uri.parse("content://com.mobvoi.ticwear.permissionmanager.PermissionProvider/permission/field_app");

    /* loaded from: classes2.dex */
    public interface Columns extends BaseColumns {
        public static final int COUNT = 3;
        public static final String PACKAGE = "package";
        public static final String PERMISSION = "permission";
        public static final String STATUS = "status";
    }
}
