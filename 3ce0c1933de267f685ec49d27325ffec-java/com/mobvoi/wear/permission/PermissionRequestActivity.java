package com.mobvoi.wear.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.app.PermissionCompat;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import java.util.ArrayList;
import java.util.Arrays;
@Deprecated
/* loaded from: classes2.dex */
public class PermissionRequestActivity extends Activity {
    public static final String EXTRAS_KEY_GO_SETTINGS_MSG = "go_settings_msg";
    public static final String EXTRAS_KEY_PERMISSIONS = "permissions";
    public static final String EXTRAS_KEY_RATIONALE_MSG = "rationale_msg";
    private static final int PERMISSIONS_REQUEST_CODE = 1;
    private static final int SETTINGS_REQUEST_CODE = 2;
    private static final String TAG = "PermissionRequestAct";
    private boolean mFromPermissionRequest = false;
    private boolean mFromSettingsActivityResult = false;
    private String mGoSettingsMsg;
    protected String[] mPermissions;
    private String mRationaleMsg;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface DialogResult {
        void onNegative();

        void onPositive();
    }

    private void checkResult(String[] strArr, int[] iArr, boolean z10) {
        if (!isDestroyed() && !isFinishing()) {
            ArrayList arrayList = new ArrayList(strArr.length);
            boolean z11 = false;
            boolean z12 = true;
            for (int i10 = 0; i10 < strArr.length; i10++) {
                String str = strArr[i10];
                if (iArr[i10] == -1) {
                    arrayList.add(str);
                    if (PermissionCompat.shouldShowRequestPermissionRationale(this, str)) {
                        z12 = false;
                        z11 = true;
                    } else {
                        z12 = false;
                    }
                }
            }
            String[] strArr2 = new String[arrayList.size()];
            arrayList.toArray(strArr2);
            if (z12) {
                okAndFinish();
                return;
            }
            Object[] objArr = new Object[2];
            objArr[0] = Arrays.toString(strArr2);
            objArr[1] = z10 ? z11 ? "rationale" : "go settings" : "request permission";
            k.c(TAG, "Has un-granted permissions: %s, %s", objArr);
            if (z10) {
                showPermissionDialog(z11);
            } else {
                PermissionCompat.requestPermissions(this, strArr2, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Intent fillIntent(Intent intent, String[] strArr, String str, String str2) {
        intent.putExtra(EXTRAS_KEY_PERMISSIONS, strArr);
        intent.putExtra(EXTRAS_KEY_RATIONALE_MSG, str);
        intent.putExtra(EXTRAS_KEY_GO_SETTINGS_MSG, str2);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        try {
            startActivityForResult(intent, 2);
        } catch (Exception unused) {
            k.d(TAG, "Error to go Settings.");
            cancelAndFinish();
        }
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        for (String str : strArr) {
            if (PermissionCompat.checkSelfPermission(context, str) == -1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionIfNeed() {
        k.h(TAG, "Start permission request");
        int[] iArr = new int[this.mPermissions.length];
        int i10 = 0;
        while (true) {
            String[] strArr = this.mPermissions;
            if (i10 < strArr.length) {
                iArr[i10] = PermissionCompat.checkSelfPermission(this, strArr[i10]);
                i10++;
            } else {
                checkResult(strArr, iArr, false);
                return;
            }
        }
    }

    private void showPermissionDialog(final boolean z10) {
        showRationaleDialog(z10, z10 ? this.mRationaleMsg : this.mGoSettingsMsg, new DialogResult() { // from class: com.mobvoi.wear.permission.PermissionRequestActivity.1
            @Override // com.mobvoi.wear.permission.PermissionRequestActivity.DialogResult
            public void onNegative() {
                k.h(PermissionRequestActivity.TAG, "Cancel request");
                PermissionRequestActivity.this.cancelAndFinish();
            }

            @Override // com.mobvoi.wear.permission.PermissionRequestActivity.DialogResult
            public void onPositive() {
                if (z10) {
                    k.h(PermissionRequestActivity.TAG, "Restart request");
                    PermissionRequestActivity.this.requestPermissionIfNeed();
                    return;
                }
                k.h(PermissionRequestActivity.TAG, "Go Settings");
                PermissionRequestActivity.this.gotoSettings();
            }
        });
    }

    private void showStandardPermissionDialog(String str, final DialogResult dialogResult) {
        new AlertDialog.Builder(this).setMessage(str).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.permission.PermissionRequestActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
                dialogResult.onPositive();
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.permission.PermissionRequestActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.mobvoi.wear.permission.PermissionRequestActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                dialogResult.onNegative();
            }
        }).show().setCanceledOnTouchOutside(true);
    }

    private void showTicwearPermissionDialog(String str, final DialogResult dialogResult) throws ClassNotFoundException {
        com.mobvoi.wear.helper.AlertDialog alertDialog = new com.mobvoi.wear.helper.AlertDialog(this);
        alertDialog.setMessage(str);
        alertDialog.setIconPositiveButton(new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.permission.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                PermissionRequestActivity.DialogResult.this.onPositive();
            }
        });
        alertDialog.setIconNegativeButton(new DialogInterface.OnClickListener() { // from class: com.mobvoi.wear.permission.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                PermissionRequestActivity.DialogResult.this.onNegative();
            }
        });
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobvoi.wear.permission.i
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PermissionRequestActivity.DialogResult.this.onNegative();
            }
        });
        alertDialog.show();
    }

    public static void start(Activity activity, int i10, String[] strArr, String str, String str2) {
        Intent fillIntent = fillIntent(new Intent(activity, PermissionRequestActivity.class), strArr, str, str2);
        fillIntent.addFlags(4194304);
        activity.startActivityForResult(fillIntent, i10);
    }

    protected void cancelAndFinish() {
        k.h(TAG, "Some permissions are denied~");
        setResult(0);
        finish();
    }

    protected void okAndFinish() {
        k.h(TAG, "All granted, do anything you want~");
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 2) {
            requestPermissionIfNeed();
            this.mFromSettingsActivityResult = true;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.c(TAG, "onCreate %s", bundle);
        if (bundle != null) {
            finish();
            return;
        }
        if (getIntent() != null) {
            this.mPermissions = getIntent().getStringArrayExtra(EXTRAS_KEY_PERMISSIONS);
            this.mRationaleMsg = getIntent().getStringExtra(EXTRAS_KEY_RATIONALE_MSG);
            this.mGoSettingsMsg = getIntent().getStringExtra(EXTRAS_KEY_GO_SETTINGS_MSG);
        }
        this.mFromPermissionRequest = false;
        this.mFromSettingsActivityResult = false;
        if (this.mPermissions == null || TextUtils.isEmpty(this.mRationaleMsg) || TextUtils.isEmpty(this.mGoSettingsMsg)) {
            throw new IllegalArgumentException("Permissions and messages can NOT be empty.");
        }
        k.c(TAG, "Start permissions %s, with message %s | %s", Arrays.toString(this.mPermissions), this.mRationaleMsg, this.mGoSettingsMsg);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        k.c(TAG, "onRequestPermissionsResult for %d", Integer.valueOf(i10));
        this.mFromPermissionRequest = true;
        if (i10 == 1) {
            checkResult(strArr, iArr, true);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        k.a(TAG, "onStart");
        if (this.mFromPermissionRequest || this.mFromSettingsActivityResult) {
            return;
        }
        if (this.mPermissions.length == 0) {
            okAndFinish();
            return;
        }
        this.mFromSettingsActivityResult = false;
        this.mFromPermissionRequest = false;
        requestPermissionIfNeed();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        k.a(TAG, "onStop");
        this.mFromPermissionRequest = false;
        this.mFromSettingsActivityResult = false;
    }

    protected void showRationaleDialog(boolean z10, String str, DialogResult dialogResult) {
        try {
            showTicwearPermissionDialog(str, dialogResult);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            k.q(TAG, "Ticwear style dialog not found, use standard one.");
            showStandardPermissionDialog(str, dialogResult);
        }
    }

    public static void start(Context context, String[] strArr, String str, String str2) {
        if (hasPermissions(context, strArr)) {
            k.h(TAG, "All permissions granted.");
            return;
        }
        Intent fillIntent = fillIntent(new Intent(context, PermissionRequestActivity.class), strArr, str, str2);
        fillIntent.addFlags(268435456);
        context.startActivity(fillIntent);
    }
}
