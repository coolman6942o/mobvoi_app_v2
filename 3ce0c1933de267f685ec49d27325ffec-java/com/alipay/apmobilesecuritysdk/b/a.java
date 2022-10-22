package com.alipay.apmobilesecuritysdk.b;

import h4.d;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f6812b = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f6813a = 0;

    public static a a() {
        return f6812b;
    }

    public final void a(int i10) {
        this.f6813a = i10;
    }

    public final int b() {
        return this.f6813a;
    }

    public final String c() {
        String b10 = d.b();
        if (c4.a.g(b10)) {
            return b10;
        }
        int i10 = this.f6813a;
        return i10 != 1 ? i10 != 3 ? i10 != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm" : "http://mobilegw-1-64.test.alipay.net/mgw.htm" : "http://mobilegw.stable.alipay.net/mgw.htm";
    }
}
