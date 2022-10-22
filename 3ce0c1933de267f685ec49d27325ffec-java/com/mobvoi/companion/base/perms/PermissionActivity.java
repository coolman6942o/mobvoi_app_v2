package com.mobvoi.companion.base.perms;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import gc.f;
import k7.b;
/* loaded from: classes2.dex */
public class PermissionActivity extends PermissionRequestActivity {
    public static void start(Activity activity, int i10, String[] strArr, String str, String str2) {
        Intent fillIntent = PermissionRequestActivity.fillIntent(new Intent(activity, PermissionActivity.class), strArr, str, str2);
        fillIntent.addFlags(4194304);
        activity.startActivityForResult(fillIntent, i10);
    }

    @Override // com.mobvoi.wear.permission.PermissionRequestActivity
    protected void showRationaleDialog(boolean z10, String str, final PermissionRequestActivity.DialogResult dialogResult) {
        new b(this).D(str).d(true).j(f.f27359a, new DialogInterface.OnClickListener() { // from class: hc.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                PermissionRequestActivity.DialogResult.this.onNegative();
            }
        }).m(z10 ? f.f27360b : f.f27361c, new DialogInterface.OnClickListener() { // from class: hc.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                PermissionRequestActivity.DialogResult.this.onPositive();
            }
        }).F(new DialogInterface.OnCancelListener() { // from class: hc.a
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                PermissionRequestActivity.DialogResult.this.onNegative();
            }
        }).a().show();
    }

    public static void start(Context context, String[] strArr, String str, String str2) {
        Intent fillIntent = PermissionRequestActivity.fillIntent(new Intent(context, PermissionActivity.class), strArr, str, str2);
        fillIntent.addFlags(268435456);
        context.startActivity(fillIntent);
    }
}
