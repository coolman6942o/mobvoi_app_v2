package com.mobvoi.mcuwatch.ui.customview;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.d;
import com.mobvoi.mcuwatch.ui.settings.ota.OtaActivity;
import k7.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.k;
/* compiled from: McuDialogActivity.kt */
/* loaded from: classes2.dex */
public final class McuDialogActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f19585a;

    /* compiled from: McuDialogActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final void I(final int i10) {
        String string = getString(k.K4);
        i.e(string, "getString(R.string.watch_lite_upgrade)");
        String string2 = getString(k.f34807g4);
        i.e(string2, "getString(R.string.watch_lite_new_version)");
        int i11 = k.f34853q0;
        String string3 = getString(i11);
        i.e(string3, "getString(R.string.common_confirm)");
        if (i10 == 1) {
            string = getString(k.Z);
            i.e(string, "getString(R.string.ble_update_alert_title)");
            string2 = getString(k.f34769a0);
            i.e(string2, "getString(R.string.ble_update_charge_message)");
            string3 = getString(i11);
            i.e(string3, "getString(R.string.common_confirm)");
        }
        new b(this).r(string).d(false).D(string2).j(k.f34848p0, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                McuDialogActivity.J(McuDialogActivity.this, dialogInterface, i12);
            }
        }).I(string3, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                McuDialogActivity.K(i10, this, dialogInterface, i12);
            }
        }).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(McuDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(int i10, McuDialogActivity this$0, DialogInterface dialog, int i11) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        if (i10 == 2) {
            OtaActivity.start(this$0);
        }
        dialog.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        int intExtra = getIntent().getIntExtra("extra_dialog_type", 0);
        this.f19585a = intExtra;
        I(intExtra);
    }
}
