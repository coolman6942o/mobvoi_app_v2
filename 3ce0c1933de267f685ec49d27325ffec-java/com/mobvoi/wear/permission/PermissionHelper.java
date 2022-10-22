package com.mobvoi.wear.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.app.PermissionCompat;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.helper.AlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class PermissionHelper {
    private static final String TAG = "PermissionHelper";
    protected Activity mActivity;
    private StartForResult.OnPermissionResultCallback mOnPermissionResultCallback;
    protected CharSequence mRationaleMessage = "";
    protected CharSequence mSettingsMessage = "";
    private StartForResult mStartForResult;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PermissionCallback implements StartForResult.OnPermissionResultCallback {
        private PermissionHelper mPermissionHelper;

        @Override // com.mobvoi.wear.common.StartForResult.OnPermissionResultCallback
        public void onCallback(List<StartForResult.PermissionResult> list) {
            this.mPermissionHelper.requestPermissionsWithDialogIfNeeded(list);
        }

        private PermissionCallback(PermissionHelper permissionHelper) {
            this.mPermissionHelper = permissionHelper;
        }
    }

    private PermissionHelper(Activity activity) {
        this.mActivity = activity;
        this.mStartForResult = StartForResult.newInstance(activity);
    }

    private void doRequestPermissions(String[] strArr) {
        List<StartForResult.PermissionResult> parseArrayToList = parseArrayToList(strArr);
        if (isPermissionsAllGranted(parseArrayToList)) {
            StartForResult.OnPermissionResultCallback onPermissionResultCallback = this.mOnPermissionResultCallback;
            if (onPermissionResultCallback != null) {
                onPermissionResultCallback.onCallback(parseArrayToList);
                return;
            }
            return;
        }
        this.mStartForResult.requestPermissionsForResult(strArr, new PermissionCallback());
    }

    public static boolean isGranted(Context context, String str) {
        return b.a(context, str) == 0;
    }

    public static boolean isPermissionsAllGranted(List<StartForResult.PermissionResult> list) {
        if (!(list == null || list.size() == 0)) {
            for (StartForResult.PermissionResult permissionResult : list) {
                if (!permissionResult.isGranted) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionTipsDialog$0(List list, StartForResult.ActivityResult activityResult) {
        requestPermissionsWithDialogIfNeeded(parseArrayToList(parseListToArray(list)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionTipsDialog$1(boolean z10, final List list) {
        if (z10) {
            doRequestPermissions(parseListToArray(list));
        } else {
            requestPermissionsByStartSettings(new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.permission.d
                @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                public final void onCallback(StartForResult.ActivityResult activityResult) {
                    PermissionHelper.this.lambda$showPermissionTipsDialog$0(list, activityResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionTipsDialog$2(List list) {
        StartForResult.OnPermissionResultCallback onPermissionResultCallback = this.mOnPermissionResultCallback;
        if (onPermissionResultCallback != null) {
            onPermissionResultCallback.onCallback(list);
        }
    }

    public static PermissionHelper newInstance(Activity activity) {
        return new PermissionHelper(activity);
    }

    private List<StartForResult.PermissionResult> parseArrayToList(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            StartForResult.PermissionResult permissionResult = new StartForResult.PermissionResult();
            permissionResult.name = str;
            permissionResult.isGranted = isGranted(str);
            permissionResult.shouldShowRationale = shouldShowRationale(str);
            arrayList.add(permissionResult);
        }
        return arrayList;
    }

    private String[] parseListToArray(List<StartForResult.PermissionResult> list) {
        if (list == null || list.size() == 0) {
            return new String[0];
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = list.get(i10).name;
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionsWithDialogIfNeeded(List<StartForResult.PermissionResult> list) {
        if (isPermissionsAllGranted(list)) {
            StartForResult.OnPermissionResultCallback onPermissionResultCallback = this.mOnPermissionResultCallback;
            if (onPermissionResultCallback != null) {
                onPermissionResultCallback.onCallback(list);
                return;
            }
            return;
        }
        boolean z10 = false;
        Iterator<StartForResult.PermissionResult> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StartForResult.PermissionResult next = it.next();
            if (!next.isGranted && next.shouldShowRationale) {
                z10 = true;
                break;
            }
        }
        showPermissionTipsDialog(z10, list);
    }

    private void showDialog(boolean z10, final Runnable runnable, final Runnable runnable2) {
        if (!showCustomDialog(z10, runnable, runnable2)) {
            String charSequence = (z10 ? this.mRationaleMessage : this.mSettingsMessage).toString();
            AlertDialog alertDialog = new AlertDialog(this.mActivity);
            alertDialog.setMessage(charSequence);
            alertDialog.setIconPositiveButton(new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.permission.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    runnable.run();
                }
            });
            alertDialog.setIconNegativeButton(new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.permission.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    runnable2.run();
                }
            });
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobvoi.wear.permission.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    runnable2.run();
                }
            });
            alertDialog.show();
        }
    }

    private void showPermissionTipsDialog(final boolean z10, final List<StartForResult.PermissionResult> list) {
        showDialog(z10, new Runnable() { // from class: com.mobvoi.wear.permission.f
            @Override // java.lang.Runnable
            public final void run() {
                PermissionHelper.this.lambda$showPermissionTipsDialog$1(z10, list);
            }
        }, new Runnable() { // from class: com.mobvoi.wear.permission.e
            @Override // java.lang.Runnable
            public final void run() {
                PermissionHelper.this.lambda$showPermissionTipsDialog$2(list);
            }
        });
    }

    public void requestPermissions(String[] strArr) {
        requestPermissions(strArr, null);
    }

    public void requestPermissionsByStartSettings(StartForResult.OnActivityResultCallback onActivityResultCallback) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mActivity.getPackageName(), null));
        try {
            if (onActivityResultCallback == null) {
                this.mActivity.startActivity(intent);
            } else {
                this.mStartForResult.startActivityForResult(intent, onActivityResultCallback);
            }
        } catch (Exception e10) {
            k.e(TAG, "startAppDetailsSettings: ", e10);
        }
    }

    public PermissionHelper setRationaleMessage(CharSequence charSequence) {
        this.mRationaleMessage = charSequence;
        return this;
    }

    public PermissionHelper setSettingsMessage(CharSequence charSequence) {
        this.mSettingsMessage = charSequence;
        return this;
    }

    public boolean shouldShowRationale(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.mActivity.shouldShowRequestPermissionRationale(str);
        }
        return PermissionCompat.shouldShowRequestPermissionRationale(this.mActivity, str);
    }

    protected boolean showCustomDialog(boolean z10, Runnable runnable, Runnable runnable2) {
        return false;
    }

    public static PermissionHelper newInstance(Fragment fragment) {
        return new PermissionHelper(fragment);
    }

    public boolean isGranted(String str) {
        return isGranted(this.mActivity, str);
    }

    public void requestPermissions(String[] strArr, StartForResult.OnPermissionResultCallback onPermissionResultCallback) {
        if (strArr.length != 0) {
            this.mOnPermissionResultCallback = onPermissionResultCallback;
            doRequestPermissions(strArr);
            return;
        }
        throw new IllegalArgumentException("permissions cannot be null!");
    }

    public PermissionHelper setRationaleMessage(int i10, Object... objArr) {
        this.mRationaleMessage = this.mActivity.getString(i10, objArr);
        return this;
    }

    public PermissionHelper setSettingsMessage(int i10, Object... objArr) {
        this.mSettingsMessage = this.mActivity.getString(i10, objArr);
        return this;
    }

    public static boolean isPermissionsAllGranted(Context context, String[] strArr) {
        for (String str : strArr) {
            if (!isGranted(context, str)) {
                return false;
            }
        }
        return true;
    }

    private PermissionHelper(Fragment fragment) {
        this.mActivity = fragment.requireActivity();
        this.mStartForResult = StartForResult.newInstance(fragment);
    }
}
