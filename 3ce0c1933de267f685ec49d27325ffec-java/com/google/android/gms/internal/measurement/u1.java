package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import b6.i;
/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    private final x1 f9694a;

    public u1(x1 x1Var) {
        i.k(x1Var);
        this.f9694a = x1Var;
    }

    public static boolean b(Context context) {
        ActivityInfo receiverInfo;
        i.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null)) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void a(Context context, Intent intent) {
        d2 t02 = d2.t0(context);
        z0 c10 = t02.c();
        if (intent == null) {
            c10.N().a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        c10.R().d("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            c10.R().a("Starting wakeful intent.");
            this.f9694a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                t02.d().J(new v1(this, t02, c10));
            } catch (Exception e10) {
                c10.N().d("Install Referrer Reporter encountered a problem", e10);
            }
            BroadcastReceiver.PendingResult b10 = this.f9694a.b();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                c10.R().a("Install referrer extras are null");
                if (b10 != null) {
                    b10.finish();
                    return;
                }
                return;
            }
            c10.P().d("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                stringExtra = stringExtra.length() != 0 ? "?".concat(stringExtra) : new String("?");
            }
            Bundle A = t02.K().A(Uri.parse(stringExtra));
            if (A == null) {
                c10.R().a("No campaign defined in install referrer broadcast");
                if (b10 != null) {
                    b10.finish();
                    return;
                }
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0L);
            if (longExtra == 0) {
                c10.N().a("Install referrer is missing timestamp");
            }
            t02.d().J(new w1(this, t02, longExtra, A, context, c10, b10));
        }
    }
}
