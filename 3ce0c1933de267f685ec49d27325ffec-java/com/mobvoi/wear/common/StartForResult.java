package com.mobvoi.wear.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StartForResult {
    private static final int REQUEST_CODE_ACTIVITY = 1120;
    private static final int REQUEST_CODE_INTENT_SENDER = 1226;
    private static final int REQUEST_CODE_PERMISSIONS = 1020;
    private FragmentCompat SOUL = FragmentCompat.newInstance(this);
    private Activity mActivity;
    private Fragment mFragment;
    private OnActivityResultCallback mOnActivityResult;
    private OnActivityResultCallback mOnIntentSenderResultCallback;
    private OnPermissionResultCallback mOnPermissionResult;

    /* loaded from: classes2.dex */
    public static class ActivityResult {
        public final Intent data;
        public final int requestCode;
        public final int resultCode;

        private ActivityResult(int i10, int i11, Intent intent) {
            this.requestCode = i10;
            this.resultCode = i11;
            this.data = intent;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnActivityResultCallback {
        void onCallback(ActivityResult activityResult);
    }

    /* loaded from: classes2.dex */
    public interface OnPermissionResultCallback {
        void onCallback(List<PermissionResult> list);
    }

    /* loaded from: classes2.dex */
    public static class PermissionResult {
        public boolean isGranted;
        public String name;
        public boolean shouldShowRationale;
    }

    private StartForResult(Activity activity) {
        this.mActivity = activity;
    }

    public static StartForResult newInstance(Activity activity) {
        return new StartForResult(activity);
    }

    @TargetApi(23)
    private boolean shouldShowRequestPermissionRationale(String str) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.shouldShowRequestPermissionRationale(str);
        }
        return this.mActivity.shouldShowRequestPermissionRationale(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManager getFragmentManager() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity.getFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.getChildFragmentManager();
        }
        Activity activity = this.mActivity;
        if (activity instanceof f) {
            return ((f) activity).getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityResult(int i10, int i11, Intent intent) {
        OnActivityResultCallback onActivityResultCallback;
        if (i10 == REQUEST_CODE_ACTIVITY) {
            OnActivityResultCallback onActivityResultCallback2 = this.mOnActivityResult;
            if (onActivityResultCallback2 != null) {
                onActivityResultCallback2.onCallback(new ActivityResult(i10, i11, intent));
            }
        } else if (i10 == REQUEST_CODE_INTENT_SENDER && (onActivityResultCallback = this.mOnIntentSenderResultCallback) != null) {
            onActivityResultCallback.onCallback(new ActivityResult(i10, i11, intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (!(i10 != REQUEST_CODE_PERMISSIONS || this.mOnPermissionResult == null || strArr.length == 0 || iArr.length == 0)) {
            int min = Math.min(strArr.length, iArr.length);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < min; i11++) {
                PermissionResult permissionResult = new PermissionResult();
                permissionResult.name = strArr[i11];
                permissionResult.isGranted = iArr[i11] == 0;
                permissionResult.shouldShowRationale = shouldShowRequestPermissionRationale(strArr[i11]);
                arrayList.add(permissionResult);
            }
            this.mOnPermissionResult.onCallback(arrayList);
        }
    }

    public void requestPermissionsForResult(String[] strArr, OnPermissionResultCallback onPermissionResultCallback) {
        this.mOnPermissionResult = onPermissionResultCallback;
        this.SOUL.requestPermissionsForResult(strArr);
    }

    public void startActivityForResult(Intent intent, OnActivityResultCallback onActivityResultCallback) {
        startActivityForResult(intent, null, onActivityResultCallback);
    }

    public void startIntentSenderForResult(IntentSender intentSender, Intent intent, int i10, int i11, int i12, OnActivityResultCallback onActivityResultCallback) throws IntentSender.SendIntentException {
        startIntentSenderForResult(intentSender, intent, i10, i11, i12, null, onActivityResultCallback);
    }

    public static StartForResult newInstance(Fragment fragment) {
        return new StartForResult(fragment);
    }

    public void startActivityForResult(Intent intent, Bundle bundle, OnActivityResultCallback onActivityResultCallback) {
        this.mOnActivityResult = onActivityResultCallback;
        this.SOUL.startActivityForResult(intent, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, Intent intent, int i10, int i11, int i12, Bundle bundle, OnActivityResultCallback onActivityResultCallback) throws IntentSender.SendIntentException {
        this.mOnIntentSenderResultCallback = onActivityResultCallback;
        this.SOUL.startIntentSenderForResult(intentSender, intent, i10, i11, i12, bundle);
    }

    private StartForResult(Fragment fragment) {
        this.mFragment = fragment;
    }
}
