package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.Calendar;
/* loaded from: classes2.dex */
final class v0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PayPalProfileSharingActivity f21816a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f21816a = payPalProfileSharingActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PayPalService payPalService;
        PayPalService payPalService2;
        PayPalService payPalService3;
        PayPalService payPalService4;
        String str;
        String str2;
        String str3;
        if (!this.f21816a.isFinishing()) {
            this.f21816a.f21584c = ((f1) iBinder).f21723a;
            payPalService = this.f21816a.f21584c;
            if (payPalService.S() == null) {
                str3 = PayPalProfileSharingActivity.f21581f;
                Log.e(str3, "Service state invalid.  Did you start the PayPalService?");
                this.f21816a.setResult(2);
                this.f21816a.finish();
                return;
            }
            Intent intent = this.f21816a.getIntent();
            payPalService2 = this.f21816a.f21584c;
            y0 y0Var = new y0(intent, payPalService2.S(), true);
            if (!y0Var.c()) {
                str2 = PayPalProfileSharingActivity.f21581f;
                Log.e(str2, "Service extras invalid.  Please see the docs.");
                this.f21816a.setResult(2);
                this.f21816a.finish();
            } else if (!y0Var.e()) {
                str = PayPalProfileSharingActivity.f21581f;
                Log.e(str, "Extras invalid.  Please see the docs.");
                this.f21816a.setResult(2);
                this.f21816a.finish();
            } else {
                payPalService3 = this.f21816a.f21584c;
                if (payPalService3.b0()) {
                    ProfileSharingConsentActivity.y(r4, 1, this.f21816a.f21584c.S());
                    return;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.add(13, 1);
                this.f21816a.f21582a = calendar.getTime();
                payPalService4 = this.f21816a.f21584c;
                payPalService4.x(PayPalProfileSharingActivity.b(this.f21816a), false);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        String unused;
        this.f21816a.f21584c = null;
        unused = PayPalProfileSharingActivity.f21581f;
    }
}
