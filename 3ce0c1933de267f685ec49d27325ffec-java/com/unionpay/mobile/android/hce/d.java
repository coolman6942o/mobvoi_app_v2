package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f23364a;

    /* renamed from: b  reason: collision with root package name */
    private String f23365b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f23366c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23367d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23368e = false;

    /* renamed from: f  reason: collision with root package name */
    private ServiceConnection f23369f = null;

    public d(String str) {
        this.f23364a = str;
    }

    public final void a(ServiceConnection serviceConnection) {
        this.f23369f = serviceConnection;
    }

    public final void a(String str) {
        this.f23365b = str;
    }

    public final boolean a() {
        return this.f23367d;
    }

    public final void b(String str) {
        this.f23366c = str;
    }

    public final boolean b() {
        return this.f23368e;
    }

    public final String c() {
        return this.f23365b;
    }

    public final ServiceConnection d() {
        return this.f23369f;
    }

    public final void e() {
        this.f23367d = true;
    }

    public final void f() {
        this.f23368e = true;
    }
}
