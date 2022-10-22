package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import b6.i;
import c7.x0;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class x extends c<i> {
    private final ExecutorService E;
    private final k<Object> F;
    private final k<Object> G;
    private final k<com.google.android.gms.wearable.c> H;
    private final k<d> I;
    private final k<h.a> J;
    private final k<Object> K;
    private final k<Object> L;
    private final k<a.AbstractC0116a> M;
    private final x0 N;

    public x(Context context, Looper looper, d.b bVar, d.c cVar, b6.c cVar2) {
        this(context, looper, bVar, cVar, cVar2, Executors.newCachedThreadPool(), x0.a(context));
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String H() {
        return this.N.e("com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.b
    public final void L(int i10, IBinder iBinder, Bundle bundle, int i11) {
        if (Log.isLoggable("WearableClient", 2)) {
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("onPostInitHandler: statusCode ");
            sb2.append(i10);
            Log.v("WearableClient", sb2.toString());
        }
        if (i10 == 0) {
            this.F.a(iBinder);
            this.G.a(iBinder);
            this.H.a(iBinder);
            this.I.a(iBinder);
            this.J.a(iBinder);
            this.K.a(iBinder);
            this.L.a(iBinder);
            this.M.a(iBinder);
        }
        super.L(i10, iBinder, bundle, i11);
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final void j(b.c cVar) {
        if (!o()) {
            try {
                Bundle bundle = C().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                int i10 = bundle != null ? bundle.getInt("com.google.android.wearable.api.version", 0) : 0;
                if (i10 < 8600000) {
                    StringBuilder sb2 = new StringBuilder(82);
                    sb2.append("The Wear OS app is out of date. Requires API version 8600000 but found ");
                    sb2.append(i10);
                    Log.w("WearableClient", sb2.toString());
                    Context C = C();
                    Context C2 = C();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (C2.getPackageManager().resolveActivity(intent, WXMediaMessage.THUMB_LENGTH_LIMIT) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    P(cVar, 6, PendingIntent.getActivity(C, 0, intent, 0));
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                P(cVar, 16, null);
                return;
            }
        }
        super.j(cVar);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String m() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        if (queryLocalInterface instanceof i) {
            return (i) queryLocalInterface;
        }
        return new j(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean o() {
        return !this.N.e("com.google.android.wearable.app.cn");
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int p() {
        return 8600000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String v() {
        return "com.google.android.gms.wearable.BIND";
    }

    private x(Context context, Looper looper, d.b bVar, d.c cVar, b6.c cVar2, ExecutorService executorService, x0 x0Var) {
        super(context, looper, 14, cVar2, bVar, cVar);
        this.F = new k<>();
        this.G = new k<>();
        this.H = new k<>();
        this.I = new k<>();
        this.J = new k<>();
        this.K = new k<>();
        this.L = new k<>();
        this.M = new k<>();
        this.E = (ExecutorService) i.k(executorService);
        this.N = x0Var;
    }
}
