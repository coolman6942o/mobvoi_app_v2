package com.mobvoi.wear.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.app.PermissionCompat;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.common.steps.PageStep;
import com.mobvoi.wear.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class PermissionPageStep extends PageStep {
    private Activity mActivity;
    private StartForResult.OnPermissionResultCallback mOnPermissionResultCallback;
    private String[] mRequestedPermissions;
    private StartForResult mStartForResult;
    private CharSequence mRationaleMessage = "";
    private CharSequence mSettingsMessage = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PermissionCallback implements StartForResult.OnPermissionResultCallback {
        private PermissionPageStep mPermissionStep;

        @Override // com.mobvoi.wear.common.StartForResult.OnPermissionResultCallback
        public void onCallback(List<StartForResult.PermissionResult> list) {
            this.mPermissionStep.requestPermissionsWithDialogIfNeeded(list);
        }

        private PermissionCallback(PermissionPageStep permissionPageStep) {
            this.mPermissionStep = permissionPageStep;
        }
    }

    public PermissionPageStep(Activity activity) {
        this.mActivity = activity;
        this.mStartForResult = StartForResult.newInstance(activity);
    }

    private void doRequestPermissions(String[] strArr) {
        this.mStartForResult.requestPermissionsForResult(strArr, new PermissionCallback());
    }

    private void doRequestPermissionsIfNeed(String[] strArr) {
        List<StartForResult.PermissionResult> parseArrayToList = parseArrayToList(strArr);
        if (isPermissionsAllGranted(parseArrayToList)) {
            StartForResult.OnPermissionResultCallback onPermissionResultCallback = this.mOnPermissionResultCallback;
            if (onPermissionResultCallback != null) {
                onPermissionResultCallback.onCallback(parseArrayToList);
                return;
            }
            return;
        }
        doRequestPermissions(strArr);
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
    public /* synthetic */ void lambda$execute$0(List list) {
        complete(PermissionHelper.isPermissionsAllGranted(list) ? PageStep.PageStepResult.Success : PageStep.PageStepResult.Failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionTipsDialog$1(List list, StartForResult.ActivityResult activityResult) {
        requestPermissionsWithDialogIfNeeded(parseArrayToList(parseListToArray(list)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionTipsDialog$2(boolean z10, final List list) {
        if (z10) {
            doRequestPermissionsIfNeed(parseListToArray(list));
        } else {
            requestPermissionsByStartSettings(new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.helper.g
                @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                public final void onCallback(StartForResult.ActivityResult activityResult) {
                    PermissionPageStep.this.lambda$showPermissionTipsDialog$1(list, activityResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionTipsDialog$3(List list) {
        StartForResult.OnPermissionResultCallback onPermissionResultCallback = this.mOnPermissionResultCallback;
        if (onPermissionResultCallback != null) {
            onPermissionResultCallback.onCallback(list);
        }
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
        if (PermissionHelper.isPermissionsAllGranted(list)) {
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
            alertDialog.setIconPositiveButton(new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.helper.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    runnable.run();
                }
            });
            alertDialog.setIconNegativeButton(new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.helper.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    runnable2.run();
                }
            });
            alertDialog.show();
        }
    }

    private void showPermissionTipsDialog(final boolean z10, final List<StartForResult.PermissionResult> list) {
        showDialog(z10, new Runnable() { // from class: com.mobvoi.wear.helper.j
            @Override // java.lang.Runnable
            public final void run() {
                PermissionPageStep.this.lambda$showPermissionTipsDialog$2(z10, list);
            }
        }, new Runnable() { // from class: com.mobvoi.wear.helper.i
            @Override // java.lang.Runnable
            public final void run() {
                PermissionPageStep.this.lambda$showPermissionTipsDialog$3(list);
            }
        });
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        if (isPermissionsAllGranted(parseArrayToList(this.mRequestedPermissions))) {
            complete(PageStep.PageStepResult.Skipped);
            return;
        }
        this.mOnPermissionResultCallback = new StartForResult.OnPermissionResultCallback() { // from class: com.mobvoi.wear.helper.h
            @Override // com.mobvoi.wear.common.StartForResult.OnPermissionResultCallback
            public final void onCallback(List list) {
                PermissionPageStep.this.lambda$execute$0(list);
            }
        };
        doRequestPermissions(this.mRequestedPermissions);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    public String getName() {
        return "Permission";
    }

    public void requestPermissionsByStartSettings(StartForResult.OnActivityResultCallback onActivityResultCallback) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mActivity.getPackageName(), null));
        try {
            this.mStartForResult.startActivityForResult(intent, onActivityResultCallback);
        } catch (Exception e10) {
            k.e("PageStep", "startAppDetailsSettings: ", e10);
        }
    }

    public PermissionPageStep setRationaleMessage(CharSequence charSequence) {
        this.mRationaleMessage = charSequence;
        return this;
    }

    public PermissionPageStep setRequestedPermissions(String[] strArr) {
        this.mRequestedPermissions = strArr;
        return this;
    }

    public PermissionPageStep setSettingsMessage(CharSequence charSequence) {
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

    public boolean isGranted(String str) {
        return isGranted(this.mActivity, str);
    }

    public PermissionPageStep setRationaleMessage(int i10, Object... objArr) {
        this.mRationaleMessage = this.mActivity.getString(i10, objArr);
        return this;
    }

    public PermissionPageStep setSettingsMessage(int i10, Object... objArr) {
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
}
