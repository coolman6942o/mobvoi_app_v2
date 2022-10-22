package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.k;
import androidx.fragment.app.f;
import b6.d;
import b6.e;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.i1;
import com.google.android.gms.common.api.internal.j1;
import com.google.android.gms.common.api.internal.m1;
import h6.n;
import q6.i;
import z5.c;
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f8806d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final b f8807e = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final int f8808f = c.f8812a;

    /* renamed from: c  reason: collision with root package name */
    private String f8809c;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class a extends i {

        /* renamed from: a  reason: collision with root package name */
        private final Context f8810a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f8810a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Don't know how to handle this message: ");
                sb2.append(i10);
                Log.w("GoogleApiAvailability", sb2.toString());
                return;
            }
            int i11 = b.this.i(this.f8810a);
            if (b.this.m(i11)) {
                b.this.t(this.f8810a, i11);
            }
        }
    }

    private final String C() {
        String str;
        synchronized (f8806d) {
            str = this.f8809c;
        }
        return str;
    }

    public static b q() {
        return f8807e;
    }

    public static Dialog u(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(d.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        x(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    static Dialog v(Context context, int i10, e eVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(d.d(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c10 = d.c(context, i10);
        if (c10 != null) {
            builder.setPositiveButton(c10, eVar);
        }
        String g10 = d.g(context, i10);
        if (g10 != null) {
            builder.setTitle(g10);
        }
        return builder.create();
    }

    static void x(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof f) {
            c.q0(dialog, onCancelListener).p0(((f) activity).getSupportFragmentManager(), str);
            return;
        }
        z5.a.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void z(Context context, int i10, String str, PendingIntent pendingIntent) {
        int i11;
        if (i10 == 18) {
            y(context);
        } else if (pendingIntent != null) {
            String f10 = d.f(context, i10);
            String e10 = d.e(context, i10);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            k.d w10 = new k.d(context).p(true).e(true).k(f10).w(new k.b().h(e10));
            if (h6.i.c(context)) {
                b6.i.n(n.f());
                w10.u(context.getApplicationInfo().icon).s(2);
                if (h6.i.d(context)) {
                    w10.a(y5.a.f36758a, resources.getString(y5.b.f36773o), pendingIntent);
                } else {
                    w10.i(pendingIntent);
                }
            } else {
                w10.u(17301642).x(resources.getString(y5.b.f36766h)).z(System.currentTimeMillis()).i(pendingIntent).j(e10);
            }
            if (n.i()) {
                b6.i.n(n.i());
                String C = C();
                if (C == null) {
                    C = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(C);
                    String b10 = d.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(C, b10, 4));
                    } else if (!b10.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b10);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                w10.g(C);
            }
            Notification b11 = w10.b();
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                i11 = 10436;
                e.f8833d.set(false);
            } else {
                i11 = 39789;
            }
            notificationManager.notify(i11, b11);
        } else if (i10 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final boolean A(Activity activity, h hVar, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog v10 = v(activity, i10, e.b(hVar, d(activity, i10, com.huawei.hms.mlkit.common.ha.d.f14069a), 2), onCancelListener);
        if (v10 == null) {
            return false;
        }
        x(activity, v10, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean B(Context context, ConnectionResult connectionResult, int i10) {
        PendingIntent p10 = p(context, connectionResult);
        if (p10 == null) {
            return false;
        }
        z(context, connectionResult.G0(), null, GoogleApiActivity.a(context, p10, i10));
        return true;
    }

    @Override // com.google.android.gms.common.c
    public Intent d(Context context, int i10, String str) {
        return super.d(context, i10, str);
    }

    @Override // com.google.android.gms.common.c
    public PendingIntent e(Context context, int i10, int i11) {
        return super.e(context, i10, i11);
    }

    @Override // com.google.android.gms.common.c
    public final String g(int i10) {
        return super.g(i10);
    }

    @Override // com.google.android.gms.common.c
    public int i(Context context) {
        return super.i(context);
    }

    @Override // com.google.android.gms.common.c
    public int j(Context context, int i10) {
        return super.j(context, i10);
    }

    @Override // com.google.android.gms.common.c
    public final boolean m(int i10) {
        return super.m(i10);
    }

    public Dialog o(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return v(activity, i10, e.a(activity, d(activity, i10, com.huawei.hms.mlkit.common.ha.d.f14069a), i11), onCancelListener);
    }

    public PendingIntent p(Context context, ConnectionResult connectionResult) {
        if (connectionResult.J0()) {
            return connectionResult.I0();
        }
        return e(context, connectionResult.G0(), 0);
    }

    public com.google.android.gms.tasks.b<Void> r(Activity activity) {
        int i10 = f8808f;
        b6.i.f("makeGooglePlayServicesAvailable must be called from the main thread");
        int j10 = j(activity, i10);
        if (j10 == 0) {
            return com.google.android.gms.tasks.e.e(null);
        }
        m1 r10 = m1.r(activity);
        r10.n(new ConnectionResult(j10, null), 0);
        return r10.q();
    }

    public boolean s(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog o10 = o(activity, i10, i11, onCancelListener);
        if (o10 == null) {
            return false;
        }
        x(activity, o10, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void t(Context context, int i10) {
        z(context, i10, null, f(context, i10, 0, "n"));
    }

    public final i1 w(Context context, j1 j1Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        i1 i1Var = new i1(j1Var);
        context.registerReceiver(i1Var, intentFilter);
        i1Var.b(context);
        if (l(context, "com.google.android.gms")) {
            return i1Var;
        }
        j1Var.a();
        i1Var.a();
        return null;
    }

    final void y(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }
}
