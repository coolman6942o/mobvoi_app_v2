package com.mobvoi.wear.permission;

import android.os.RemoteException;
import android.util.Log;
import com.mobvoi.wear.permission.IMobvoiPermissionManager;
import u9.a;
import u9.b;
/* loaded from: classes2.dex */
public class MobvoiPermissionManager {
    private static final String MOBVOI_PERMISSION = "mobvoi_permission";
    private static final boolean FEATURE_SUPPORTED = b.a("ro.mobvoi_dynamic_permission", "0").equals("1");
    private static final String TAG = "MobvoiPermissionManager";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static IMobvoiPermissionManager sMobvoiPermissionInstance = null;

    public static boolean checkPermission(String str, int i10) {
        boolean z10 = DEBUG;
        if (z10) {
            Log.d(TAG, "checkPermission " + str + " " + i10);
        }
        if (FEATURE_SUPPORTED) {
            if (i10 < 10000 || i10 > 19999) {
                return true;
            }
            try {
                IMobvoiPermissionManager mobvoiServiceInstance = getMobvoiServiceInstance();
                if (mobvoiServiceInstance != null) {
                    if (mobvoiServiceInstance.checkPermission(str, i10) == 0) {
                        if (z10) {
                            Log.d(TAG, "Permission Granted!");
                        }
                        return true;
                    } else if (!z10) {
                        return false;
                    } else {
                        Log.d(TAG, "Permission Denied!");
                        return false;
                    }
                }
            } catch (RemoteException e10) {
                Log.e(TAG, "checkPermission Failed!", e10);
            }
        }
        if (DEBUG) {
            Log.d(TAG, "By default, Permission Granted!");
        }
        return true;
    }

    private static IMobvoiPermissionManager getMobvoiServiceInstance() {
        if (sMobvoiPermissionInstance == null) {
            sMobvoiPermissionInstance = IMobvoiPermissionManager.Stub.asInterface(a.a(MOBVOI_PERMISSION));
        }
        return sMobvoiPermissionInstance;
    }

    public static boolean isSupported() {
        return FEATURE_SUPPORTED;
    }

    public static int queryPermission(String str, int i10) {
        if (DEBUG) {
            Log.d(TAG, "queryPermission " + str + " " + i10);
        }
        if (FEATURE_SUPPORTED) {
            if (i10 < 10000 || i10 > 19999) {
                return 0;
            }
            try {
                IMobvoiPermissionManager mobvoiServiceInstance = getMobvoiServiceInstance();
                if (mobvoiServiceInstance != null) {
                    return mobvoiServiceInstance.queryPermission(str, i10);
                }
            } catch (RemoteException e10) {
                Log.e(TAG, "checkPermission Failed!", e10);
            }
        }
        if (DEBUG) {
            Log.d(TAG, "By default, Permission Granted!");
        }
        return 0;
    }
}
