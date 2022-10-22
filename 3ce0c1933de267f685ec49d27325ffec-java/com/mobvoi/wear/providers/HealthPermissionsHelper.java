package com.mobvoi.wear.providers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import com.mobvoi.wear.providers.HealthPermissionsHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class HealthPermissionsHelper {
    private static final String PERMISSION_REQUEST_ACTION = "com.mobvoi.health.action.PERMISSION_REQUEST";
    private static final String TAG = "HealthPermissionsHelper";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile HealthPermissionsHelper sInstance;
    private final Context context;

    /* loaded from: classes2.dex */
    public interface PermissionResultCallback {
        void onPermissionResultGot(boolean z10);
    }

    private HealthPermissionsHelper(Context context) {
        this.context = context;
    }

    public static HealthPermissionsHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (HealthPermissionsHelper.class) {
                if (sInstance == null) {
                    sInstance = new HealthPermissionsHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private boolean isPermissionsDefined(String[] strArr, String str) {
        List list;
        try {
            String[] strArr2 = this.context.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr2 == null) {
                list = Collections.emptyList();
            } else {
                list = Arrays.asList(strArr2);
            }
            for (String str2 : strArr) {
                if (!list.contains(str2)) {
                    k.s(TAG, "Permission %s not defined in Health App, skip request", str2);
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            k.e(TAG, "Package info failed to get", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestPermissionsInternal$0(PermissionResultCallback permissionResultCallback, StartForResult.ActivityResult activityResult) {
        permissionResultCallback.onPermissionResultGot(activityResult.resultCode == -1);
    }

    private boolean requestPermissionsInternal(Context context, String[] strArr, String str, String str2, final PermissionResultCallback permissionResultCallback) {
        if (strArr.length == 0) {
            k.h(TAG, "Permission empty, treat as all granted.");
            if (permissionResultCallback != null) {
                permissionResultCallback.onPermissionResultGot(true);
            }
            return false;
        }
        Intent intent = new Intent(PERMISSION_REQUEST_ACTION);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_PERMISSIONS, strArr);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_RATIONALE_MSG, str);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_GO_SETTINGS_MSG, str2);
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity == null) {
            k.q(TAG, "Permission request activity not found.");
            if (permissionResultCallback != null) {
                permissionResultCallback.onPermissionResultGot(false);
            }
            return false;
        } else if (!isPermissionsDefined(strArr, resolveActivity.getPackageName())) {
            k.q(TAG, "Permission not defined, skip request");
            if (permissionResultCallback != null) {
                permissionResultCallback.onPermissionResultGot(false);
            }
            return false;
        } else if (permissionResultCallback != null) {
            k.a(TAG, "Has permission request activity, start with result");
            StartForResult.OnActivityResultCallback aVar = new StartForResult.OnActivityResultCallback() { // from class: uk.a
                @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                public final void onCallback(StartForResult.ActivityResult activityResult) {
                    HealthPermissionsHelper.lambda$requestPermissionsInternal$0(HealthPermissionsHelper.PermissionResultCallback.this, activityResult);
                }
            };
            intent.addFlags(4194304);
            StartForResult.newInstance((Activity) context).startActivityForResult(intent, aVar);
            return true;
        } else {
            k.h(TAG, "Has permission request activity, start without result");
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        }
    }

    public boolean isComponentExist() {
        return new Intent(PERMISSION_REQUEST_ACTION).resolveActivity(this.context.getPackageManager()) != null;
    }

    public boolean isPermissionGranted(String str) {
        ComponentName resolveActivity = new Intent(PERMISSION_REQUEST_ACTION).resolveActivity(this.context.getPackageManager());
        if (resolveActivity == null) {
            k.q(TAG, "Health App version too low, skip permission check");
            return false;
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(resolveActivity.getPackageName(), 4096);
            String[] strArr = packageInfo.requestedPermissions;
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (str.equals(strArr[i10])) {
                    return (packageInfo.requestedPermissionsFlags[i10] & 2) != 0;
                }
            }
            k.s(TAG, "Permission %s not found in Health", str);
        } catch (PackageManager.NameNotFoundException e10) {
            k.e(TAG, "Package info failed to get", e10);
        }
        return false;
    }

    public boolean requestPermissions(String[] strArr, String str, String str2) {
        return requestPermissionsInternal(this.context, strArr, str, str2, null);
    }

    public boolean requestPermissionsForResult(Activity activity, String[] strArr, String str, String str2, PermissionResultCallback permissionResultCallback) {
        return requestPermissionsInternal(activity, strArr, str, str2, permissionResultCallback);
    }
}
