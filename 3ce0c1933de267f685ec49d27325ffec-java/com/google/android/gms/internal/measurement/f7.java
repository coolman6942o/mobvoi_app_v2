package com.google.android.gms.internal.measurement;

import android.net.Uri;
/* loaded from: classes.dex */
public final class f7 {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f9279a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9280b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9281c;

    public f7(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private f7(String str, Uri uri, String str2, String str3, boolean z10, boolean z11) {
        this.f9279a = uri;
        this.f9280b = str2;
        this.f9281c = str3;
    }

    public final v6<Double> b(String str, double d10) {
        return v6.i(this, str, d10);
    }

    public final v6<Integer> e(String str, int i10) {
        return v6.j(this, str, i10);
    }

    public final v6<Long> f(String str, long j10) {
        return v6.k(this, str, j10);
    }

    public final v6<Boolean> g(String str, boolean z10) {
        return v6.m(this, str, z10);
    }

    public final v6<String> h(String str, String str2) {
        return v6.l(this, str, str2);
    }
}
