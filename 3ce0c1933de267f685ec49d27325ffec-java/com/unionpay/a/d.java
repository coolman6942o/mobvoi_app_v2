package com.unionpay.a;

import java.net.URL;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    private String f23265b;

    /* renamed from: e  reason: collision with root package name */
    private String f23268e;

    /* renamed from: a  reason: collision with root package name */
    private int f23264a = 1;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f23266c = null;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f23267d = null;

    public d(String str) {
        this.f23265b = str;
    }

    public final URL a() {
        try {
            return new URL(this.f23265b);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(String str) {
        if (str != null) {
            this.f23267d = str.getBytes();
            this.f23268e = str;
        }
    }

    public final String b() {
        return this.f23264a == 1 ? "POST" : "GET";
    }

    public final String c() {
        return this.f23268e;
    }

    public final HashMap d() {
        return this.f23266c;
    }
}
