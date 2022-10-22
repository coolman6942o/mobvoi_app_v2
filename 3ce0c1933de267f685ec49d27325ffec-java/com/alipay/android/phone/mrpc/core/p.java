package com.alipay.android.phone.mrpc.core;
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: c  reason: collision with root package name */
    public int f6771c;

    /* renamed from: d  reason: collision with root package name */
    public String f6772d;

    /* renamed from: e  reason: collision with root package name */
    public long f6773e;

    /* renamed from: f  reason: collision with root package name */
    public long f6774f;

    /* renamed from: g  reason: collision with root package name */
    public String f6775g;

    /* renamed from: h  reason: collision with root package name */
    public HttpUrlHeader f6776h;

    public p(HttpUrlHeader httpUrlHeader, int i10, String str, byte[] bArr) {
        this.f6776h = httpUrlHeader;
        this.f6771c = i10;
        this.f6772d = str;
        this.f6797a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f6776h;
    }

    public final void a(long j10) {
        this.f6773e = j10;
    }

    public final void a(String str) {
        this.f6775g = str;
    }

    public final void b(long j10) {
        this.f6774f = j10;
    }
}
