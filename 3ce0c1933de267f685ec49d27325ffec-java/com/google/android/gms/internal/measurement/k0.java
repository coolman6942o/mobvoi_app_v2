package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.text.TextUtils;
import b6.i;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    final String f9423a;

    /* renamed from: b  reason: collision with root package name */
    final String f9424b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9425c;

    /* renamed from: d  reason: collision with root package name */
    final long f9426d;

    /* renamed from: e  reason: collision with root package name */
    final long f9427e;

    /* renamed from: f  reason: collision with root package name */
    final zzer f9428f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(d2 d2Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzer zzerVar;
        i.g(str2);
        i.g(str3);
        this.f9423a = str2;
        this.f9424b = str3;
        this.f9425c = TextUtils.isEmpty(str) ? null : str;
        this.f9426d = j10;
        this.f9427e = j11;
        if (j11 != 0 && j11 > j10) {
            d2Var.c().N().d("Event created with reverse previous/current timestamps. appId", z0.I(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzerVar = new zzer(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    d2Var.c().K().a("Param name can't be null");
                } else {
                    Object u02 = d2Var.K().u0(next, bundle2.get(next));
                    if (u02 == null) {
                        d2Var.c().N().d("Param value can't be null", d2Var.J().N(next));
                    } else {
                        d2Var.K().K(bundle2, next, u02);
                    }
                }
                it.remove();
            }
            zzerVar = new zzer(bundle2);
        }
        this.f9428f = zzerVar;
    }

    private k0(d2 d2Var, String str, String str2, String str3, long j10, long j11, zzer zzerVar) {
        i.g(str2);
        i.g(str3);
        i.k(zzerVar);
        this.f9423a = str2;
        this.f9424b = str3;
        this.f9425c = TextUtils.isEmpty(str) ? null : str;
        this.f9426d = j10;
        this.f9427e = j11;
        if (j11 != 0 && j11 > j10) {
            d2Var.c().N().c("Event created with reverse previous/current timestamps. appId, name", z0.I(str2), z0.I(str3));
        }
        this.f9428f = zzerVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final k0 a(d2 d2Var, long j10) {
        return new k0(d2Var, this.f9425c, this.f9423a, this.f9424b, this.f9426d, j10, this.f9428f);
    }

    public final String toString() {
        String str = this.f9423a;
        String str2 = this.f9424b;
        String valueOf = String.valueOf(this.f9428f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + valueOf.length());
        sb2.append("Event{appId='");
        sb2.append(str);
        sb2.append("', name='");
        sb2.append(str2);
        sb2.append("', params=");
        sb2.append(valueOf);
        sb2.append('}');
        return sb2.toString();
    }
}
